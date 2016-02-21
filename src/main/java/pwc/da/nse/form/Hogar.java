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
    
    public double getPoints(){
        double sum = num_auto + num_estuf;
        
        if( factor_hog > 0.0D ){
           // sum *= factor_hog;
        }
        
        return sum;
    }

    public int getNum_estuf() {
        return num_estuf;
    }

    public void setNum_estuf(int num_estuf) {
        this.num_estuf = num_estuf;
    }

    public int getNum_auto() {
        return num_auto;
    }

    public void setNum_auto(int num_auto) {
        this.num_auto = num_auto;
    }

    public double getFactor_hog() {
        return factor_hog;
    }

    public void setFactor_hog(double factor_hog) {
        this.factor_hog = factor_hog;
    }
    
}
