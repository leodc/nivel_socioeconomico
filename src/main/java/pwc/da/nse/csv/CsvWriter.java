package pwc.da.nse.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author leo
 */
public class CsvWriter {
    
    public static void writeNewFile(String file, List<String> lines) throws IOException{
        
        Files.write( Paths.get(file) , lines, StandardCharsets.UTF_8);
    }

}
