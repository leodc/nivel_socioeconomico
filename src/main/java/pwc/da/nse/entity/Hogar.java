package pwc.da.nse.entity;

/**
 *
 * @author Leo
 */
public class Hogar {

    private String foliohog;
    private String folioviv;

    private int num_estuf;
    private int num_auto;

    private int factor_hog;

    /**
     * Identificador de la vivienda.
     *
     * @param folioviv -> ENIGH 2014 -> hogares.folioviv [0]
     */
    public void setFolioviv(String folioviv) {
        this.folioviv = folioviv;
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
     * @param foliohog -> ENIGH 2014 -> hogares.foliohog [1]
     */
    public void setFoliohog(String foliohog) {
        this.foliohog = foliohog;
    }

    /**
     * Número de estufas de gas o eléctricas con las que cuenta el hogar.
     *
     * NOTA: El valor -1, representa un dato “No especificado”.
     *
     * @param num_estuf -> ENIGH 2014 -> hogares.num_estuf [79]
     */
    public void setNum_estuf(int num_estuf) {
        if (num_estuf > 0) {
            this.num_estuf = 20;
        } else {
            this.num_estuf = 0;
        }
    }

    /**
     * Número de automóviles con los que cuenta el hogar.
     *
     * @param num_auto -> ENIGH 2014 -> hogares.num_auto [39]
     */
    public void setNum_auto(int num_auto) {
        if (num_auto < 1) {
            this.num_auto = 0;
        } else if (num_auto < 2) {
            this.num_auto = 32;
        } else if (num_auto < 3) {
            this.num_auto = 41;
        } else {
            this.num_auto = 58;
        }
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

    public int getNum_estuf() {
        return num_estuf;
    }

    public int getFactor_hog() {
        return factor_hog;
    }

    public int getNum_auto() {
        return num_auto;
    }

    public String getFolioviv() {
        return folioviv;
    }

    public void expandRecord() {
        num_estuf *= factor_hog;
        num_auto *= factor_hog;
    }

}
