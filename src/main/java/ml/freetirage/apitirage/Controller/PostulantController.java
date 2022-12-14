package ml.freetirage.apitirage.Controller;

import lombok.AllArgsConstructor;

import ml.freetirage.apitirage.Model.ListePostulant;
import ml.freetirage.apitirage.Model.Postulant;
import ml.freetirage.apitirage.Service.ListePostulantService;
import ml.freetirage.apitirage.Service.PostulantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
@RequestMapping("/API/Postulant")
public class PostulantController {
    @Autowired
    private final PostulantService postulantService;

    private final ListePostulantService listePostulantService;

    @PostMapping("/ajoute_postulant/{libele}")
    public String AjouterPostulant(@RequestParam("file")MultipartFile file, ListePostulant listepostulant){
        //IMPLEMENTATION DE LA METHODE DANS LE CONTROLLER
        ArrayList<Postulant> importer= postulantService.InserPostulant(file);
        listepostulant.setDateListe(new Date());
        ListePostulant l = listePostulantService.Ajouter_Liste(listepostulant);

        for (Postulant p: importer)
        {
            p.setListePostulant(l);
            postulantService.creerPostulant(p);
        }

        return "import avec succes";
    }
    @GetMapping("/Afficher")
    public List<Postulant> Afficher_Postulant(){
        return postulantService.Afficher_Postulant();
    }

    @GetMapping("/AfficherLibelle")
    public List<Object> AfficherAveclibele(){
        return postulantService.AfficherAvecLibele();
    }
    @GetMapping("/Total")
    public int PostulantTotal(){
        return postulantService.PostulantTotal();
    }
}
