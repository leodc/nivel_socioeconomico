package pwc.da.nse.csv.parser;

import pwc.da.Numeric;
import pwc.da.nse.csv.CsvReader;
import pwc.da.nse.entity.ConcentradoHogar;

/**
 *
 * @author leo
 */
public class ConcentradoHogarParser extends CsvReader<ConcentradoHogar>{

    public ConcentradoHogarParser(String fileName, boolean fileHasHeaders, String separator) {
        super(fileName, fileHasHeaders, separator);
    }

    @Override
    protected ConcentradoHogar parse(String[] record) {
        ConcentradoHogar concentradoHogar = new ConcentradoHogar();
        
        concentradoHogar.setEduca_jefe(Numeric.getPositiveNumber(record[12], 0));
        concentradoHogar.setFactor_hog(Numeric.getPositiveNumber(record[120], 0));
        concentradoHogar.setFoliohog(record[1]);
        concentradoHogar.setFolioviv(record[0]);
        
        concentradoHogar.expandRecord();
        
        return concentradoHogar;
    }

}
