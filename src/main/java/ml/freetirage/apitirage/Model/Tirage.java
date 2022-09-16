package ml.freetirage.apitirage.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tirage;
    //@Temporal(TemporalType.DATE)
   // private Date date = new Date();
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date = LocalDateTime.now();
    private String libele;
    private long n_tirage ;

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
    private List<Postulant> postulant = new ArrayList<>();

}
