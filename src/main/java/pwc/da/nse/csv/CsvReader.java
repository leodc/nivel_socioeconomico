package pwc.da.nse.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Leo
 */
public class CsvReader {
    
    public static Object[] getLines(String file_name) throws IOException{
        Path path = Paths.get(file_name);
        
        return Files.lines(path, StandardCharsets.UTF_8 ).skip(1).toArray();
    }
    
}
