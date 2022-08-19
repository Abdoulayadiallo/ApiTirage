package ml.freetirage.apitirage.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tirage;
   // @Temporal(TemporalType.DATE)
    private Date date;
    private String libele;
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
