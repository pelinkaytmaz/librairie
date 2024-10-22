package librairie.repositories;

import java.util.List;

import librairie.DatabaseConnection;
import librairie.models.Auteurs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AuteursRepository {

    public List<Auteurs> findAll() {
        List<Auteurs> auteurs = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM auteurs");
                while (resultSet.next()) {
                    // For each result of the query we create the object and set the properties
                    Auteurs auteur = new Auteurs();
                    auteur.setAuteurId(resultSet.getInt("auteur_id"));
                    auteur.setDateNaissance(resultSet.getDate("date_naissance"));
                    auteur.setNationalite(resultSet.getString("nationalite"));
                    auteur.setNom(resultSet.getString("nom"));
                    auteur.setPrenom(resultSet.getString("prenom"));
                    // We add the object to the list
                    auteurs.add(auteur);
                }
            }
        } catch (Exception e) {
            // TODO Modifier l'exception
            e.printStackTrace();
        }
        return auteurs;
    }

}
