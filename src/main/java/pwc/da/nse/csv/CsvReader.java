package pwc.da.nse.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 * @author leo
 * @param <T>
 */
public abstract class CsvReader<T> {

    /**
     * Function that will be used to create each object of type T
     */
    private final Function parser = (Function<String, T>) (String t) -> {
        return parse(t);
    };

    /**
     *
     * @param fileName
     * @param includeHeaders
     * @return Stream<T>
     * @throws IOException
     */
    public Stream<T> getRecords(String fileName, boolean includeHeaders) throws IOException {

        Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8);

        if (includeHeaders) {
            stream = stream.skip(1);
        }

        return stream.map(parser);
    }

    /**
     * This method returns a Map<String, List<T>> object, grouping all records
     * with the function gived in the Collectors
     *
     * @param fileName
     * @param includeHeaders
     * @return returns a Map<String, List<Vivienda>> 
     * @thr
     * ows IOException
     */
    public abstract Map<String, List<T>> getMap(String fileName, boolean includeHeaders) throws IOException;

    protected abstract T parse(String line);

}
