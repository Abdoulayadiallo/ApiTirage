package ml.freetirage.apitirage.Service.Implementation;

import ml.freetirage.apitirage.Modele.Postulant;
import ml.freetirage.apitirage.Repository.PostulantRepository;
import ml.freetirage.apitirage.Service.PostulantService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostulantServiceImpl implements PostulantService {

    @Autowired
    PostulantRepository postulantRepository;

    @Override
    public Postulant Ajouter(Postulant postulant) {
        return postulantRepository.save(postulant);
    }

    @Override
    public List<Postulant> Afficher() {
        return postulantRepository.findAll();
    }

    @Override
    public Postulant Modifier(Postulant postulant, Long id_postulant) {
        return postulantRepository.findById(id_postulant)
                .map(p->{
                    p.setPrenom(postulant.getPrenom());
                    p.setNom(postulant.getNom());
                    p.setEmail(postulant.getEmail());
                    p.setNumero(postulant.getNumero());

                    return postulantRepository.save(p);
        }).orElseThrow(()-> new RuntimeException("Postulant non trouvé"));
    }

    @Override
    public String Supprimer(Long id_postulant) {
        postulantRepository.deleteById(id_postulant);
        return "Postulant Supprimé";
    }
}
