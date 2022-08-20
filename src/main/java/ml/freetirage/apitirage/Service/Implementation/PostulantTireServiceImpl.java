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
    PostulantTireRepository postulanttirerepository;

    @Override
    @Autowired
    public List<PostulantTire> Afficher() {
        return postulanttirerepository.findAll();
    }
}