package pwc.da.nse;

/**
 *
 * @author Leo
 */
public class NseCounter {
    
    private int counter_AB = 0;
    private int counter_Cplus = 0;
    private int counter_C = 0;
    private int counter_Cminus = 0;
    private int counter_Dplus = 0;
    private int counter_D = 0;
    private int counter_E = 0;

    public NseCounter() {
        counter_AB = 0;
        counter_Cplus = 0;
        counter_C = 0;
        counter_Cminus = 0;
        counter_Dplus = 0;
        counter_D = 0;
        counter_E = 0;
    }
    
    
    public String getNSE(double points){
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
    

    public int getCounter_AB() {
        return counter_AB;
    }

    public int getCounter_C() {
        return counter_C;
    }

    public int getCounter_Cminus() {
        return counter_Cminus;
    }

    public int getCounter_Cplus() {
        return counter_Cplus;
    }

    public int getCounter_D() {
        return counter_D;
    }

    public int getCounter_Dplus() {
        return counter_Dplus;
    }

    public int getCounter_E() {
        return counter_E;
    }
    
    
    public static String getNSE(float points){
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
