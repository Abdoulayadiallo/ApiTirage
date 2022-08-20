package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.ListePostulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListePostulantRepository extends JpaRepository<ListePostulant,Long> {

    @Query(value = "select l.date,l.libele From liste_postulant As l;",nativeQuery = true)
    public Iterable<Object[]> AfficherListe();
}
