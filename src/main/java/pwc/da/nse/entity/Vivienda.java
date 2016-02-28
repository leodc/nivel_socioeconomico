package pwc.da.nse.entity;

import java.util.regex.Pattern;

/**
 *
 * @author leo
 */
public class Vivienda {

    private int cuart_dorm;
    private int mat_pisos;
    private int num_bano;
    private int regadera;
    private int num_focos;

    private double factor_viv;

    private String ubica_geo;
    private String ageb;

    private String folioviv;

    /**
     * Numero de cuartos de la vivienda sin contar pasillos y baños.
     *
     * Sí cuentan: recámaras, sala, cocina, comedor, cuarto de lavado, cuarto de
     * TV, biblioteca, cuarto de servicio si está dentro de su vivienda,
     * tapancos, sótano y el garage o cochera sólo si está techado y rodeado de
     * paredes y puertas que impidan mirar al interior del mismo.
     *
     * No cuentan: cobachas, tienditas que estén dentro de la vivienda, garages
     * o cocheras que no tengan techo ni tres paredes y una puerta que impida
     * ver al interior de ellos.
     *
     * @param cuart_dorm -> ENIGH 2014 -> viviendas.num_cuarto [10].
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

    /**
     * Material predominante en el piso de la vivienda.
     *
     * NOTA: El valor & representa un dato “No especificado”.
     *
     * @param mat_pisos -> ENIGH 2014 -> viviendas.mat_pisos [4].
     */
    public void setMat_pisos(int mat_pisos) {
        if (mat_pisos == 3) {
            this.mat_pisos = 11;
        } else {
            this.mat_pisos = 0;
        }
    }

    /**
     * Numero de baños completos (con regadera y excusado) en la vivienda.
     *
     * @param bano_comp -> ENIGH 2014 -> viviendas.bano_comp [17].
     */
    public void setNum_bano(int bano_comp) {
        if (bano_comp < 1) {
            this.num_bano = 0;
        } else if (bano_comp < 2) {
            this.num_bano = 13;
        } else if (bano_comp < 4) {
            this.num_bano = 31;
        } else {
            this.num_bano = 48;
        }
    }

    /**
     * La vivienda dispone con una o más regaderas.
     *
     * @param regadera -> ENIGH 2014 -> viviendas.regadera [42].
     */
    public void setRegadera(int regadera) {
        if (regadera > 0) {
            this.regadera = 10;
        } else {
            this.regadera = 0;
        }
    }

    /**
     * Numero de focos que se usan para iluminar la vivienda, tanto en el
     * interior como en el exterior.
     *
     * Variable construida de la suma de dos variables definidas en el ENIGH. En
     * la regla 8x7 del AMAI se toma en cuenta el numero total de focos, en el
     * cuestionario del ENIGH el numero total de focos se divide en dos:
     * incandecentes y ahorradores
     *
     * @param focos_inca -> ENIGH 2014 -> viviendas.focos_inca [22]
     * @param focos_ahor -> ENIGH 2014 -> viviendas.focos_ahor [23]
     */
    public void setNum_focos(String focos_inca, String focos_ahor) {
        int focos_ahor_aux = Pattern.matches("[0-9*]", focos_ahor) ? Integer.parseInt(focos_ahor) : 0;
        int focos_inca_aux = Pattern.matches("[0-9*]", focos_inca) ? Integer.parseInt(focos_inca) : 0;

        setNum_focos(focos_ahor_aux, focos_inca_aux);
    }
    
    /**
     * Factor de expansión de la vivienda.
     * 
     * Nota: variable definida en el diseño muestral.
     * 
     * @param factor_viv 
     */
    public void setFactor_viv(double factor_viv) {
        this.factor_viv = factor_viv;
    }

    public String getUbica_geo() {
        return ubica_geo;
    }

    public void setUbica_geo(String ubica_geo) {
        this.ubica_geo = ubica_geo;
    }

    public String getAgeb() {
        return ageb;
    }

    public void setAgeb(String ageb) {
        this.ageb = ageb;
    }

    public String getFolioviv() {
        return folioviv;
    }

    public void setFolioviv(String folioviv) {
        this.folioviv = folioviv;
    }

    private void setNum_focos(int focos_ahor, int focos_inca) {
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

    public double getFactor_viv() {
        return factor_viv;
    }
}
