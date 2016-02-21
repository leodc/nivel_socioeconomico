package pwc.da.nse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
        
        System.out.println("Obteniendo records de viviendas...");
        List<Object> run = ViviendasReader.run(Options.CSV_FILE_NAME_VIVIENDAS);
        Iterator<Object> iterator = run.iterator();
        
        System.out.println("Se obtuvieron " + run.size() + " records de viviendas.");
        
        TreeMap<String, Hogar> tree_hogares = HogaresReader.getTreeMap(Options.CSV_FILE_NAME_HOGARES);
        
        System.out.println("Se obtuvieron " + tree_hogares.size() + " records de hogares.");
        HashMap<FK_Hogar_Vivienda, Concentrodehogar> tree_concentrado = ConcentrodehogarReader.getTreeMap(Options.CSV_FILE_NAME_CONCENTRODEHOGAR);
        
        System.out.println("Se obtuvieron " + tree_concentrado.size() + " records de concentradohogar.");
        while( iterator.hasNext() ){
            Vivienda vivienda = (Vivienda) iterator.next();
            Hogar hogar = tree_hogares.remove(vivienda.getFolioviv());
            Concentrodehogar concentrado = tree_concentrado.remove( new FK_Hogar_Vivienda(vivienda.getFolioviv(), hogar.getFoliohog()) );

            
            Amai_8x7 amai = new Amai_8x7(vivienda);
            amai.setHogares(hogar);
            amai.setConcentrodehogar(concentrado);
            amai.updatePoint();
            
            double puntos = amai.getPuntos();
            NSE.getNSE(puntos);
            
            //System.out.println("NSE: " + NSE.getNSE(puntos) + " est_socio: " + vivienda.getEst_socio());
            amaiList.add(amai);
        }
        
        double suma = NSE.counter_AB + NSE.counter_C + NSE.counter_Cminus + NSE.counter_Cplus + NSE.counter_D + NSE.counter_Dplus + NSE.counter_E;
        System.out.println("AB: " + (suma/NSE.counter_AB));
        System.out.println("C+: " + (suma/NSE.counter_Cplus));
        System.out.println("C: " + (suma/NSE.counter_C));
        System.out.println("C-: " + (suma/NSE.counter_Cminus));
        System.out.println("D+: " + (suma/NSE.counter_Dplus));
        System.out.println("D: " + (suma/NSE.counter_D));
        System.out.println("E: " + (suma/NSE.counter_E));
    }
    
}
