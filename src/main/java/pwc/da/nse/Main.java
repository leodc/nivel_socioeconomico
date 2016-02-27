package pwc.da.nse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import pwc.da.nse.csv.ConcentrodehogarReader;
import pwc.da.nse.csv.CsvWriter;
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
            
            
            amaiList.add(amai);
        }
        TreeMap<String, NSE> tree = JoinByAgeb.join(amaiList);
        Set<String> keySet = tree.keySet();
        Iterator<String> it = keySet.iterator();
        NseCounter counter = new NseCounter();
        List<String> lines = new ArrayList<>();
        String header_line = "";
        for(String header_aux: Options.OUT_HEADERS){
            header_line += header_aux + ",";
        }
        lines.add(header_line);
        while( it.hasNext() ){
            String next = it.next();
            
            NSE nse = tree.get(next);
            /*
            String[] get = agebTree.get(nse.getAgeb());
            if( get != null ){
            nse.setCve_ent(get[1]);
            nse.setCve_mun(get[2]);
            nse.setGeometry(get[3]);
            }
            */
            
            double average = nse.getAverage();
            
            //System.out.println("AGEB: " + nse.getAgeb() + "\tPuntos: " + String.format("%.2f", average) + "\t\tMuestras: " + nse.getAgeb_counter() + "\t\tNSE: " + counter.getNSE(average));
            lines.add(nse.toString());
        }
        try {
            CsvWriter.writeNewFile(Options.CSV_FILE_NAME_OUT, lines);
        } catch (IOException ex) {
            System.err.println("Error al escribir el archivo de salida.");
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
