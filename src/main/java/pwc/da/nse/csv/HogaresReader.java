package pwc.da.nse.csv;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import pwc.da.nse.Options;
import pwc.da.nse.form.Hogar;


/**
 *
 * @author Leo
 */
public class HogaresReader {
    
    
    public static TreeMap<String, Hogar> getTreeMap(String file_name){
        
        try {
            List<Object> lines = Arrays.asList(CsvReader.getLines(file_name));
            
            return parse(lines);
            
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + file_name);
        }
        
        return null;
    }

    private static TreeMap<String, Hogar> parse(List<Object> lines) {
        
        TreeMap<String, Hogar> tree = new TreeMap<>();
        for (Iterator<Object> it = lines.iterator(); it.hasNext();) {
            String line = (String) it.next();
            
            String[] split = line.split(Options.CSV_SPLIT);
            Hogar hogar = new Hogar();
            hogar.setFoliohog(split[1]);
            hogar.setFactor_hog(Double.parseDouble(split[120]));
            hogar.setNum_auto(Integer.parseInt(split[39]));
            hogar.setNum_estuf(Integer.parseInt(split[79]));
            tree.put(split[0], hogar);
        }
        
        return tree;
    }
    
}
