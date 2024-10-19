package librairie.models;

import java.sql.Date;

public class Avis {

    private Integer avisId;
    private Integer clientId;
    private Integer livre_id;
    private Integer note;
    private String commentaire;
    private Date dateAvis;

    public Avis() {
    }

    public Integer getAvisId() {
        return avisId;
    }

    public void setAvisId(Integer avisId) {
        this.avisId = avisId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getLivre_id() {
        return livre_id;
    }

    public void setLivre_id(Integer livre_id) {
        this.livre_id = livre_id;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDateAvis() {
        return dateAvis;
    }

    public void setDateAvis(Date dateAvis) {
        this.dateAvis = dateAvis;
    }

}
