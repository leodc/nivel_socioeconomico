package pwc.da.nse.options;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import org.json.JSONObject;

/**
 *
 * @author leo
 */
public class OptionsReader {
    
    public static JSONObject parse(String optionsFileName){
        try {
            String fileString = Files.lines(Paths.get(optionsFileName), StandardCharsets.UTF_8).collect(Collectors.joining());
            
            return new JSONObject(fileString);
        } catch (FileNotFoundException ne){
            System.err.println("Can't find the file.");
        } catch (IOException ex){
            System.err.println("Can't write or read from the file.");
        }
        
        return null;
    }
    
    
}
