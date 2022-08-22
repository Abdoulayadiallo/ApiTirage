package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Postulant;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface PostulantService {
    //Declaration des methodes du Service Postulant
    ArrayList<Postulant> INSERPostulant(MultipartFile file);

    Iterable<Object[]> Afficher_Postulant();

    Postulant creerPostulant(Postulant postulant);
}
