package pwc.da.nse.entity;

/**
 *
 * @author Leo
 */
public class Hogar {
    
    /**
     * Número de estufas de gas o eléctricas con las que cuenta el hogar.
     * NOTA: El valor -1, representa un dato “No especificado”.
     */
    private int num_estuf;
    
    /**
     * Número de automóviles con los que cuenta el hogar.
     * 
     */
    private int num_auto;
    
    /**
     * Factor de expansión del hogar.
     * NOTA: Variable definida en el diseño muestral.
     */
    private double factor_hog;
    
    /**
     * Identificador del hogar.
     * El código 1 identifica al hogar principal y del 2 al 5 los hogares adicionales.
     * NOTA: Variable construida a partir del folio registrado en la portada de los cuestionarios.
     */
    private String foliohog;

    public void setFoliohog(String foliohog) {
        this.foliohog = foliohog;
    }

    public String getFoliohog() {
        return foliohog;
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
