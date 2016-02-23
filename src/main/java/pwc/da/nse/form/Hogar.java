package pwc.da.nse.form;

/**
 *
 * @author Leo
 */
public class Hogar {
    
    private int num_estuf;
    private int num_auto;
    
    private double factor_hog;
    
    private String foliohog;

    public void setFoliohog(String foliohog) {
        this.foliohog = foliohog;
    }

    public String getFoliohog() {
        return foliohog;
    }
    
    public double getPoints(boolean with_factor_viv){
        double sum = num_auto + num_estuf;
        
        if( with_factor_viv && factor_hog > 0.0D ){
            sum *= factor_hog;
        }
        
        return sum;
    }

    public int getNum_estuf() {
        return num_estuf;
    }

    public void setNum_estuf(int num_estuf) {
        if( num_estuf > 0 ){
            this.num_estuf = 20;
        }else{
            this.num_estuf = 0;
        }
    }

    public int getNum_auto() {
        return num_auto;
    }

    public void setNum_auto(int num_auto) {
        if( num_auto < 1 ){
            this.num_auto = 0;
        }else if( num_auto < 2 ){
            this.num_auto = 32;
        }else if( num_auto < 3 ){
            this.num_auto = 41;
        }else{
            this.num_auto = 58;
        }
    }

    public double getFactor_hog() {
        return factor_hog;
    }

    public void setFactor_hog(double factor_hog) {
        this.factor_hog = factor_hog;
    }
    
}
