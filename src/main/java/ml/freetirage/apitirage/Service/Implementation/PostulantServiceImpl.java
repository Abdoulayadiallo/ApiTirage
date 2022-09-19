package ml.freetirage.apitirage.Service.Implementation;

import lombok.AllArgsConstructor;
import ml.freetirage.apitirage.Model.Postulant;
import ml.freetirage.apitirage.Repository.PostulantRepository;
import ml.freetirage.apitirage.Service.PostulantService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@Service
public class PostulantServiceImpl implements PostulantService {

    @Autowired
    private final PostulantRepository postulantRepository;

    @Override
    public ArrayList<Postulant> InserPostulant(MultipartFile file) {

        DataFormatter formatter=new DataFormatter();
        ArrayList<Postulant> values = new ArrayList<Postulant>();
        // Block permettant de lever les exception lors de l'importation du fichier excel
        try{
            // conversion du fichier simple sous forme d'un fichier POI
            POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
            // Conversion du fichier POI sous format Workbook
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            // Recuperation du Premier page du fichier excel
            HSSFSheet sheet = wb.getSheetAt(0);
            // Recuperation de tous les lignes de la page du fichier

            Iterator rows = sheet.rowIterator();

            // Boucle permettant de parcours toutes lignes de la page
            while (rows.hasNext()){

               
                HSSFRow row = (HSSFRow) rows.next(); // Recuperation d'une ligne du tableau

                Iterator cells = row.cellIterator(); // Recuperation de toutes toutes les colonnes de chaque ligne
                Postulant p=new Postulant();
                int numColun=0;
                // Boucle permettant de parcourut toutes les colonnes de chaque ligne
                while (cells.hasNext()){

                    HSSFCell cell = (HSSFCell) cells.next(); // Recuperation d'une colonne

                    switch (numColun){

                        case 0:
                            p.setEmail(formatter.formatCellValue(cell));
                            break;
                        case 1:
                            p.setNom(formatter.formatCellValue(cell));
                            break;
                        case 2:
                            p.setNumero(formatter.formatCellValue(cell));
                            break;
                        case 3:
                            p.setPrenom(formatter.formatCellValue(cell));
                            break;
                        default:
                            break;
                    }
                    numColun++;

                }


                values.add(p);
                System.out.println(p.getListePostulant());
            }
            return values;

        }catch (Exception e){

            e.printStackTrace();
            return null;

        }

    }

    @Override
    public List<Postulant> Afficher_Postulant() {
        return postulantRepository.findAll();
    }

    @Override
    public Postulant creerPostulant(Postulant postulant) {
        return postulantRepository.save(postulant);
    }

    @Override
    public List<Postulant> TrouverPostulantId(long id_liste_postulant) {
        return postulantRepository.TrouverPostulantparListe(id_liste_postulant);
    }

    @Override
    public List<Object> AfficherAvecLibele() {
        return postulantRepository.PostulantListe();
    }

    @Override
    public int PostulantTotal() {
        return postulantRepository.PostulantTotal();
    }


}
