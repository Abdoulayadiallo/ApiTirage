package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.PostulantTire;

import java.util.List;

public interface PostulantTireService {
    PostulantTire CreerPostulantTire();
    List<PostulantTire> Afficher();
    int InsertPostulant(String nom, String prenom, String numero, String email);
}
