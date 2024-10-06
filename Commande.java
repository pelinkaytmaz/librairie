import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Commande {
    private int commande_id;          // ID de la commande
    private int client_id;            // ID du client
    private String date_commande;     // Date de la commande
    private double montant_total;      // Montant total de la commande
    private String statut;             // Statut de la commande (en cours, validée, livrée, annulée)

    // Constructeur
    public Commande(int client_id, String date_commande, double montant_total, String statut) {
        this.client_id = client_id;
        this.date_commande = date_commande;
        this.montant_total = montant_total;
        this.statut = statut;
    }

    // Getters et Setters
    public int getCommandeId() { return commande_id; }
    public void setCommandeId(int commande_id) { this.commande_id = commande_id; }

    public int getClientId() { return client_id; }
    public void setClientId(int client_id) { this.client_id = client_id; }

    public String getDateCommande() { return date_commande; }
    public void setDateCommande(String date_commande) { this.date_commande = date_commande; }

    public double getMontantTotal() { return montant_total; }
    public void setMontantTotal(double montant_total) { this.montant_total = montant_total; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    // Méthodes CRUD


    // Ajouter une commande
    public void ajouterCommande() {
    String query = "INSERT INTO commandes (client_id, date_commande, montant_total, statut) VALUES (?, ?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

        stmt.setInt(1, this.client_id);
        stmt.setString(2, this.date_commande);
        stmt.setDouble(3, this.montant_total);
        stmt.setString(4, this.statut);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    this.commande_id = generatedKeys.getInt(1);  // Récupérer l'ID généré
                    System.out.println("Commande ajoutée avec ID: " + this.commande_id + "pour le client ID:" + this.client_id);
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'ajout de la commande: " + e.getMessage());
    }
}


    // Modifier une commande
    public void modifierCommande() {
        String query = "UPDATE commandes SET client_id = ?, date_commande = ?, montant_total = ?, statut = ? WHERE commande_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, this.client_id);
            stmt.setString(2, this.date_commande);
            stmt.setDouble(3, this.montant_total);
            stmt.setString(4, this.statut);
            stmt.setInt(5, this.commande_id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Commande (ID" +this.commande_id + ") modifiée pour le client ID: " + this.client_id);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de la commande: " + e.getMessage());
        }
    }

    // Supprimer une commande
    public void supprimerCommande() {
        String query = "DELETE FROM commandes WHERE commande_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, this.commande_id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Commande supprimée pour le client ID: " + this.client_id);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la commande: " + e.getMessage());
        }
    }

    // Supprimer une commande si le statut est "annulée"
    public void annulerCommande() {
        if (this.statut.equalsIgnoreCase("annulée")) {
            supprimerCommande();
        } else {
            System.out.println("La commande ne peut pas être annulée car son statut n'est pas 'annulée'.");
        }
    }

    // Rechercher une commande par ID
    public static Commande rechercherCommandeParId(int commande_id) {
        String query = "SELECT * FROM commandes WHERE commande_id = ?";
        Commande commande = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, commande_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                commande = new Commande(
                    rs.getInt("client_id"),
                    rs.getString("date_commande"),
                    rs.getDouble("montant_total"),
                    rs.getString("statut")
                );
                commande.setCommandeId(rs.getInt("commande_id"));
                System.out.println("Commande trouvée pour le client ID: " + commande.getClientId());
            } else {
                System.out.println("Commande non trouvée pour l'ID: " + commande_id);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de la commande: " + e.getMessage());
        }

        return commande;
    }

    // Afficher les informations de la commande
    public void afficherCommande() {
        System.out.println("Commande ID: " + this.commande_id + 
                           ", Client ID: " + this.client_id + 
                           ", Date: " + this.date_commande + 
                           ", Montant Total: " + this.montant_total + 
                           ", Statut: " + this.statut);
    }
}
