package ml.freetirage.apitirage.Service;

import ml.freetirage.apitirage.Model.Postulant;
import ml.freetirage.apitirage.Model.Tirage;

import java.util.List;

public interface TirageService {
    List<Postulant>creerTirage(Tirage tirage, List<Postulant> listAtrier, long n_tirage	);

    Tirage trouverTirageParLibelle(String libele);

    List<Tirage> AfficherTirage();
    List<Object>  NombreParlisteTirage();
    public int nombreListeTire();

    public List<Tirage>  LienListeTireParId(long id_liste_postulant);
}
