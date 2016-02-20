package pwc.da.nse.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import pwc.da.nse.Options;

/**
 *
 * @author Leo
 */
public abstract class CsvReader {

    protected TreeMap<String, Integer> fieldsPosition = new TreeMap<>();

    protected void run(String file_name) {
        //El archivo siempre debe de contener los headers

        Path path = Paths.get(file_name);
        try {
            ArrayList<String> aux = new ArrayList<>((Collection<? extends String>) Files.lines(path, StandardCharsets.UTF_8));
            
            String fields[] = {};
            if (null != file_name) switch (file_name) {
                case Options.CSV_FILE_NAME_VIVIENDAS:
                    fields = Options.VIVIENDAS_FIELDS;
                    break;
                case Options.CSV_FILE_NAME_HOGARES:
                    fields = Options.HOGARES_FIELDS;
                    break;
                case Options.CSV_FILE_NAME_CONCENTRODEHOGAR:
                    fields = Options.CONCENTRODEHOGAR_FIELDS;
                    break;
            }
            
            
            getPositions(aux.remove(0), fields);
            

        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + file_name);
        }

    }

    private void getPositions(String line_headers, String... fields) {
        //somebody please optimize this xD
        List<String> asList = Arrays.asList(line_headers.split(Options.CSV_SPLIT));

        for (String field : fields) {
            int position = asList.indexOf(field);
            fieldsPosition.put(field, position);
        }
    }

    abstract protected List<Object> handler(List<String> records);

}
