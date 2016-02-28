package pwc.da.nse.entity;

/**
 *
 * @author leo
 */
public class ConcentradoHogar {

    private int educa_jefe;

    private String foliohog;
    private String folioviv;

    private int factor_hog;

    /**
     * Educación formal del jefe del hogar.
     * 
     * Variable construida con las siguientes codiciones:
     * educa_jefe = 01 (Si nivelaprob = 0)
     * educa_jefe = 02 (Si nivelaprob = 1)
     * educa_jefe = 03 (Si nivelaprob = 2 y gradoaprob < 6)
     * educa_jefe = 04 (Si nivelaprob = 2 y gradoaprob = 6) ó ((nivelaprob = 5 ó nivelaprob = 6) y antec_esc = 1)
     * educa_jefe = 05 (Si nivelaprob = 3 y gradoaprob < 3) 
     * educa_jefe = 06 (Si nivelaprob = 3 y gradoaprob = 3) ó ((nivelaprob = 5 ó nivelaprob = 6) y antec_esc = 2) 
     * educa_jefe = 07 (Si nivelaprob = 4 y gradoaprob < 3) 
     * educa_jefe = 08 (Si nivelaprob = 4 y gradoaprob = 3) ó ((nivelaprob = 5 ó nivelaprob = 6) y antec_esc = 3) 
     * educa_jefe = 09 (Si nivelaprob = 7 y gradoaprob < 4)
     * educa_jefe = 10 (Si nivelaprob = 7 y gradoaprob >= 4) ó ((nivelaprob = 5 ó nivelaprob = 6) y antec_esc = 4) 
     * educa_jefe = 11 (Si nivelaprob = 8 ó nivelaprob = 9) ó ((nivelaprob = 5 ó nivelaprob = 6) y antec_esc = 5)
     * 
     * @param educa_jefe -> ENIGH 2014 -> concentradohogar.educa_jefe [12]
     */
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

    /**
     * Identificador del hogar.
     *
     * El código 1 identifica al hogar principal y del 2 al 5 los hogares
     * adicionales.
     *
     * NOTA: Variable construida a partir del folio registrado en la portada de
     * los cuestionarios.
     *
     * @param foliohog -> ENIGH 2014 -> concentradohogar.foliohog [1]
     */
    public void setFoliohog(String foliohog) {
        this.foliohog = foliohog;
    }

    /**
     * Identificador de la vivienda.
     *
     * @param folioviv -> ENIGH 2014 -> concentradohogar.folioviv [0]
     */
    public void setFolioviv(String folioviv) {
        this.folioviv = folioviv;
    }

    /**
     * Factor de expansión del hogar.
     *
     * El ENIGH al ser una encuesta muestral se debe de contar con un
     * ponderador, éste es el factor de expansión, que se interpreta como la
     * cantidad de viviendas (hogares o personas) en la población, que
     * representa una vivienda en la muestra.
     *
     * Para obtener cualquier tipo de información se requiere multiplicar el
     * valor de la variable en estudio, por el factor mencionado de acuerdo con
     * el nivel al cual esté asociada.
     *
     * NOTA: Variable definida en el diseño muestral.
     *
     * @param factor_hog -> ENIGH 2014 -> hogares.factor_hog [120]
     */
    public void setFactor_hog(int factor_hog) {
        this.factor_hog = factor_hog;
    }

    public String getFoliohog() {
        return foliohog;
    }

    public String getFolioviv() {
        return folioviv;
    }

    public int getEduca_jefe() {
        return educa_jefe;
    }

    public int getFactor_hog() {
        return factor_hog;
    }

    public void expandRecord() {
        educa_jefe *= factor_hog;
    }

}
