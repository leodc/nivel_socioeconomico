package pwc.da.nse;

/**
 *
 * @author Leo
 */
public class NSE {
    
    public static String getNSE(double points){
        String nse;
        
        if( points < 33 ){
            nse = "E";
        }else if( points < 80){
            nse = "D";
        }else if( points < 105){
            nse = "D+";
        }else if( points < 128){
            nse = "C-";
        }else if( points < 155){
            nse = "C";
        }else if( points < 193){
            nse = "C+";
        }else{
            nse = "AB";
        }
        
        return nse;
    }
    
}
