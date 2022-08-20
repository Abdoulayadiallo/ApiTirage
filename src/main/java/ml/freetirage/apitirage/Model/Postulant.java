package ml.freetirage.apitirage.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "PostulantTire",
            joinColumns = @JoinColumn(name = "id_tirage"),
            inverseJoinColumns = @JoinColumn(name = "id_postulant")
    )
    private List<Tirage> tirage = new ArrayList<>();

}
