package ml.freetirage.apitirage.Service.Implementation;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.Postulant;
import ml.freetirage.apitirage.Model.Tirage;
import ml.freetirage.apitirage.Repository.PostulantRepository;
import ml.freetirage.apitirage.Repository.TirageRepository;
import ml.freetirage.apitirage.Service.TirageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class TirageServiceImpl implements TirageService {
    @Autowired
    private TirageRepository tirageRepository;
    private final PostulantRepository postulantRepository;


    @Override
    public List<Postulant> creerTirage(@RequestBody Tirage tirage, List<Postulant> listAtrier, long n_tirage) {
        Random rand = new Random();

        List<Postulant> list = new ArrayList<>();

        for (int i = 0; i < n_tirage; i++) {
            Integer idAct = rand.nextInt(listAtrier.size());

            list.add(listAtrier.get(idAct));

            listAtrier.remove(listAtrier.get(idAct));

        }
        Tirage t=tirageRepository.save(tirage);
        for (Postulant p:list)
        {
            p.getTirage().add(t);
            postulantRepository.save(p);
        }
        tirageRepository.save(tirage);
        return list;

    }
    @Override
    public Tirage trouverTirageParLibelle(String libelletirage) {
        return tirageRepository.findBylibele(libelletirage);
    }

    @Override
    public List<Tirage> AfficherTirage() {
        return tirageRepository.findAll();
    }
}
