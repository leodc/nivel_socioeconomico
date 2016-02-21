package pwc.da.nse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import pwc.da.nse.csv.ConcentrodehogarReader;
import pwc.da.nse.csv.HogaresReader;
import pwc.da.nse.csv.ViviendasReader;
import pwc.da.nse.form.Amai_8x7;
import pwc.da.nse.form.Concentrodehogar;
import pwc.da.nse.form.FK_Hogar_Vivienda;
import pwc.da.nse.form.Hogar;
import pwc.da.nse.form.Vivienda;

/**
 *
 * @author Leo
 */
public class Main {
    
    public static void main(String[] args) {
        ArrayList<Amai_8x7> amaiList = new ArrayList<>();
        
        Iterator<Object> iterator = ViviendasReader.run(Options.CSV_FILE_NAME_VIVIENDAS).iterator();
        
        TreeMap<String, Hogar> tree_hogares = HogaresReader.getTreeMap(Options.CSV_FILE_NAME_HOGARES);
        HashMap<FK_Hogar_Vivienda, Concentrodehogar> tree_concentrado = ConcentrodehogarReader.getTreeMap(Options.CSV_FILE_NAME_CONCENTRODEHOGAR);
        
        while( iterator.hasNext() ){
            Vivienda vivienda = (Vivienda) iterator.next();
            Hogar hogar = tree_hogares.remove(vivienda.getFolioviv());
            Concentrodehogar concentrado = tree_concentrado.remove( new FK_Hogar_Vivienda(vivienda.getFolioviv(), hogar.getFoliohog()) );

            
            Amai_8x7 amai = new Amai_8x7(vivienda);
            amai.setHogares(hogar);
            amai.setConcentrodehogar(concentrado);
            amai.updatePoint();
            
            double puntos = amai.getPuntos();
            
            System.out.println("NSE: " + NSE.getNSE(puntos) + " est_socio: " + vivienda.getEst_socio());
            amaiList.add(amai);
        }
    }
    
}
