package ml.freetirage.apitirage.Controller;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.ListePostulant;
import ml.freetirage.apitirage.Model.Postulant;
import ml.freetirage.apitirage.Model.Tirage;
import ml.freetirage.apitirage.Service.ListePostulantService;
import ml.freetirage.apitirage.Service.PostulantService;
import ml.freetirage.apitirage.Service.PostulantTireService;
import ml.freetirage.apitirage.Service.TirageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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
    @GetMapping("/AfficherTirage")
    public List<Tirage> AfficherTirage(){

        return tirageService.AfficherTirage();
    }
    @GetMapping("/compteParListe")
    public List<Object> compterparListe(){
        return tirageService.NombreParlisteTirage();
    }
    @GetMapping("/NombreListeTire")
    public int nombreListeTire(){
        return tirageService.nombreListeTire();
    }
    @GetMapping("/AfficherListeParId/{id_liste_postulant}")
    public List<Tirage> LienParIdListe(@PathVariable  long id_liste_postulant){
        return tirageService.LienListeTireParId(id_liste_postulant);
    }

}
