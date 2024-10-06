package back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String motDePasse;
    private String adresse;

    // Constructeur
    public Client(String nom, String prenom, String email, String telephone, String motDePasse, String adresse) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.adresse = adresse;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    // Méthodes CRUD

    // Ajouter un client
    public void ajouterClient() {
        String query = "INSERT INTO clients (nom, prenom, email, telephone, mot_de_passe, adresse) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, this.nom);
            stmt.setString(2, this.prenom);
            stmt.setString(3, this.email);
            stmt.setString(4, this.telephone);
            stmt.setString(5, this.motDePasse);
            stmt.setString(6, this.adresse);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Client ajouté: " + this.nom);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du client: " + e.getMessage());
        }
    }

    // Modifier un client
    public void modifierClient() {
        String query = "UPDATE clients SET nom = ?, prenom = ?, email = ?, telephone = ?, mot_de_passe = ?, adresse = ? WHERE client_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, this.nom);
            stmt.setString(2, this.prenom);
            stmt.setString(3, this.email);
            stmt.setString(4, this.telephone);
            stmt.setString(5, this.motDePasse);
            stmt.setString(6, this.adresse);
            stmt.setInt(7, this.id);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Client modifié: " + this.nom);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du client: " + e.getMessage());
        }
    }

    // Supprimer un client
    public void supprimerClient() {
        String query = "DELETE FROM clients WHERE client_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, this.id);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Client supprimé: " + this.nom);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du client: " + e.getMessage());
        }
    }

    // Rechercher un client par nom
    public static Client rechercherClientParNom(String nom) {
        String query = "SELECT * FROM clients WHERE nom = ?";
        Client client = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                client = new Client(
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("email"),
                    rs.getString("telephone"),
                    rs.getString("mot_de_passe"),
                    rs.getString("adresse")
                );
                System.out.println("Client trouvé: " + client.getNom());
            } else {
                System.out.println("Client non trouvé: " + nom);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche du client: " + e.getMessage());
        }

        return client;
    }

    // Afficher les informations du client
    public void afficherClient() {
        System.out.println("Client: " + this.nom + " " + this.prenom + ", Email: " + this.email + ", Téléphone: " + this.telephone + ", Adresse: " + this.adresse);
    }
}
