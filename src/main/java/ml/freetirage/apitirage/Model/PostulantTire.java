package ml.freetirage.apitirage.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class PostulantTire {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_postulantTire")
    private Long id_postulantTire;
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "PostulantTire",
            joinColumns = @JoinColumn(name = "id_postulant"),
            inverseJoinColumns = @JoinColumn(name = "id_tirage")
    )
    private List<Postulant> postulant = new ArrayList<>();
}
