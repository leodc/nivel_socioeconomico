package pwc.da.nse.csv.parser;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pwc.da.Numeric;
import pwc.da.nse.csv.CsvReader;
import pwc.da.nse.options.Options;
import pwc.da.nse.entity.Vivienda;

/**
 *
 * @author leo
 */
public class ViviendasParser extends CsvReader<Vivienda> {

    @Override
    protected Vivienda parse(String line) {
        String[] split = line.split(Options.JSON_OBJECT.getString("csv_split"));

        Vivienda vivienda = new Vivienda();

        //Fill survey
        vivienda.setAgeb(split[58]);
        vivienda.setNum_cuarto(Numeric.getPositiveNumber(split[10],0));
        vivienda.setMat_pisos(Numeric.getPositiveNumber(split[4],0));
        vivienda.setNum_bano(Numeric.getPositiveNumber(split[17],0));
        vivienda.setNum_cuarto(Numeric.getPositiveNumber(split[10],0));
        vivienda.setNum_focos(Numeric.getPositiveNumber(split[22],0), Numeric.getPositiveNumber(split[23],0));
        vivienda.setRegadera(Numeric.getPositiveNumber(split[42],0));
        
        vivienda.setFactor_viv(Numeric.getPositiveNumber(split[63], 1.0D));
        vivienda.setFolioviv(split[0]);
        vivienda.setUbica_geo(split[57]);
        
        return vivienda;
    }

    @Override
    public Map<String, List<Vivienda>> getMap(String fileName, boolean includeHeaders) throws IOException {
        return getRecords(fileName, includeHeaders)
                .collect(Collectors.groupingBy(Vivienda::getFolioviv));
    }

}
