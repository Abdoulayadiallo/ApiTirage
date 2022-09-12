package ml.freetirage.apitirage.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
public class ListePostulant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liste_postulant")
    private Long id_liste_postulant;
    private String libele;
    private Date dateListe;
}
