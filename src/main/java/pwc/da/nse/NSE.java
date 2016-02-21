package pwc.da.nse;

/**
 *
 * @author Leo
 */
public class NSE {
    
    public static int counter_AB = 0;
    public static int counter_Cplus = 0;
    public static int counter_C = 0;
    public static int counter_Cminus = 0;
    public static int counter_Dplus = 0;
    public static int counter_D = 0;
    public static int counter_E = 0;
    
    public static String getNSE(double points){
        String nse;
        
        if( points < 33 ){
            nse = "E";
            counter_E++;
        }else if( points < 80){
            nse = "D";
            counter_D++;
        }else if( points < 105){
            nse = "D+";
            counter_Dplus++;
        }else if( points < 128){
            nse = "C-";
            counter_Cminus++;
        }else if( points < 155){
            nse = "C";
            counter_C++;
        }else if( points < 193){
            nse = "C+";
            counter_Cplus++;
        }else{
            nse = "AB";
            counter_AB++;
        }
        
        return nse;
    }
    
}
