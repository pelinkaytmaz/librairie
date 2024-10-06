package back;
public class TestFacture {
    public static void main(String[] args) {
        // Test 1: Ajouter une nouvelle facture
        Facture facture1 = new Facture(1, "2024-10-06", 100.50);
        facture1.ajouterFacture(); // Assurez-vous que la commande avec ID 1 existe dans la base de données.

        // Test 2: Rechercher une facture par ID
        Facture factureTrouvee = Facture.rechercherFactureParId(1);
        if (factureTrouvee != null) {
            factureTrouvee.afficherFacture(); // Affiche les détails de la facture trouvée
        }

        // Test 3: Modifier la facture
        if (factureTrouvee != null) {
            factureTrouvee.setMontantTotal(150.75);
            factureTrouvee.setDateFacture("2024-10-07");
            factureTrouvee.modifierFacture();
            factureTrouvee.afficherFacture(); // Affiche les détails de la facture après modification
        }

        // Test 4: Supprimer la facture
        if (factureTrouvee != null) {
            factureTrouvee.supprimerFacture(); // Supprime la facture
            Facture factureSupprimee = Facture.rechercherFactureParId(1);
            if (factureSupprimee == null) {
                System.out.println("La facture a été supprimée avec succès.");
            } else {
                System.out.println("Erreur lors de la suppression de la facture.");
            }
        }
    }
}
