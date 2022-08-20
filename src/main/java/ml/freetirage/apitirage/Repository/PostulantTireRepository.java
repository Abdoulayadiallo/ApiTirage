package ml.freetirage.apitirage.Repository;

import ml.freetirage.apitirage.Model.PostulantTire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostulantTireRepository extends JpaRepository<PostulantTire,Long> {
    List<PostulantTire> Afficher();
}
