package ml.freetirage.apitirage.Controller;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.Postulant;
import ml.freetirage.apitirage.Model.Tirage;
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
 // DECLARATION DU SERVICE TIRAGE
 @Autowired
 final private TirageService tirageService;
    // DECLARATION DU SERVICE POSTULANT
    final private PostulantService postulantService;
    // DECLARATION DU SERVICE POSTULANT_TRIER
    final private PostulantTireService postulantTrieService;
    // METHODE PERMETTANT DE CREER LE POSTULANT DANS LE CONTROLLER
    Postulant postulant;
    @PostMapping("/CreerTirage")
    public String CreerTirage(@RequestBody Tirage tirage){
        //APPEL DE LA METHODE CREER TIRAGE POUR CREER TIRAGE
        tirageService.CreerTirage(tirage);
        // CREATION D'UN D'UN OBJET RANDOM POUR POUVOIR SELECTIONNER LES ELEMENT DE FACON ALEATOIR
        Random ran = new Random();
        for (int i=0; i<tirage.getN_tirage(); i++){
            // LA METHODE NEXTLONG RETOURNE DES VALEUR ALEATOIRE A CHAQUE ITERATION DE LA BOUCLE FOR
            long nbrAleatoire = ran.nextLong(postulantService.NombrePostulant());
            ArrayList<Integer> listeNomrbeAleatoire = new ArrayList<>();
            //BOUCLE PERMETTANT DE VERIFIER SI LE NOMBRE ALEATOIR RETOURNER N'EST PAS EGALE A ZERO CAR NOS ID NE SON JAMAIS ZERO
            while (nbrAleatoire == 0 || listeNomrbeAleatoire.contains(nbrAleatoire))
            {
                nbrAleatoire = ran.nextLong(postulantService.NombrePostulant());
            }
            listeNomrbeAleatoire.add((int) nbrAleatoire);
            // DECLARATION D'UNE VARIABLE CONTENANT LA LISTE DES POSTULANT
            List<Postulant> postulant = postulantService.TrouverPostulantId(nbrAleatoire);

            if (i != 0)
            {
                long nbr = nbrAleatoire;
            }

            Boolean l =  postulant.remove(nbrAleatoire);
            System.out.println(l);

            //BOUCLE PERMETTANT DE PARCOURUT TOUS ELEMENT DE LA LISTE POSTULANT EN AFFECTTANT LES DONNEES DANS LA TABLE POSTULANT_TRIE
            for (Postulant p : postulant){
                   postulantTrieService.InsertPostulant(p.getNom(),p.getPrenom(),p.getEmail(),p.getNumero());

            }
        }
        return "BRAVO SUCCES";
    }

    // METHODE PERMETTANT DE D'AFFICHER LA LISTE DU TIRAGE
    @GetMapping("afficher")
    public List<Tirage> AfficherTirage(){
        return tirageService.AfficherTirage();
    }



}
