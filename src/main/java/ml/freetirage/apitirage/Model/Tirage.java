package ml.freetirage.apitirage.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
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
}
