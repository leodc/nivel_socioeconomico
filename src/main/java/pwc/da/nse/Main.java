package pwc.da.nse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
            
            //System.out.println("NSE: " + NSE.getNSE(puntos) + " est_socio: " + vivienda.getEst_socio());
            amaiList.add(amai);
        }
        
        /*
        double suma = NseCounter.counter_AB + NseCounter.counter_C + NseCounter.counter_Cminus + NseCounter.counter_Cplus + NseCounter.counter_D + NseCounter.counter_Dplus + NseCounter.counter_E;
        System.out.println("AB: " + (suma/NseCounter.counter_AB));
        System.out.println("C+: " + (suma/NseCounter.counter_Cplus));
        System.out.println("C: " + (suma/NseCounter.counter_C));
        System.out.println("C-: " + (suma/NseCounter.counter_Cminus));
        System.out.println("D+: " + (suma/NseCounter.counter_Dplus));
        System.out.println("D: " + (suma/NseCounter.counter_D));
        System.out.println("E: " + (suma/NseCounter.counter_E));
         */
        TreeMap<String, NSE> tree = JoinByAgeb.join(amaiList);
        
        Set<String> keySet = tree.keySet();
        Iterator<String> it = keySet.iterator();
        NseCounter counter = new NseCounter();
        while( it.hasNext() ){
            String next = it.next();
            
            NSE nse = tree.get(next);
            double average = nse.getAverage();
            System.out.println("AGEB: " + nse.getAgeb() + "\tPuntos: " + String.format("%.2f", average) + "\t\tMuestras: " + nse.getAgeb_counter() + "\t\tNSE: " + counter.getNSE(average));
        }
        
        
        System.out.println("Numero de AGEBs: " + tree.size());
        
        System.out.println("AB: " + counter.getCounter_AB() + "\t\t" + getAverage(counter.getCounter_AB(), tree.size()));
        System.out.println("C+: " + counter.getCounter_Cplus() + "\t\t" + getAverage(counter.getCounter_Cplus(), tree.size()));
        System.out.println("C: " + counter.getCounter_C() + "\t\t" + getAverage(counter.getCounter_C(), tree.size()));
        System.out.println("C-: " + counter.getCounter_Cminus() + "\t\t" + getAverage(counter.getCounter_Cminus(), tree.size()));
        System.out.println("D+: " + counter.getCounter_Dplus() + "\t\t" + getAverage(counter.getCounter_Dplus(), tree.size()));
        System.out.println("D: " + counter.getCounter_D() + "\t\t" + getAverage(counter.getCounter_D(), tree.size()));
        System.out.println("E: " + counter.getCounter_E() + "\t\t" + getAverage(counter.getCounter_E(), tree.size()));
    }
    
    public static double getAverage(int counter, int max){
        return ((counter*100) / max );
    }
    
}
