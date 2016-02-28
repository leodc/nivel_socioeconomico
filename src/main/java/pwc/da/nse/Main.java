package pwc.da.nse;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pwc.da.nse.csv.parser.ViviendasParser;
import pwc.da.nse.entity.Vivienda;
import pwc.da.nse.options.Options;

/**
 *
 * @author leo
 */
public class Main {

    public static void main(String[] args) {

        /*
         * Cargamos el archivo de propiedades, en el se definen las rutas a los
         * archivos de las tablas de INEGI, separadores de los archivos entre
         * otras cosas.
         */
        String optionsFileName = "data/options";
        Options.read(optionsFileName);
        System.out.println("--- Archivo de opciones cargado correctamente.");

        try {

            /*
             * Obtenemos los objetos Map de cada archivo que usaremos.
             *
             * El Key de cada objeto es el establecido en el diagrama
             * entidad-relacion en el documento: "ENIGH 2014.
             * Descripción de la base de datos. Nueva construcción de variables"
             */
            Map<String, List<Vivienda>> map = new ViviendasParser().getMap(Options.JSON_OBJECT.getString("csv_viviendas"), true);
            
            System.out.println("Total de localidades: " + map.size());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
