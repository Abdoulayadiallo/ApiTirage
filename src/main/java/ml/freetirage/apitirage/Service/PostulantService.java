package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Postulant;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface PostulantService {
    //Declaration des methodes du Service Postulant
    ArrayList<Postulant> InserPostulant(MultipartFile file);

    List<Postulant> Afficher_Postulant();

    Postulant creerPostulant(Postulant postulant);

    List<Postulant> TrouverPostulantId(long id_liste_postulant);
}
