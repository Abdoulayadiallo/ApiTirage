package ml.freetirage.apitirage.Controller;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Modele.Postulant;
import ml.freetirage.apitirage.Service.PostulantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Postulant")
public class PostulantController {
    @Autowired
    PostulantService postulantService;
    @PostMapping("/Ajout")
    public Postulant ajout(@RequestBody Postulant postulant){
        return postulantService.Ajouter(postulant);
    }
    @GetMapping("/Afficher")
    public List<Postulant> Afficher(){
        return postulantService.Afficher();
    }

    @PutMapping("/Modifier")
    public Postulant Supprimer(@PathVariable Long id_postulant,@RequestBody Postulant postulant){
        return postulantService.Modifier(postulant,id_postulant);

    }
    @DeleteMapping("/Supprimer")
    public String Supprimer(@PathVariable Long id_postulant){
     return postulantService.Supprimer(id_postulant);
    }

}
