package librairie.services;

import java.util.List;

import librairie.models.Auteurs;
import librairie.repositories.AuteursRepository;

public class AuteursService {

    private AuteursRepository auteursRepository = new AuteursRepository();

    /**
     * retrieve all the authors available in the DB
     * 
     * @return List<Auteurs>
     */
    public List<Auteurs> getAllAuteurs() {
        return auteursRepository.findAll();
    }

}
