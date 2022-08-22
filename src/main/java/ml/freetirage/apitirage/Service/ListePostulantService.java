package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.ListePostulant;


import java.util.List;

public interface ListePostulantService {
    ListePostulant Ajouter(ListePostulant listepostulant);
    List<ListePostulant>Afficher();
    ListePostulant Modifier(ListePostulant listepostulant, Long id_liste_postulant);
    String Supprimer(Long id_listePostulant);

}
