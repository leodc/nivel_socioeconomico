package pwc.da.nse.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import pwc.da.nse.Options;
import pwc.da.nse.form.Vivienda;

/**
 *
 * @author Leo
 */
public class ViviendasReader{

    
    public static List<Object> run(String file_name) {
        //El archivo siempre debe de contener los headers
        
        try {
            List<Object> lines = Arrays.asList(CsvReader.getLines(file_name));
            return parse(lines);
            
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + file_name);
        }
        
        return null;
    }
    
    private static List<Object> parse(List<Object> records) {
        
        List<Object> result = new ArrayList<>();
        for (Iterator<Object> it = records.iterator(); it.hasNext();) {
            String record = (String) it.next();
            
            String[] split = record.split(Options.CSV_SPLIT);
            Vivienda vivienda = new Vivienda();
            vivienda.setFolioviv(split[0]);
            vivienda.setAgeb(split[58]);
            vivienda.setCuart_dorm(Integer.parseInt(split[9]));
            vivienda.setEst_socio(Integer.parseInt(split[60]));
            vivienda.setFactor_viv(Integer.parseInt(split[63]));
            
            int mat_pisos = 0;
            try{
                mat_pisos = Integer.parseInt(split[4]);
            }catch(NumberFormatException ne){};
            vivienda.setMat_pisos(mat_pisos);
            
            int num_bano = 0;
            int num_bano_excus = 0;
            int num_bano_regad = 0;
            try{
                num_bano = Integer.parseInt(split[17]);
                num_bano_excus = Integer.parseInt(split[18]);
                num_bano_regad = Integer.parseInt(split[19]);
            }catch(NumberFormatException ne){};
            vivienda.setNum_bano((num_bano+num_bano_excus+num_bano_regad));
            
            int focos_inca = 0;
            int focos_ahor = 0;
            try{
                focos_inca = Integer.parseInt(split[22]);
                focos_ahor = Integer.parseInt(split[23]);
            }catch(NumberFormatException ne){};
            vivienda.setNum_focos(focos_inca, focos_ahor);
            
            
            vivienda.setRegadera(Integer.parseInt(split[42]));
            vivienda.setUbica_geo(split[57]);
            result.add(vivienda);
        }
        
        return result;
    }
    
}
