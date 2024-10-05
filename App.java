public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

    // Création d'un objet Livre
Livre livre1 = new Livre(1, "1984", 2, 1, 15.99, "Dystopie de George Orwell", 30);

// Ajout du livre à la base de données
livre1.ajouterLivre();

// Modification du livre
livre1.setPrix(17.99);
livre1.modifierLivre();

// Recherche du livre par titre
Livre livreTrouve = Livre.rechercherLivreParTitre("1984");

// Suppression du livre
livre1.supprimerLivre();

// Affichage des informations du livre
livre1.afficherLivre();

    }
}

