package ml.freetirage.apitirage.Service.Implementation;


import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.ListePostulant;
import ml.freetirage.apitirage.Model.Postulant;
import ml.freetirage.apitirage.Repository.ListePostulantRepository;
import ml.freetirage.apitirage.Service.ListePostulantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListePostulantImpl implements ListePostulantService {
    @Autowired
    private final ListePostulantRepository listePostulantRepository;
    @Override
    public ListePostulant Ajouter_Liste(ListePostulant listepostulant) {
        return listePostulantRepository.save(listepostulant);
    }


    @Override
    public List<ListePostulant> Afficher_Liste() {
        return listePostulantRepository.findAll();
    }


}
