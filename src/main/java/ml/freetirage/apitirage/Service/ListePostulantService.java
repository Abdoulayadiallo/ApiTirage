package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.ListePostulant;
import ml.freetirage.apitirage.Model.Postulant;


import java.util.List;

public interface ListePostulantService {

    ListePostulant Ajouter_Liste(ListePostulant listepostulant);

    ListePostulant trouverListeparLibele(String libele);

    List<ListePostulant> Afficher_Liste();

    ListePostulant trouverListeParLibele(String libele);
    public Iterable<Object[]> AfficherListe();



}
