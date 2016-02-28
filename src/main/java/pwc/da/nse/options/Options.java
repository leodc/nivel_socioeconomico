package pwc.da.nse.options;

import org.json.JSONObject;

/**
 *
 * @author leo
 */
public class Options{
    
    public static final JSONObject JSON_OBJECT;
    
    static{
        JSON_OBJECT = OptionsReader.parse("options");   //configuration file
    }
        
}
