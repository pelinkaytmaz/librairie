import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Livre {
    private int id;
    private String titre;
    private int auteurId;  // ID de l'auteur dans une table "auteurs"
    private int genreId;  // ID du genre littéraire dans une table "genres"
    private double prix;
    private String description;
    private int stock;

    // Constructeur
    public Livre(int id, String titre, int auteurId, int genreId, double prix, String description, int stock) {
        this.id = id;
        this.titre = titre;
        this.auteurId = auteurId;
        this.genreId = genreId;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(int auteurId) {
        this.auteurId = auteurId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
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

    // Ajouter un livre
    public void ajouterLivre() {
        String query = "INSERT INTO livres (id, titre, auteur_id, genre_id, prix, description, stock) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, this.id);
            stmt.setString(2, this.titre);
            stmt.setInt(3, this.auteurId);
            stmt.setInt(4, this.genreId);
            stmt.setDouble(5, this.prix);
            stmt.setString(6, this.description);
            stmt.setInt(7, this.stock);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livre ajouté: " + this.titre);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du livre: " + e.getMessage());
        }
    }

    // Modifier un livre
    public void modifierLivre() {
        String query = "UPDATE livres SET titre = ?, auteur_id = ?, genre_id = ?, prix = ?, description = ?, stock = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, this.titre);
            stmt.setInt(2, this.auteurId);
            stmt.setInt(3, this.genreId);
            stmt.setDouble(4, this.prix);
            stmt.setString(5, this.description);
            stmt.setInt(6, this.stock);
            stmt.setInt(7, this.id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livre modifié: " + this.titre);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du livre: " + e.getMessage());
        }
    }

    // Supprimer un livre
    public void supprimerLivre() {
        String query = "DELETE FROM livres WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, this.id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livre supprimé: " + this.titre);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du livre: " + e.getMessage());
        }
    }

    // Rechercher un livre par titre
    public static Livre rechercherLivreParTitre(String titre) {
        String query = "SELECT * FROM livres WHERE titre = ?";
        Livre livre = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, titre);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                livre = new Livre(
                    rs.getInt("id"),
                    rs.getString("titre"),
                    rs.getInt("auteur_id"),
                    rs.getInt("genre_id"),
                    rs.getDouble("prix"),
                    rs.getString("description"),
                    rs.getInt("stock")
                );
                System.out.println("Livre trouvé: " + livre.getTitre());
            } else {
                System.out.println("Livre non trouvé: " + titre);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche du livre: " + e.getMessage());
        }

        return livre;
    }

    // Afficher les informations du livre
    public void afficherLivre() {
        System.out.println("Livre: " + this.titre + ", Auteur ID: " + this.auteurId + ", Genre ID: " + this.genreId +
                           ", Prix: " + this.prix + ", Stock: " + this.stock + ", Description: " + this.description);
    }
}
