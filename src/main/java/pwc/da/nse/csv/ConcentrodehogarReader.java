package pwc.da.nse.csv;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import pwc.da.nse.Options;
import pwc.da.nse.form.Concentrodehogar;
import pwc.da.nse.form.FK_Hogar_Vivienda;

/**
 *
 * @author Leo
 */
public class ConcentrodehogarReader {
    
    public static HashMap<FK_Hogar_Vivienda, Concentrodehogar> getTreeMap(String file_name){
        
        try {
            return parse(Arrays.asList(CsvReader.getLines(file_name)));
            
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + file_name);
        }
        
        return null;
    }

    private static HashMap<FK_Hogar_Vivienda, Concentrodehogar> parse(List<Object> lines) {
        HashMap<FK_Hogar_Vivienda, Concentrodehogar> tree = new HashMap<>();
        
        for (Iterator<Object> it = lines.iterator(); it.hasNext();) {
            String line = (String) it.next();
            
            String[] split = line.split(Options.CSV_SPLIT);
            
            Concentrodehogar concetrado = new Concentrodehogar();
            concetrado.setEduca_jefe(Integer.parseInt(split[12]));
            tree.put(new FK_Hogar_Vivienda(split[0], split[1]), concetrado);
        }
        
        return tree;
    }
    
}
