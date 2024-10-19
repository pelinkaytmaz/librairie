package librairie.models;

public class Genres {

    private Integer genre_id;
    private String nom_genre;

    public Genres() {
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public String getNom_genre() {
        return nom_genre;
    }

    public void setNom_genre(String nom_genre) {
        this.nom_genre = nom_genre;
    }

}
