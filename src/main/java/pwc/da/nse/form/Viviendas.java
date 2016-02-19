package pwc.da.nse.form;

/**
 *
 * @author Leo
 */
public class Viviendas {

    private int cuart_dorm;
    private int mat_pisos;
    private int num_bano;
    private int regadera;
    private int num_focos;

    private int est_socio;

    private double factor_viv = 0.0D;

    private String ubica_geo;
    private String ageb;
    
    public double getPoints(){
        double sum = cuart_dorm + mat_pisos + num_bano + regadera + num_focos;
        
        if( factor_viv > 0.0D ){
            sum *= factor_viv;
        }
        
        return sum;
    }

    /*
    *   @cuart_dorm -> Numero de cuartos
    *   Numero de cuartos o habitaciones
    *           1 a 4  |  5 a 6  |  7 o más
    *   puntos:   0         8         14
    *   
     */
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
        this.num_bano = bano_comp;
    }

    public void setRegadera(int regadera) {
        if (regadera > 0) {
            this.regadera = 11;
        } else {
            this.regadera = 0;
        }
    }

    public void setNum_focos(int focos_inca, int focos_ahor) {
        
        focos_inca = (focos_inca > 0) ? focos_inca:0;
        focos_ahor = (focos_ahor > 0) ? focos_ahor:0;
        
        int num_focos = focos_ahor + focos_inca;
        
        if (num_focos < 5) {
            this.num_focos = 0;
        } else if (num_focos < 11) {
            this.num_focos = 15;
        } else if (num_focos < 16) {
            this.num_focos = 27;
        } else if (num_focos < 21) {
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
