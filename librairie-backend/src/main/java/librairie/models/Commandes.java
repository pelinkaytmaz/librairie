package librairie.models;

import librairie.models.enums.Statut;

public class Commandes {
    private Integer commande_id;
    private Integer client_id;
    private String date_commande;
    private double montant_total;
    private Statut statut;

    // Constructeur
    public Commandes() {
    }

    // Getters et Setters
    public Integer getCommandeId() {
        return commande_id;
    }

    public void setCommandeId(Integer commande_id) {
        this.commande_id = commande_id;
    }

    public Integer getClientId() {
        return client_id;
    }

    public void setClientId(Integer client_id) {
        this.client_id = client_id;
    }

    public String getDateCommande() {
        return date_commande;
    }

    public void setDateCommande(String date_commande) {
        this.date_commande = date_commande;
    }

    public double getMontantTotal() {
        return montant_total;
    }

    public void setMontantTotal(double montant_total) {
        this.montant_total = montant_total;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

}
