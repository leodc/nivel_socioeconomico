package pwc.da.nse;

import pwc.da.nse.entity.ConcentradoHogar;
import pwc.da.nse.entity.FK_Hogar_Vivienda;
import pwc.da.nse.entity.Hogar;
import pwc.da.nse.entity.Vivienda;

/**
 *
 * @author leo
 */
public class Amai_8x7 {

    private ConcentradoHogar concentradoHogar;
    private Hogar hogar;
    private Vivienda vivienda;

    private final FK_Hogar_Vivienda fK_Hogar_Vivienda;

    private double points;

    private String cve_ent;
    private String cve_mun;
    private String cve_loc;

    public Amai_8x7(FK_Hogar_Vivienda fK_Hogar_Vivienda) {
        this.fK_Hogar_Vivienda = fK_Hogar_Vivienda;
    }

    public void setLocalidad() {
        String ubica_geo = vivienda.getUbica_geo();

        cve_ent = ubica_geo.substring(0, 2);
        cve_mun = ubica_geo.substring(2, 5);
        cve_loc = ubica_geo.substring(5, ubica_geo.length());
    }

    public String getCve_ent() {
        return cve_ent;
    }

    public String getCve_loc() {
        return cve_loc;
    }

    public String getCve_mun() {
        return cve_mun;
    }

    public void setPoints() {
        int cuart_dorm = vivienda.getCuart_dorm();
        int mat_pisos = vivienda.getMat_pisos();
        int num_bano = vivienda.getNum_bano();
        int num_focos = vivienda.getNum_focos();
        int regadera = vivienda.getRegadera();

        int viviendaPuntos = cuart_dorm + mat_pisos + num_bano
                + num_focos + regadera;

        int num_auto = hogar.getNum_auto();
        int num_estuf = hogar.getNum_estuf();

        int hogarPuntos = num_auto + num_estuf;

        int concentradoHogarPuntos = concentradoHogar.getEduca_jefe();

        points = viviendaPuntos + hogarPuntos + concentradoHogarPuntos;
    }

    public double getPoints() {
        return points;
    }

    public void setConcentradoHogar(ConcentradoHogar concentradoHogar) {
        this.concentradoHogar = concentradoHogar;
    }

    public void setHogar(Hogar hogar) {
        this.hogar = hogar;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    public ConcentradoHogar getConcentradoHogar() {
        return concentradoHogar;
    }

    public Hogar getHogar() {
        return hogar;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public FK_Hogar_Vivienda getfK_Hogar_Vivienda() {
        return fK_Hogar_Vivienda;
    }

}
