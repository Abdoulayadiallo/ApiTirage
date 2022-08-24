package ml.freetirage.apitirage.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "postulanttire")
public class PostulantTire {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_postulant_tire")
    private Long id_postulantTire;


}
