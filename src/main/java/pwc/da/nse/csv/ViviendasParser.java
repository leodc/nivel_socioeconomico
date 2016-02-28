package pwc.da.nse.csv;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
        vivienda.setFolioviv(split[0]);
        vivienda.setAgeb(split[58]);
        vivienda.setFactor_viv(0);
        vivienda.setUbica_geo(line);

        vivienda.setCuart_dorm(0);
        vivienda.setMat_pisos(0);
        vivienda.setNum_bano(0);
        vivienda.setNum_focos(line, line);
        vivienda.setRegadera(0);
        
        return vivienda;
    }

    @Override
    public Map<String, List<Vivienda>> getMap(String fileName, boolean includeHeaders) throws IOException {
        return getRecords(fileName, includeHeaders)
                .collect(Collectors.groupingBy(Vivienda::getFolioviv));
    }

}
