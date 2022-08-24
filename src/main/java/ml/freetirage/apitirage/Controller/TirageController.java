package ml.freetirage.apitirage.Controller;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.ListePostulant;
import ml.freetirage.apitirage.Model.Postulant;
import ml.freetirage.apitirage.Model.Tirage;
import ml.freetirage.apitirage.Repository.PostulantTireRepository;
import ml.freetirage.apitirage.Service.ListePostulantService;
import ml.freetirage.apitirage.Service.PostulantService;
import ml.freetirage.apitirage.Service.PostulantTireService;
import ml.freetirage.apitirage.Service.TirageService;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@RestController
@RequestMapping("/Tirage")
public class TirageController {
    @Autowired
    private final TirageService tirageService;

    private final PostulantService postulantService;
    //private final ListePostulantService listePostulantService;

    private final ListePostulantService listePostulantService;
    //PostulantTireRepository postulantTireRepository;
    @Autowired
   private final PostulantTireService postulantTireService;

    @PostMapping("/CreerTirage/{libele}/{nbr}")
    public List<Postulant> CreerTirage(@RequestBody Tirage tirage, @PathVariable String libele, @PathVariable int nbr){

        Tirage t = tirageService.CreerTirage(tirage);
        Long liste_id = listePostulantService.trouverListeParLibele(libele).getId_liste_postulant();

        List<Postulant> listAtrier = postulantService.trouverListPostulantParId(liste_id);

        Random random = new Random();
        List<Postulant> postulant = new ArrayList<>();

        for (int i = 0; i < nbr; i++){
            Integer nb_Aleatoire = random.nextInt(listAtrier.size());

            postulant.add(listAtrier.get(nb_Aleatoire));

            listAtrier.remove(listAtrier.get(nb_Aleatoire));

        }
        for(Postulant p: postulant){
            postulantTireService.Listepostulanttire(p.getIdpostulant(), t.getId_tirage());
        }

        return postulant;
    }


}
