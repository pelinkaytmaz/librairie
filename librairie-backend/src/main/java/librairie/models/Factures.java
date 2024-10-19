package librairie.models;

import java.sql.Date;

public class Factures {
    private Integer facture_id;
    private Integer commande_id;
    private double montant_total;
    private Date date_facture;

    // Constructeur
    public Factures() {
    }

    // Getters et Setters
    public Integer getFactureId() {
        return facture_id;
    }

    public void setFactureId(Integer facture_id) {
        this.facture_id = facture_id;
    }

    public Integer getCommandeId() {
        return commande_id;
    }

    public void setCommandeId(Integer commande_id) {
        this.commande_id = commande_id;
    }

    public double getMontantTotal() {
        return montant_total;
    }

    public void setMontantTotal(double montant_total) {
        this.montant_total = montant_total;
    }

    public Date getDateFacture() {
        return date_facture;
    }

    public void setDateFacture(Date date_facture) {
        this.date_facture = date_facture;
    }

}
