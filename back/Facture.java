package back;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Facture {
    private int facture_id;           // ID de la facture
    private int commande_id;          // ID de la commande associée
    private double montant_total;      // Montant total de la facture
    private String date_facture;      // Date de la facture

    // Constructeur
    public Facture(int commande_id, String date_facture, double montant_total) {
        this.commande_id = commande_id;
        this.date_facture = date_facture;
        this.montant_total = montant_total;
    }

    // Getters et Setters
    public int getFactureId() { return facture_id; }
    public void setFactureId(int facture_id) { this.facture_id = facture_id; }

    public int getCommandeId() { return commande_id; }
    public void setCommandeId(int commande_id) { this.commande_id = commande_id; }

    public double getMontantTotal() { return montant_total; }
    public void setMontantTotal(double montant_total) { this.montant_total = montant_total; }

    public String getDateFacture() { return date_facture; }
    public void setDateFacture(String date_facture) { this.date_facture = date_facture; }

    // Méthodes CRUD

    // Ajouter une facture
    public void ajouterFacture() {
        String query = "INSERT INTO factures (commande_id, montant_total, date_facture) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, this.commande_id);
            stmt.setDouble(2, this.montant_total);
            stmt.setString(3, this.date_facture);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Facture ajoutée pour la commande ID: " + this.commande_id);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la facture: " + e.getMessage());
        }
    }

    // Modifier une facture
    public void modifierFacture() {
        String query = "UPDATE factures SET commande_id = ?, montant_total = ?, date_facture = ? WHERE facture_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, this.commande_id);
            stmt.setDouble(2, this.montant_total);
            stmt.setString(3, this.date_facture);
            stmt.setInt(4, this.facture_id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Facture modifiée pour la commande ID: " + this.commande_id);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de la facture: " + e.getMessage());
        }
    }

    // Supprimer une facture
    public void supprimerFacture() {
        String query = "DELETE FROM factures WHERE facture_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, this.facture_id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Facture supprimée pour la commande ID: " + this.commande_id);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la facture: " + e.getMessage());
        }
    }

    // Rechercher une facture par ID
    public static Facture rechercherFactureParId(int facture_id) {
        String query = "SELECT * FROM factures WHERE facture_id = ?";
        Facture facture = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, facture_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                facture = new Facture(
                    rs.getInt("commande_id"),
                    rs.getString("date_facture"),
                    rs.getDouble("montant_total")
                );
                facture.setFactureId(rs.getInt("facture_id"));
                System.out.println("Facture trouvée pour la commande ID: " + facture.getCommandeId());
            } else {
                System.out.println("Facture non trouvée pour l'ID: " + facture_id);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de la facture: " + e.getMessage());
        }

        return facture;
    }


    // Afficher les informations de la facture
    public void afficherFacture() {
        System.out.println("Facture ID: " + this.facture_id + ", Commande ID: " + this.commande_id + 
                           ", Date: " + this.date_facture + ", Montant Total: " + this.montant_total);
    }
}
