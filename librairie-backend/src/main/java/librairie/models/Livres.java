package librairie.models;

public class Livres {
    private Integer livre_id;
    private String titre;
    private Integer auteur_id;
    private Integer genre_id;
    private double prix;
    private String description;
    private Integer stock;

    // Constructeur
    public Livres() {
    }

    public Integer getLivre_id() {
        return livre_id;
    }

    public void setLivre_id(Integer livre_id) {
        this.livre_id = livre_id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getAuteur_id() {
        return auteur_id;
    }

    public void setAuteur_id(Integer auteur_id) {
        this.auteur_id = auteur_id;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
