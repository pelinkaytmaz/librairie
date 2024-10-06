package back;
import java.util.List;

public class TestLivre {
    public static void main(String[] args) {
        // Ajouter un nouveau livre
        Livre nouveauLivre = new Livre("Le Petit Prince", 1, 1, 10.99, "Un livre sur l'amitié et l'amour.", 5);
        nouveauLivre.ajouterLivre();

        // Modifier le livre ajouté
        nouveauLivre.setPrix(12.99); // Changer le prix
        nouveauLivre.modifierLivre();

        // Rechercher un livre par mots-clés
        String[] motsCles = {"1984"};
        List<Livre> livresTrouves = Livre.rechercherLivre(motsCles);
        
        System.out.println("Livres trouvés : ");
        for (Livre livre : livresTrouves) {
            livre.afficherLivre();
        }

        
    }
}
