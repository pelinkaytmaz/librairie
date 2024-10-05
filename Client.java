public class Client {
    private int id;
    private String nom;
    private String email;

    // Constructeur
    public Client(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    // Getter et Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Méthodes CRUD

    // Ajouter un client
    public void ajouterClient() {
        System.out.println("Client ajouté: " + this.nom);
        // Code pour ajouter un client dans la BD
    }

    // Modifier un client
    public void modifierClient() {
        System.out.println("Client modifié: " + this.nom);
        // Code pour mettre à jour le client dans la BD
    }

    // Supprimer un client
    public void supprimerClient() {
        System.out.println("Client supprimé: " + this.nom);
        // Code pour supprimer un client dans la BD
    }

    // Rechercher un client par nom
    public static Client rechercherClientParNom(String nom) {
        System.out.println("Recherche du client: " + nom);
        // Code pour rechercher dans la BD et retourner l'objet Client
        return null; // Remplacer par un client réel
    }

    // Afficher les informations du client
    public void afficherClient() {
        System.out.println("Client: " + this.nom + ", Email: " + this.email);
    }
}
