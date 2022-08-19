package ml.freetirage.apitirage.Modele;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_postulant;
    private String nom;
    private String prenom;
    private String email;
    private String numero;
    @ManyToOne
    ListePostulant listePostulant;

}
