package pwc.da.nse;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import pwc.da.nse.form.Amai_8x7;

/**
 *
 * @author Leo
 */
public class JoinByAgeb {
    
    public static TreeMap<String, NSE> join(List<Amai_8x7> records){
        return join(records.iterator());
    }
    
    
    public static TreeMap<String, NSE> join(Iterator<Amai_8x7> it){
        TreeMap<String,NSE> tree = new TreeMap<>();
        
        while (it.hasNext()) {
            Amai_8x7 next = it.next();
            
            String ageb = next.getViviendas().getAgeb();
            
            NSE nse = tree.get(ageb);
            if( null == nse ){
                NSE nseAux = new NSE(ageb);
                nseAux.addPoints(next);
                
                tree.put(ageb, nseAux);
            }else{
                nse.addPoints(next);
            }
        }
        
        return tree;
        
    }
    
}
