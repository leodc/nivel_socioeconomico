package pwc.da.nse.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Leo
 */
public class CsvHandler {

    public static void run() {
        String csvFile = "viviendas.csv";
        String csvSplitBy = ";";

        Path path = Paths.get(csvFile);
        
        try {
            Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
            lines.forEach((String t) -> {
                System.out.println(Arrays.toString(t.split(csvSplitBy)));
            });
            
            System.out.println("Fin del archivo");
        } catch (IOException ex) {
            Logger.getLogger(CsvHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        CsvHandler.run();
    }
}
