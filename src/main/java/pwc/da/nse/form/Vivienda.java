package pwc.da.nse.form;

/**
 *
 * @author Leo
 */
public class Vivienda {

    private int cuart_dorm;
    private int mat_pisos;
    private int num_bano;
    private int regadera;
    private int num_focos;

    private int est_socio;

    private double factor_viv = 0.0D;

    private String ubica_geo;
    private String ageb;
    
    private String folioviv;
    
    private double points;

    public String getFolioviv() {
        return folioviv;
    }

    public void setFolioviv(String folioviv) {
        this.folioviv = folioviv;
    }
    
    public void addPoints(double points){
        
        getPoints(false);
    }

    public double getPoints(boolean with_factor_viv){
        double sum = cuart_dorm + mat_pisos + num_bano + regadera + num_focos;
        
        if( with_factor_viv && factor_viv > 0.0D ){
            sum *= factor_viv;
        }
        
        return sum;
    }

    public void setCuart_dorm(int cuart_dorm) {
        if (cuart_dorm < 5) {
            this.cuart_dorm = 0;
        } else if (cuart_dorm < 7) {
            this.cuart_dorm = 8;
        } else {
            this.cuart_dorm = 14;
        }
    }

    public void setMat_pisos(int mat_pisos) {
        if (mat_pisos == 3) {
            this.mat_pisos = 11;
        } else {
            this.mat_pisos = 0;
        }
    }

    public void setNum_bano(int bano_comp) {
        if( bano_comp < 1 ){
            this.num_bano = 0;
        }else if( bano_comp < 2 ){
            this.num_bano = 13;
        }else if( bano_comp < 4 ){
            this.num_bano = 31;
        }else{
            this.num_bano = 48;
        }
        
    }

    public void setRegadera(int regadera) {
        if (regadera > 0) {
            this.regadera = 10;
        } else {
            this.regadera = 0;
        }
    }

    public void setNum_focos(int focos_inca, int focos_ahor) {
        int num_focos_aux = focos_ahor + focos_inca;
        
        if (num_focos_aux < 5) {
            this.num_focos = 0;
        } else if (num_focos_aux < 11) {
            this.num_focos = 15;
        } else if (num_focos_aux < 16) {
            this.num_focos = 27;
        } else if (num_focos_aux < 21) {
            this.num_focos = 32;
        } else {
            this.num_focos = 46;
        }
    }

    public void setEst_socio(int est_socio) {
        this.est_socio = est_socio;
    }

    public void setFactor_viv(double factor_viv) {
        this.factor_viv = factor_viv;
    }

    public void setUbica_geo(String ubica_geo) {
        this.ubica_geo = ubica_geo;
    }

    public void setAgeb(String ageb) {
        this.ageb = ageb;
    }

    public int getCuart_dorm() {
        return cuart_dorm;
    }

    public int getMat_pisos() {
        return mat_pisos;
    }

    public int getNum_bano() {
        return num_bano;
    }

    public int getRegadera() {
        return regadera;
    }

    public int getNum_focos() {
        return num_focos;
    }

    public int getEst_socio() {
        return est_socio;
    }

    public double getFactor_viv() {
        return factor_viv;
    }

    public String getUbica_geo() {
        return ubica_geo;
    }

    public String getAgeb() {
        return ageb;
    }
    
}
