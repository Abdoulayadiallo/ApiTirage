package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.PostulantTire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PostulantTireRepository extends JpaRepository<PostulantTire, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulanttire (id_postulant,id_tirage) values (?,?);",nativeQuery = true)
    public int InsererPostulantTire(long id_postulant,long id_tirage);
}
