package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulantRepository extends JpaRepository<Postulant,Long> {
}
