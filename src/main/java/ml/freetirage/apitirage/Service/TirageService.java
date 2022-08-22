package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Tirage;

import java.util.List;

public interface TirageService {
    Tirage CreerTirage(Tirage tirage);

    List<Tirage> AfficherTirage();
}
