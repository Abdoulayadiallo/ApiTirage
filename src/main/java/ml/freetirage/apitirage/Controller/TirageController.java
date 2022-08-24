package ml.freetirage.apitirage.Controller;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.ListePostulant;
import ml.freetirage.apitirage.Model.Postulant;
import ml.freetirage.apitirage.Model.PostulantTire;
import ml.freetirage.apitirage.Model.Tirage;
import ml.freetirage.apitirage.Service.ListePostulantService;
import ml.freetirage.apitirage.Service.PostulantService;
import ml.freetirage.apitirage.Service.PostulantTireService;
import ml.freetirage.apitirage.Service.TirageService;
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

    private final PostulantTireService postulantTireService;

    private final ListePostulantService listePostulantService;

    @PostMapping("/CreerTirage/{libele}/{n_tirage}")
    public String CreerTirage(@RequestBody Tirage tirage, @PathVariable String libele, @PathVariable long n_tirage) {

        ListePostulant liste = listePostulantService.trouverListeparLibele(libele);
        List<Postulant> post = postulantService.TrouverPostulantId(liste.getId_liste_postulant());

        List<Postulant> lp = tirageService.creerTirage(tirage,post,n_tirage);
       // long  id_tirage = tirageService.trouverTirageParLibelle(tirage.getLibele()).getId_tirage();
       // for (Postulant p : lp) {
           // p.setListePostulant(liste);
           // postulantTireService.CreerPostulantTire(p.getId_postulant(),id_tirage);
       // }
        return "Tirage effectué avec succès !";


    }

}
