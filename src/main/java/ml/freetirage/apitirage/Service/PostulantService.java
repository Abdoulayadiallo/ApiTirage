package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Postulant;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PostulantService {
    //Declaration des methodes du Service Postulant
    ArrayList<Postulant> InserPostulant(MultipartFile file);

    Iterable<Object[]> Afficher_Postulant();

    Postulant creerPostulant(Postulant postulant);

    long NombrePostulant();
    List<Postulant> TrouverPostulantId(long id_postulant);
}
