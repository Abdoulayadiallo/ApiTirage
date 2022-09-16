package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.PostulantTire;

import java.util.List;

public interface PostulantTireService {
   // int CreerPostulantTire(Long id_postulant,Long id_tirage);
    List<PostulantTire> Afficher();
    int  NombreTirageParListe();

}
