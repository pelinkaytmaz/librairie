import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Panier {
    private int panier_id;
    private int client_id; // ID du client
    private Date date_creation;
    private double montant_total;
    private List<PanierItem> items; // Liste des articles dans le panier

    // Constructeur
    public Panier(int client_id) {
        this.client_id = client_id;
        this.date_creation = new Date();
        this.montant_total = 0.0;
        this.items = new ArrayList<>();
    }

    // Getters et Setters
    public int getPanierId() { return panier_id; }
    public void setPanierId(int panier_id) { this.panier_id = panier_id; }

    public int getClientId() { return client_id; }
    public Date getDateCreation() { return date_creation; }
    public double getMontantTotal() { return montant_total; }

    public List<PanierItem> getItems() { return items; }

    // Ajouter un article au panier
    public void ajouterItem(int livre_id, int quantite) {
        double prix = recupererPrixLivre(livre_id); // Récupérer le prix du livre
        PanierItem item = new PanierItem(livre_id, quantite, prix);
        items.add(item);
        // Mise à jour du montant total
        this.montant_total += prix * quantite; // Mise à jour du montant total
        System.out.println("Article ajouté au panier: Livre ID " + livre_id + ", Quantité: " + quantite);
    }

    // Méthode pour récupérer le prix du livre depuis la base de données
    private double recupererPrixLivre(int livre_id) {
        double prix = 0.0;
        String query = "SELECT prix FROM livres WHERE livre_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, livre_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                prix = rs.getDouble("prix");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération du prix du livre: " + e.getMessage());
        }

        return prix;
    }

    // Enregistrer le panier dans la base de données
    public void enregistrerPanier() {
        String query = "INSERT INTO panier (client_id, date_creation, montant_total) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, this.client_id);
            stmt.setDate(2, new java.sql.Date(this.date_creation.getTime()));
            stmt.setDouble(3, this.montant_total);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        this.panier_id = generatedKeys.getInt(1);
                        System.out.println("Panier enregistré avec ID: " + this.panier_id);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'enregistrement du panier: " + e.getMessage());
        }
    }

    // Afficher le contenu du panier
    public void afficherPanier() {
        System.out.println("Panier ID: " + this.panier_id);
        System.out.println("Client ID: " + this.client_id);
        System.out.println("Date de création: " + this.date_creation);
        System.out.println("Montant total: " + this.montant_total);
        System.out.println("Articles dans le panier:");
        for (PanierItem item : items) {
            System.out.println("  - Livre ID: " + item.getLivreId() + ", Quantité: " + item.getQuantite() + ", Prix unitaire: " + item.getPrix());
        }
    }

    // Classe interne pour représenter un article dans le panier
    private static class PanierItem {
        private int livre_id; // ID du livre
        private int quantite; // Quantité de ce livre dans le panier
        private double prix; // Prix du livre

        // Constructeur
        public PanierItem(int livre_id, int quantite, double prix) {
            this.livre_id = livre_id;
            this.quantite = quantite;
            this.prix = prix;
        }

        // Getters
        public int getLivreId() { return livre_id; }
        public int getQuantite() { return quantite; }
        public double getPrix() { return prix; }
    }
}
