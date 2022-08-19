package ml.freetirage.apitirage.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

}
