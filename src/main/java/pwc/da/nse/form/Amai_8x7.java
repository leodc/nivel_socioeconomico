package pwc.da.nse.form;

/**
 *
 * @author Leo
 */
public class Amai_8x7 {

    private Viviendas viviendas;
    private Hogares hogares;
    private Concentrodehogar concentrodehogar;
    
    
    public Amai_8x7(Viviendas viviendas, Hogares hogares, Concentrodehogar concentrodehogar) {
        this.viviendas = viviendas;
        this.hogares = hogares;
        this.concentrodehogar = concentrodehogar;
    }

    public Viviendas getViviendas() {
        return viviendas;
    }

    public void setViviendas(Viviendas viviendas) {
        this.viviendas = viviendas;
    }

    public Hogares getHogares() {
        return hogares;
    }

    public void setHogares(Hogares hogares) {
        this.hogares = hogares;
    }

    public Concentrodehogar getConcentrodehogar() {
        return concentrodehogar;
    }

    public void setConcentrodehogar(Concentrodehogar concentrodehogar) {
        this.concentrodehogar = concentrodehogar;
    }

}
