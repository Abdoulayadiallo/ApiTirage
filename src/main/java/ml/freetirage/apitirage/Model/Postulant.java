package ml.freetirage.apitirage.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "postulant")
public class Postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postulant")
    private Long idpostulant;
    private String nom;
    private String prenom;
    private String email;
    private String numero;
    @ManyToOne
    ListePostulant listePostulant;
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "Postulant_tire",
            joinColumns = @JoinColumn(name = "id_tirage"),
            inverseJoinColumns = @JoinColumn(name = "id_postulant")
    )
    private List<Tirage> tirage = new ArrayList<>();
}



