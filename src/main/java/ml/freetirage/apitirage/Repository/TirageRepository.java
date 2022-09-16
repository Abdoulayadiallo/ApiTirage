package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TirageRepository extends JpaRepository<Tirage, Long> {
    Tirage findBylibele(String tirage);
    @Query(value = "SELECT liste_postulant.id_liste_postulant, liste_postulant.libele, COUNT(DISTINCT liste_postulant.id_liste_postulant) FROM liste_postulant,postulant,postulanttire,tirage WHERE liste_postulant.id_liste_postulant = postulant.liste_postulant_id_liste_postulant and postulanttire.id_postulant=postulant.id_postulant and" +
            " tirage.id_tirage=postulanttire.id_tirage GROUP BY liste_postulant.id_liste_postulant;",nativeQuery = true)
    public List<Object> nombreTirageParListe();

    @Query(value = "SELECT COUNT(DISTINCT liste_postulant.id_liste_postulant) FROM liste_postulant,postulant,postulanttire,tirage WHERE liste_postulant.id_liste_postulant = postulant.liste_postulant_id_liste_postulant and " +
            "postulanttire.id_postulant=postulant.id_postulant and tirage.id_tirage=postulanttire.id_tirage;",nativeQuery = true)
    public int nombreListeTire();
    @Query(value = "SELECT tirage.* FROM liste_postulant,postulant,postulanttire,tirage WHERE postulant.liste_postulant_id_liste_postulant=:id_liste_postulant and postulanttire.id_postulant=postulant.id_postulant and " +
            "tirage.id_tirage=postulanttire.id_tirage;",nativeQuery = true)
    public List<Tirage> LienListeTireParId(long id_liste_postulant);



}
