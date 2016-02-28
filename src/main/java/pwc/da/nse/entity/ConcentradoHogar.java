package pwc.da.nse.entity;

import java.util.regex.Pattern;

/**
 *
 * @author leo
 */
public class ConcentradoHogar {
    
    /*
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
     */
    private int educa_jefe;

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

    public void setEduca_jefe(String educa_jefe) {
        int aux = Pattern.matches("[0-9]*", educa_jefe) ? Integer.parseInt(educa_jefe) : 0;
        setEduca_jefe(aux);
    }

    public int getEduca_jefe() {
        return educa_jefe;
    }

}
