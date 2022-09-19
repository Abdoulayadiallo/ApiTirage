package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PostulantRepository extends JpaRepository<Postulant, Long> {
    //Iterable<Object[]> Afficher_Postulant();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulant (email,nom,numero,prenom) values (:email,:nom,:numero,:prenom);",nativeQuery = true)
    public int INSERTPOSTULANT(@Param("nom") String nom,@Param("prenom") String prenom,@Param("email") String email,@Param("numero") String numero);
    @Query(value = "SELECT * FROM postulant WHERE liste_postulant_id_liste_postulant=:id_liste ",nativeQuery = true)
    public List<Postulant> TrouverPostulantparListe(long id_liste);

    @Query(value = "SELECT id_postulant, nom,prenom,numero,email,libele FROM postulant,liste_postulant WHERE postulant.liste_postulant_id_liste_postulant = liste_postulant.id_liste_postulant;",nativeQuery = true)
    public List<Object> PostulantListe();
    @Query(value = "SELECT COUNT(DISTINCT(id_postulant)) FROM postulant;",nativeQuery = true)
    public int PostulantTotal();


}
