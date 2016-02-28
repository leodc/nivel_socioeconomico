package pwc.da.nse.csv.parser;

import pwc.da.Numeric;
import pwc.da.nse.csv.CsvReader;
import pwc.da.nse.entity.Vivienda;

/**
 *
 * @author leo
 */
public class ViviendasParser extends CsvReader<Vivienda> {

    public ViviendasParser(String fileName, boolean fileHasHeaders, String separator) {
        super(fileName, fileHasHeaders, separator);
    }

    @Override
    protected Vivienda parse(String record[]) {
        Vivienda vivienda = new Vivienda();

        //Fill survey
        vivienda.setAgeb(record[58]);
        vivienda.setNum_cuarto(Numeric.getPositiveNumber(record[10], 0));
        vivienda.setMat_pisos(Numeric.getPositiveNumber(record[4], 0));
        vivienda.setNum_bano(Numeric.getPositiveNumber(record[17], 0));
        vivienda.setNum_cuarto(Numeric.getPositiveNumber(record[10], 0));
        vivienda.setNum_focos(Numeric.getPositiveNumber(record[22], 0), Numeric.getPositiveNumber(record[23], 0));
        vivienda.setRegadera(Numeric.getPositiveNumber(record[42], 0));

        vivienda.setFactor_viv(Numeric.getPositiveNumber(record[63], 1));
        vivienda.setFolioviv(record[0]);
        vivienda.setUbica_geo(record[57]);

        //Factor de espansión
        vivienda.expandRecord();

        return vivienda;
    }

}
