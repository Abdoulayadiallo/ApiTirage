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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;

@AllArgsConstructor
@Service
public class PostulantServiceImpl implements PostulantService {


    private final PostulantRepository postulantRepository;

    @Override
    public ArrayList<Postulant> INSERPostulant(MultipartFile file) {

        DataFormatter formatter=new DataFormatter();
        ArrayList<Postulant> values = new ArrayList<Postulant>(); // Variable permettant de prendre toutes les donnes du tableau

        // Bloque permettant de lever les exception lors de l'importation du fichier excel
        try{
            //InputStream fichier = new FileInputStream("fichier.xls"); // Recuperation du fichier Execl sous forme de fichier simple

            POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream()); // conversion du fichier simple sous forme d'un fichier POI

            HSSFWorkbook wb = new HSSFWorkbook(fs); // Conversion du fichier POI sous format Workbook

            HSSFSheet sheet = wb.getSheetAt(0); // Recuperation du Premier page du fichier excel

            Iterator rows = sheet.rowIterator(); // Recuperation de tous les lignes de la page du fichier
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

                //postulantRepository.INSERTPOSTULANT (values.get(3),values.get(1),values.get(2),values.get(0));
                values.add(p);
            }
            return values;

        }catch (Exception e){

            e.printStackTrace();
            return null;

        }

    }

    @Override
    public Iterable<Object[]> Afficher_Postulant() {
        return null;
                //postulantRepository.Afficher_Postulant();
    }

    @Override
    public Postulant creerPostulant(Postulant postulant) {
        return postulantRepository.save(postulant);
    }



}
