package ml.freetirage.apitirage.Service.Implementation;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.PostulantTire;
import ml.freetirage.apitirage.Repository.PostulantTireRepository;
import ml.freetirage.apitirage.Service.PostulantTireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostulantTireServiceImpl implements PostulantTireService {
   @Autowired
   private final PostulantTireRepository postulantTireRepository;


//    @Override
//    public int CreerPostulantTire(Long id_postulant, Long id_tirage) {
//        return postulantTireRepository.InsererPostulantTire(id_postulant,id_tirage);
//    }

    @Override
    public List<PostulantTire> Afficher() {
        return postulantTireRepository.findAll();
    }




}
