package pwc.da.nse.form;

/**
 *
 * @author Leo
 */
public final class Amai_8x7 {

    private Vivienda vivienda;
    private Hogar hogares;
    private Concentrodehogar concentrodehogar;
    
    private double puntos;
    
    
    public Amai_8x7(Vivienda vivienda){
        this.vivienda = vivienda;
    }
    
    public double getPuntos() {
        return puntos;
    }
    
    public void updatePoint(){
        puntos = vivienda.getPoints(false) + hogares.getPoints(false) + concentrodehogar.getPoints();
    }

    public Concentrodehogar getConcentrodehogar() {
        return concentrodehogar;
    }

    public Hogar getHogares() {
        return hogares;
    }

    public Vivienda getViviendas() {
        return vivienda;
    }

    public void setConcentrodehogar(Concentrodehogar concentrodehogar) {
        this.concentrodehogar = concentrodehogar;
    }

    public void setHogares(Hogar hogares) {
        this.hogares = hogares;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }
    
}
