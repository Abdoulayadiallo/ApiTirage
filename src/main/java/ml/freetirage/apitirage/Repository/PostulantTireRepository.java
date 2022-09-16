package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.PostulantTire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PostulantTireRepository extends JpaRepository<PostulantTire, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulanttire (id_postulant,id_tirage) values (?,?);",nativeQuery = true)
    public int InsererPostulantTire(long id_postulant,long id_tirage);
    @Query(value = "SELECT liste_postulant.libele, COUNT(DISTINCT liste_postulant.id_liste_postulant) FROM liste_postulant,postulant," +
            "postulanttire,tirage WHERE liste_postulant.id_liste_postulant = postulant.liste_postulant_id_liste_postulant and" +
            " postulanttire.id_postulant=postulant.id_postulant and tirage.id_tirage=postulanttire.id_tirage;",nativeQuery = true)
    public int nombreTirageParListe();
}
