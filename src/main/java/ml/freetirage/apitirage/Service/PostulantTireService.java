package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.PostulantTire;

import java.util.List;

public interface PostulantTireService {
    PostulantTire CreerPostulantTire(PostulantTire postulantTire);
    List<PostulantTire> Afficher();
}
