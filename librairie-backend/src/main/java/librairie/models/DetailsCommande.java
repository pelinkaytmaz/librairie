package librairie.models;

public class DetailsCommande {

    private Integer detail_id;
    private Integer commande_id;
    private Integer livre_id;
    private Integer quantite;
    private Integer prix_unitaire;

    public DetailsCommande() {
    }

    public Integer getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(Integer detail_id) {
        this.detail_id = detail_id;
    }

    public Integer getCommande_id() {
        return commande_id;
    }

    public void setCommande_id(Integer commande_id) {
        this.commande_id = commande_id;
    }

    public Integer getLivre_id() {
        return livre_id;
    }

    public void setLivre_id(Integer livre_id) {
        this.livre_id = livre_id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Integer prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

}
