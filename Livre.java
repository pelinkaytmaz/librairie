import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Livre {
    private int livre_id;
    private String titre;
    private int auteur_id;  // ID de l'auteur dans une table "auteurs"
    private int genre_id;  // ID du genre littéraire dans une table "genres"
    private double prix;
    private String description;
    private int stock;

    // Constructeur
    public Livre(String titre, int auteur_id, int genre_id, double prix, String description, int stock) {
        this.titre = titre;
        this.auteur_id = auteur_id;
        this.genre_id = genre_id;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
    }

    // Getters et Setters
    public int getLivreId() {
        return livre_id;
    }

    public void setLivreId(int livre_id) {
        this.livre_id = livre_id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAuteurId() {
        return auteur_id;
    }

    public void setAuteurId(int auteur_id) {
        this.auteur_id = auteur_id;
    }

    public int getGenreId() {
        return genre_id;
    }

    public void setGenreId(int genre_id) {
        this.genre_id = genre_id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Méthodes CRUD

    public void ajouterLivre() {
        String query = "INSERT INTO livres (titre, auteur_id, genre_id, prix, description, stock) VALUES (?, ?, ?, ?, ?, ?)";
    
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
    
            stmt.setString(1, this.titre);
            stmt.setInt(2, this.auteur_id);
            stmt.setInt(3, this.genre_id);
            stmt.setDouble(4, this.prix);
            stmt.setString(5, this.description);
            stmt.setInt(6, this.stock);
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    this.livre_id = generatedKeys.getInt(1); // Met à jour l'ID du livre
                }
                System.out.println("Livre ajouté: " + this.titre);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du livre: " + e.getMessage());
        }
    }
    

    // Modifier un livre
    public void modifierLivre() {
        String query = "UPDATE livres SET titre = ?, auteur_id = ?, genre_id = ?, prix = ?, description = ?, stock = ? WHERE livre_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, this.titre);
            stmt.setInt(2, this.auteur_id);
            stmt.setInt(3, this.genre_id);
            stmt.setDouble(4, this.prix);
            stmt.setString(5, this.description);
            stmt.setInt(6, this.stock);
            stmt.setInt(7, this.livre_id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livre modifié: " + this.titre);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du livre: " + e.getMessage());
        }
    }

    // // Supprimer un livre
    // public void supprimerLivre() {
    //     String query = "DELETE FROM livres WHERE livre_id = ?";

    //     try (Connection conn = DatabaseConnection.getConnection();
    //          PreparedStatement stmt = conn.prepareStatement(query)) {
            
    //         stmt.setInt(1, this.livre_id);

    //         int rowsAffected = stmt.executeUpdate();
    //         if (rowsAffected > 0) {
    //             System.out.println("Livre supprimé: " + this.titre);
    //         }
    //     } catch (SQLException e) {
    //         System.out.println("Erreur lors de la suppression du livre: " + e.getMessage());
    //     }
    // }

    // Rechercher un livre par mots-clés
    public static List<Livre> rechercherLivre(String[] motsCles) {
        List<Livre> livresTrouves = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM livres WHERE ");

        for (int i = 0; i < motsCles.length; i++) {
            query.append("titre LIKE ?");
            if (i < motsCles.length - 1) {
                query.append(" OR ");
            }
        }

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query.toString())) {

            for (int i = 0; i < motsCles.length; i++) {
                stmt.setString(i + 1, "%" + motsCles[i] + "%");
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Livre livre = new Livre(
                    rs.getString("titre"),
                    rs.getInt("auteur_id"),
                    rs.getInt("genre_id"),
                    rs.getDouble("prix"),
                    rs.getString("description"),
                    rs.getInt("stock")
                );
                livresTrouves.add(livre);
            }

         } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche des livres: " + e.getMessage());
        }

        return livresTrouves;
    }


    // Afficher les informations du livre
    public void afficherLivre() {
        System.out.println("Livre: " + this.titre + ", Auteur ID: " + this.auteur_id + ", Genre ID: " + this.genre_id +
                           ", Prix: " + this.prix + ", Stock: " + this.stock + ", Description: " + this.description);
    }
}
