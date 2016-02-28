package pwc.da.nse.csv.parser;

import pwc.da.Numeric;
import pwc.da.nse.csv.CsvReader;
import pwc.da.nse.entity.Hogar;

/**
 *
 * @author leo
 */
public class HogaresParser extends CsvReader<Hogar>{

    public HogaresParser(String fileName, boolean fileHasHeaders, String separator) {
        super(fileName, fileHasHeaders, separator);
    }

    @Override
    protected Hogar parse(String record[]) {
        Hogar hogar = new Hogar();
        
        hogar.setFactor_hog(Numeric.getPositiveNumber(record[120], 1));
        hogar.setFoliohog(record[1]);
        hogar.setFolioviv(record[0]);
        hogar.setNum_auto(Numeric.getPositiveNumber(record[39], 0));
        hogar.setNum_estuf(Numeric.getPositiveNumber(record[79], 0));
        
        hogar.expandRecord();
        
        return hogar;
    }

}
