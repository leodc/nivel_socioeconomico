package pwc.da.nse.options;

import org.json.JSONObject;

/**
 *
 * @author leo
 */
public class Options{
    
    public static JSONObject JSON_OBJECT;
    
    public static void read(String fileName){
        JSON_OBJECT = OptionsReader.parse(fileName);
        
        if( JSON_OBJECT == null ){
            System.exit(0);
        }
        
    }
        
}
