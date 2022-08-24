package ml.freetirage.apitirage.Model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tirage;
    // @Temporal(TemporalType.DATE)
    private Date date;
    private String libele;
    private int n_tirage ;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "postulanttire",
            joinColumns = @JoinColumn(name = "id_postulant"),
            inverseJoinColumns = @JoinColumn(name = "id_tirage")
    )
    private List<Postulant> postulant = new ArrayList<>();

}
