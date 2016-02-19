package pwc.da.nse.form;

/**
 *
 * @author Leo
 */
public final class Amai_8x7 {

    private final Viviendas viviendas;
    private final Hogares hogares;
    private final Concentrodehogar concentrodehogar;
    
    private double puntos;
    
    
    public Amai_8x7(Viviendas viviendas, Hogares hogares, Concentrodehogar concentrodehogar) {
        this.viviendas = viviendas;
        this.hogares = hogares;
        this.concentrodehogar = concentrodehogar;
        
        updatePoint();
    }

    public double getPuntos() {
        return puntos;
    }
    
    public void updatePoint(){
        puntos = viviendas.getPoints() + hogares.getPoints() + concentrodehogar.getPoints();
    }

    public Concentrodehogar getConcentrodehogar() {
        return concentrodehogar;
    }

    public Hogares getHogares() {
        return hogares;
    }

    public Viviendas getViviendas() {
        return viviendas;
    }
    
}
