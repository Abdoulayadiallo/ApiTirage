package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.ListePostulant;
import ml.freetirage.apitirage.Model.Postulant;


import java.util.List;

public interface ListePostulantService {
    ListePostulant Ajouter(ListePostulant listepostulant);
    List<ListePostulant>Affiche();
    Postulant Modifier(ListePostulant listepostulant, Long id_liste_postulant);

}
