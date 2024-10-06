package back;
public class TestCommande {
    public static void main(String[] args) {
        // Test 1: Créer une commande pour un client avec ID 1
        Commande commande = new Commande(1, "2024-10-06", 100.0, "en cours");
        System.out.println("Commande créée pour le client ID: " + commande.getClientId());

        // Test 2: Ajouter la commande à la base de données
        commande.ajouterCommande();

        // Test 3: Rechercher la commande par ID (après l'ajout, ID doit être récupéré)
        Commande commandeVerifie = Commande.rechercherCommandeParId(commande.getCommandeId());
        if (commandeVerifie != null) {
            commandeVerifie.afficherCommande();
        } else {
            System.out.println("Erreur lors de la recherche de la commande.");
        }

        // Test 4: Modifier la commande
        commandeVerifie.setStatut("validée");
        commandeVerifie.setMontantTotal(120.0);
        commandeVerifie.modifierCommande();
        System.out.println("Commande modifiée.");

        // Test 5: Rechercher et afficher la commande modifiée
        Commande commandeModifiee = Commande.rechercherCommandeParId(commandeVerifie.getCommandeId());
        commandeModifiee.afficherCommande();

        // Test 6: Annuler la commande (si le statut est "annulée")
        commandeModifiee.setStatut("annulée");
        commandeModifiee.annulerCommande();

        // Test 7: Vérifier que la commande a été supprimée
        Commande commandeSupprimee = Commande.rechercherCommandeParId(commandeModifiee.getCommandeId());
        if (commandeSupprimee == null) {
            System.out.println("Commande supprimée avec succès.");
        } else {
            System.out.println("Erreur: La commande n'a pas été supprimée.");
        }
    }
}
