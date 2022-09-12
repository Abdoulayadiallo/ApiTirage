package ml.freetirage.apitirage.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "postulanttire")
public class PostulantTire {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_postulant_tire")
    private Long id_postulantTire;


}
