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
    private String libelle;
    private int n_tirage ;


    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    //@JoinColumn : Cette annotation permet d’indiquer le nom de la clé étrangère dans la table de l’entité concernée.
    //PERSIST et MERGE, la cascade s’applique donc tant en création qu’en modification.
    @JoinTable(
            name = "PostulantTire",
            joinColumns = @JoinColumn(name = "id_postulant"),
            inverseJoinColumns = @JoinColumn(name = "id_tirage")
    )


    private List<Postulant> postulant = new ArrayList<>();


}
