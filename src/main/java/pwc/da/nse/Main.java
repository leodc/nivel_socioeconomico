package pwc.da.nse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import pwc.da.nse.csv.LocalidadWriter;
import pwc.da.nse.csv.parser.ConcentradoHogarParser;
import pwc.da.nse.csv.parser.HogaresParser;
import pwc.da.nse.csv.parser.ViviendasParser;
import pwc.da.nse.entity.ConcentradoHogar;
import pwc.da.nse.entity.FK_Hogar_Vivienda;
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

            Map<String, List<Vivienda>> viviendasCollect = viviendasParser.getRecords().collect(Collectors.groupingBy(Vivienda::getFolioviv));
            Map<String, List<Hogar>> hogaresCollect = hogaresParser.getRecords().collect(Collectors.groupingBy(Hogar::getFolioviv));

            HashMap<FK_Hogar_Vivienda, Amai_8x7> amaiMap = new HashMap<>();
            Iterator<String> iteratorViviendas = viviendasCollect.keySet().iterator();
            while (iteratorViviendas.hasNext()) {
                String viviendaKey = iteratorViviendas.next();
                Hogar hogar = hogaresCollect.get(viviendaKey).get(0);

                String hogarKey = hogar.getFoliohog();

                FK_Hogar_Vivienda fK_Hogar_Vivienda = new FK_Hogar_Vivienda(viviendaKey, hogarKey);
                Vivienda vivienda = (Vivienda) viviendasCollect.get(viviendaKey).get(0);
                Amai_8x7 amai_8x7 = new Amai_8x7(fK_Hogar_Vivienda);
                amai_8x7.setHogar(hogar);
                amai_8x7.setVivienda(vivienda);

                amaiMap.put(fK_Hogar_Vivienda, amai_8x7);
            }

            int counter = 0;
            Iterator<ConcentradoHogar> concentradoHogarIterator = concentradoHogarParser.getRecords().iterator();
            while (concentradoHogarIterator.hasNext()) {
                ConcentradoHogar concentradoHogar = concentradoHogarIterator.next();
                FK_Hogar_Vivienda fk_hogar_vivienda = new FK_Hogar_Vivienda(concentradoHogar.getFolioviv(), concentradoHogar.getFoliohog());

                Amai_8x7 amai_8x7 = amaiMap.get(fk_hogar_vivienda);

                if (amai_8x7 != null) {
                    amai_8x7.setConcentradoHogar(concentradoHogar);
                    amai_8x7.setPoints();
                    amai_8x7.setLocalidad();

                    counter++;
                }
            }

            if (counter == amaiMap.size()) {
                System.out.println("--- AmaiMap creado correctamente");
            }

            Map<String, List<Amai_8x7>> amaiLocMap = amaiMap.values().stream().collect(Collectors.groupingBy(Amai_8x7::getCve_loc));
            Iterator<List<Amai_8x7>> amaiLocIterator = amaiLocMap.values().iterator();

            List<Localidad> localidadList = new ArrayList<>();
            while (amaiLocIterator.hasNext()) {
                List<Amai_8x7> amaiLoc = amaiLocIterator.next();

                Localidad localidad = new Localidad(amaiLoc.remove(0));
                amaiLoc.stream().forEach((amai_8x7) -> {
                    localidad.addLocalidad(amai_8x7);
                });

                localidadList.add(localidad);
            }

            LocalidadWriter.writeNewFile(Options.getProperty("csv_out"), localidadList);
            
            System.out.println("--- Archivo creado correctamente.");

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
