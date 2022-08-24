package ml.freetirage.apitirage.Service.Implementation;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.Postulant;
import ml.freetirage.apitirage.Model.PostulantTire;
import ml.freetirage.apitirage.Repository.PostulantRepository;
import ml.freetirage.apitirage.Repository.PostulantTireRepository;
import ml.freetirage.apitirage.Service.PostulantService;
import ml.freetirage.apitirage.Service.PostulantTireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostulantTireServiceImpl implements PostulantTireService {
    //private final Postulant postulant;
    private final PostulantRepository postulantRepository;
    private final PostulantTireRepository postulantTireRepository;

    @Override
    public PostulantTire CreerPostulantTire() {

        return null;
    }

    @Override
    public List<PostulantTire> Afficher() {

        return null;
    }
    @Override
    public int InsertPostulant(String nom, String prenom, String numero, String email) {
        return postulantRepository.INSERTPOSTULANT(nom, prenom, numero, email);
    }

    @Override
    public int Listepostulanttire(Long id_postulant, Long id_tirage) {
        return postulantTireRepository.InsertPostulanttire(id_postulant,id_tirage);
    }

}
