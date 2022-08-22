package ml.freetirage.apitirage.Service.Implementation;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.Tirage;
import ml.freetirage.apitirage.Repository.TirageRepository;
import ml.freetirage.apitirage.Service.TirageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TirageServiceImpl implements TirageService {
    @Autowired
    private TirageRepository tirageRepository;


    @Override
    public Tirage CreerTirage(Tirage tirage) {
        return tirageRepository.save(tirage);
    }

    @Override
    public List<Tirage> AfficherTirage() {
        return tirageRepository.findAll();
    }
}
