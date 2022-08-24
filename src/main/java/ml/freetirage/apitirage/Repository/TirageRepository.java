package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface TirageRepository extends JpaRepository<Tirage, Long> {
    

}
