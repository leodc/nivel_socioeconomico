package pwc.da.nse.form;

/**
 *
 * @author Leo
 */
public class Concentrodehogar {
    
    private int educa_jefe;
    
    public double getPoints(){
        return educa_jefe;
    }

    public void setEduca_jefe(int educa_jefe) {
        if (educa_jefe < 4) {
            this.educa_jefe = 0;
        } else if (educa_jefe < 7) {
            this.educa_jefe = 22;
        } else if (educa_jefe < 9) {
            this.educa_jefe = 38;
        } else if (educa_jefe < 11) {
            this.educa_jefe = 52;
        } else {
            this.educa_jefe = 72;
        }
    }

    public int getEduca_jefe() {
        return educa_jefe;
    }
    
}
