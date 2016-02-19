package pwc.da.nse.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class CsvHandler {

    private final static String CSV_FILE = "viviendas.csv";
    private final static String CSV_SPLIT = ";";

    public static void run() {
        boolean file_headers = true; //El archivo siempre debe de contener los headers
        
        Path path = Paths.get(CSV_FILE);
        try {
            Iterator<String> linesIterator = Files.lines(path, StandardCharsets.UTF_8).iterator();
            
            while( linesIterator.hasNext() ){
                String next = linesIterator.next();
                
                if( file_headers ){
                    List<String> asList = Arrays.asList(next.split(CSV_SPLIT));
                }else{
                    
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(CsvHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
