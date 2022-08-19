package ml.freetirage.apitirage.Controller;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.ListePostulant;
import ml.freetirage.apitirage.Service.ListePostulantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/ListePostulant")
public class ListePostulantController {
    @Autowired
    ListePostulantService listePostulantService;
    @PostMapping("/Ajout")
    public ListePostulant Ajouter(@RequestBody ListePostulant listepostulant) {
        return listePostulantService.Ajouter(listepostulant);
    }

    @GetMapping("/Afficher")
    public List<ListePostulant> Afficher() {
        return listePostulantService.Afficher();
    }

    @PutMapping("/Modifier")
    public ListePostulant Supprimer(@PathVariable Long id_liste_postulant, @RequestBody ListePostulant listepostulant) {
        return listePostulantService.Modifier(listepostulant, id_liste_postulant);

    }

    @DeleteMapping("/Supprimer")
    public String Supprimer(@PathVariable Long id_liste_postulant) {
        return listePostulantService.Supprimer(id_liste_postulant);
    }

}
