package ml.freetirage.apitirage.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id_postulant;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "numero")
    private String numero;
    @ManyToOne
    ListePostulant listePostulant;

    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "postulanttire",
            joinColumns = @JoinColumn(name = "id_tirage"),
            inverseJoinColumns = @JoinColumn(name = "id_postulant")
    )
    private List<Tirage> tirage = new ArrayList<>();

}



