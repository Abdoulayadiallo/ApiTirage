package ml.freetirage.apitirage.Controller;

import lombok.AllArgsConstructor;

import ml.freetirage.apitirage.Model.PostulantTire;
import ml.freetirage.apitirage.Service.PostulantTireService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
@RequestMapping("/PostulantTire")
public class PostulantTireController {
    PostulantTireService postulanttireservice;
    @GetMapping("/Afficher")
    public List<PostulantTire> Afficher(){
        return postulanttireservice.Afficher();
    }
    @GetMapping("/compte")
    public int CompterParLibelle(){
        return postulanttireservice.NombreTirageParListe();
    }
}
