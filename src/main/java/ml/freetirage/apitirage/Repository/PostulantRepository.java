package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PostulantRepository extends JpaRepository<Postulant, Long> {
    //Iterable<Object[]> Afficher_Postulant();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulant (email,nom,numero,prenom) values (:email,:nom,:numero,:prenom);",nativeQuery = true)
    public int INSERTPOSTULANT(@Param("nom") String nom,@Param("prenom") String prenom,@Param("email") String email,@Param("numero") String numero);

    @Query(value = "SELECT postulant.prenom,postulant.nom,postulant.numero,postulant.numero;",nativeQuery = true)
   public Iterable<Object> AfficherPostulant();


}
