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
        
        this.points = Float.parseFloat( split[0] + "." + split[1].substring(0, 2));
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
    
    public void addPoints(Amai_8x7 amai){
        points += amai.getPuntos() * amai.getViviendas().getFactor_viv();
        ageb_counter += amai.getViviendas().getFactor_viv();
    }

    public int getAgeb_counter() {
        return ageb_counter;
    }
    
    public double getAverage(){
        return (points/ageb_counter);
    }
    
}
