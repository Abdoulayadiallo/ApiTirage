package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.PostulantTire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.transaction.Transactional;

public interface PostulantTireRepository extends JpaRepository<PostulantTire, Long> {

    @Modifying
    @Transactional
    @Query(value="Insert into postulant_tire(id_postulant,id_tirage) values (?,?);",nativeQuery = true)
    public int InsertPostulanttire(Long id_postulant,Long id_tirage);
}
