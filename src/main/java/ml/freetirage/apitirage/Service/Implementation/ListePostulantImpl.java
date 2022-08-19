package ml.freetirage.apitirage.Service.Implementation;


import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.ListePostulant;
import ml.freetirage.apitirage.Repository.ListePostulantRepository;
import ml.freetirage.apitirage.Service.ListePostulantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ListePostulantImpl implements ListePostulantService {
    @Autowired
    ListePostulantRepository listePostulantRepository;
    @Override
    public ListePostulant Ajouter(ListePostulant listepostulant) {
        return listePostulantRepository.save(listepostulant);
    }

    @Override
    public List<ListePostulant> Afficher() {
        return listePostulantRepository.findAll();
    }
    @Override
    public ListePostulant Modifier(ListePostulant listepostulant, Long id_liste_postulant) {

        return listePostulantRepository.findById(id_liste_postulant)
                .map(lp->{
                    lp.setLibele(listepostulant.getLibele());
                    lp.setDateListe(listepostulant.getDateListe());
                    lp.setNbr_postulant(listepostulant.getNbr_postulant());

                    return listePostulantRepository.save(lp);
                }).orElseThrow(()-> new RuntimeException("Postulant non trouvé"));
    }

    @Override
    public String Supprimer(Long id_liste_Postulant) {
        return null;
    }

}
