package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Postulant;

import java.util.List;

public interface PostulantService {

    Postulant Ajouter(Postulant postulant);
    List<Postulant> Afficher();
    Postulant Modifier(Postulant postulant,Long id_postulant);
    String Supprimer(Long id_postulant);
}
