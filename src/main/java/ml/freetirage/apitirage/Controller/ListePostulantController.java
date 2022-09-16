package ml.freetirage.apitirage.Controller;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.ListePostulant;
import ml.freetirage.apitirage.Service.ListePostulantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
@RequestMapping("/ListePostulant")
public class ListePostulantController {
    @Autowired
    ListePostulantService listePostulantService;
    @PostMapping("/Ajout")
    public ListePostulant Ajouter(@RequestBody ListePostulant listepostulant) {
        return listePostulantService.Ajouter_Liste(listepostulant);
    }

    @GetMapping("/Afficher")
    public List<ListePostulant> Afficher() {
        return listePostulantService.Afficher_Liste();
    }
    @GetMapping("/AfficherListe")
    public Iterable<Object[]> AfficherListe(){
       return listePostulantService.AfficherListe();
    }




}
