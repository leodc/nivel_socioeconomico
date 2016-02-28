package pwc.da.nse.csv;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import pwc.da.nse.entity.Hogar;

/**
 *
 * @author leo
 */
public class HogaresParser extends CsvReader<Hogar>{

    @Override
    protected Hogar parse(String line) {
        return new Hogar();
    }

    @Override
    public Map<String, List<Hogar>> getMap(String fileName, boolean includeHeaders) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
