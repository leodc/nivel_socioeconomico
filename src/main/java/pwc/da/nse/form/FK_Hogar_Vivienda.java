package pwc.da.nse.form;


/**
 *
 * @author Leo
 */
public class FK_Hogar_Vivienda {
    
    private final String folioviv;
    private final String foliohog;

    public FK_Hogar_Vivienda(String folioviv, String foliohog) {
        this.folioviv = folioviv;
        this.foliohog = foliohog;
    }
    
    @Override
    public boolean equals(Object obj) {
        if( obj != null && obj instanceof FK_Hogar_Vivienda ){
            FK_Hogar_Vivienda key = (FK_Hogar_Vivienda) obj;
            
            return ( foliohog.equals(key.foliohog) && folioviv.equals(key.folioviv) );
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        return (folioviv + foliohog).hashCode();
    }
    
}
