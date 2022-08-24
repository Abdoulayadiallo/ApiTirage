package ml.freetirage.apitirage.Controller;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.Postulant;
import ml.freetirage.apitirage.Model.Tirage;
import ml.freetirage.apitirage.Service.ListePostulantService;
import ml.freetirage.apitirage.Service.PostulantService;
import ml.freetirage.apitirage.Service.TirageService;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private final ListePostulantService listePostulantService;
    @PostMapping("/CreerTirage")
    public String CreerTirage(@RequestBody Tirage tirage){

        tirageService.CreerTirage(tirage);
        Random random = new Random();
        List<Postulant> postulant = new ArrayList<>();

        for (int i = 0; i<tirage.getN_tirage();i++){
            long nb_Aleatoire = random.nextLong(postulantService.NombrePostulant());

            ArrayList<Integer> ListeNombreAleatoire = new ArrayList<>();

            ListeNombreAleatoire.add((int) nb_Aleatoire);

        }

        return "Succes";
    }

    @Autowired
    private final TirageService tirageService;

    private final PostulantService postulantService;

    private final ListePostulantService listePostulantService;
    @PostMapping("/CreerTirage")
    public String CreerTirage(@RequestBody Tirage tirage){

        tirageService.CreerTirage(tirage);
        Random random = new Random();
        List<Postulant> postulant = new ArrayList<>();

        for (int i = 0; i<tirage.getN_tirage();i++){
            long nb_Aleatoire = random.nextLong(postulantService.NombrePostulant());

            ArrayList<Integer> ListeNombreAleatoire = new ArrayList<>();

            ListeNombreAleatoire.add((int) nb_Aleatoire);

        }

        return "Succes";
    }

}
