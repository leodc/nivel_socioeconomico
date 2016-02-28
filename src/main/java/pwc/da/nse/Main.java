package pwc.da.nse;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import pwc.da.nse.csv.parser.ConcentradoHogarParser;
import pwc.da.nse.csv.parser.HogaresParser;
import pwc.da.nse.csv.parser.ViviendasParser;
import pwc.da.nse.entity.Hogar;
import pwc.da.nse.entity.Vivienda;
import pwc.da.nse.options.Options;

/**
 *
 * @author leo
 */
public class Main {

    public static void main(String[] args) {

        try {
            /*
            * Cargamos el archivo de propiedades, en el se definen las rutas a los
            * archivos de las tablas de INEGI, separadores de los archivos y
            * otras cosas.
            */
            String optionsFileName = "data/options";
            Options.read(optionsFileName);
            System.out.println("--- Archivo de opciones cargado correctamente.");
            
            ViviendasParser viviendasParser = new ViviendasParser(Options.getProperty("csv_viviendas"), true, Options.getProperty("csv_split"));
            HogaresParser hogaresParser = new HogaresParser(Options.getProperty("csv_hogares"), true, Options.getProperty("csv_split"));
            ConcentradoHogarParser concentradoHogarParser = new ConcentradoHogarParser(Options.getProperty("csv_concentradohogar"), true, Options.getProperty("csv_split"));
            
            System.out.println("--- Parsers cargados correctamente.");
            
            Map<String, List<Vivienda>> viviendasCollect = viviendasParser.getRecords().collect( Collectors.groupingBy(Vivienda::getFolioviv) );
            Map<String, List<Hogar>> hogaresCollect = hogaresParser.getRecords().collect( Collectors.groupingBy(Hogar::getFolioviv) );
            
            Iterator<String> viviendasIterator = viviendasCollect.keySet().iterator();
            while( viviendasIterator.hasNext() ){
                String nextKey = viviendasIterator.next();
                
                List<Vivienda> viviendaList = viviendasCollect.get(nextKey);
                System.out.println(viviendaList.size());
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
