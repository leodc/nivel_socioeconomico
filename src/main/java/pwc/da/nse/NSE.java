package pwc.da.nse;

import pwc.da.nse.form.Amai_8x7;

/**
 *
 * @author Leo
 */
public class NSE {

    private float points;

    private int ageb_counter;

    private String ageb;

    private String text;

    private String ubica_geo;

    private float est_socio;
    
    private String geometry;
    
    private String cve_ent;
    private String cve_mun;

    public String getCve_mun() {
        return cve_mun;
    }

    public String getCve_ent() {
        return cve_ent;
    }

    public void setCve_mun(String cve_mun) {
        this.cve_mun = cve_mun;
    }

    public void setCve_ent(String cve_ent) {
        this.cve_ent = cve_ent;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public String getGeometry() {
        return geometry;
    }
    
    public void setEst_socio(float est_socio) {
        this.est_socio = est_socio;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    public float getEst_socio() {
        return est_socio;
    }

    public void setUbica_geo(String ubica_geo) {
        this.ubica_geo = ubica_geo;
    }

    public String getUbica_geo() {
        return ubica_geo;
    }

    public NSE(String ageb) {
        points = 0;
        ageb_counter = 0;

        this.ageb = ageb;
    }

    public void setAgeb(String ageb) {
        this.ageb = ageb;
    }

    public void setAgeb_counter(int ageb_counter) {
        this.ageb_counter = ageb_counter;
    }

    public void setPoints(double points) {
        String valueOf = String.valueOf(points);
        String[] split = valueOf.split(".");

        this.points = Float.parseFloat(split[0] + "." + split[1].substring(0, 2));
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getAgeb() {
        return ageb;
    }

    public double getPoints() {
        return points;
    }

    public void addPoints(Amai_8x7 amai) {
        points += amai.getPuntos() * amai.getViviendas().getFactor_viv();
        ageb_counter += amai.getViviendas().getFactor_viv();
        est_socio += amai.getViviendas().getEst_socio() * amai.getViviendas().getFactor_viv();
    }

    public int getAgeb_counter() {
        return ageb_counter;
    }

    public double getAverage() {
        return (points / ageb_counter);
    }

    public String getLevel() {
        String nse;
        double points = getAverage();
        if( points < 33 ){
            nse = "E";
        }else if( points < 80){
            nse = "D";
        }else if( points < 105){
            nse = "D+";
        }else if( points < 128){
            nse = "C-";
        }else if( points < 155){
            nse = "C";
        }else if( points < 193){
            nse = "C+";
        }else{
            nse = "AB";
        }
        
        return nse;
    }

    @Override
    public String toString() {
        String aux = ageb + Options.OUT_CSV_SPLIT;
        aux += ubica_geo + Options.OUT_CSV_SPLIT;
        aux += ageb_counter + Options.OUT_CSV_SPLIT;
        aux += getAverage() + Options.OUT_CSV_SPLIT;
        aux += getLevel() + Options.OUT_CSV_SPLIT;
        aux += (est_socio/ageb_counter);
        //aux += geometry;

        return aux;
    }

}
