public class TestPanier {
    public static void main(String[] args) {
        // Test 1: Créer un panier pour un client avec ID 1
        Panier panier = new Panier(1);
        System.out.println("Panier créé pour le client ID: " + panier.getClientId());

        // Test 2: Ajouter des articles au panier
        panier.ajouterItem(1, 2); // Ajoute 2 exemplaires du livre avec ID 1
        panier.ajouterItem(2, 1); // Ajoute 1 exemplaire du livre avec ID 2

        // Test 3: Afficher le contenu du panier
        panier.afficherPanier();

        // Test 4: Enregistrer le panier dans la base de données
        panier.enregistrerPanier();
    }   
}
