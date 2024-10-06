public class TestClient {
    public static void main(String[] args) {
        // Ajout d'un nouveau client
        Client nouveauClient = new Client("Dupont", "Jean", "jean.dupont@example.com", "0123456789", "motdepasse123", "123 Rue de Paris");
        nouveauClient.ajouterClient();
        
        // Recherche d'un client par nom
        Client clientTrouve = Client.rechercherClientParNom("Dupont");
        if (clientTrouve != null) {
            clientTrouve.afficherClient();
        }

        // Modification des informations du client
        if (clientTrouve != null) {
            clientTrouve.setPrenom("Pierre");
            clientTrouve.modifierClient();
            
            // Afficher le client après modification
            clientTrouve.afficherClient();
        }

        // Suppression du client
        if (clientTrouve != null) {
            clientTrouve.supprimerClient();
        }
        
        // Essayer de rechercher le client après suppression
        Client clientSupprime = Client.rechercherClientParNom("Dupont");
        if (clientSupprime == null) {
            System.out.println("Le client a été supprimé avec succès.");
        }
    }
}
