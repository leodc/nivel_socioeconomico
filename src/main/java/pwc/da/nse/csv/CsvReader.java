package pwc.da.nse.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author leo
 * @param <T>
 */
public abstract class CsvReader<T> {

    protected String fileName;
    protected boolean fileHasHeaders;
    protected final String separator;

    private final Function parser;

    public CsvReader(String fileName, boolean fileHasHeaders, String separator) {
        this.fileName = fileName;
        this.fileHasHeaders = fileHasHeaders;
        this.separator = separator;

        parser = (Function<String, T>) (String t) -> {
            return parse(t.split(separator));
        };
    }

    /**
     *
     * @return Stream<T>
     * @throws IOException
     */
    public Stream<T> getRecords() throws IOException {
        Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8);

        if (fileHasHeaders) {
            stream = stream.skip(1);
        }

        return stream.map(parser);
    }

    protected abstract T parse(String record[]);

}
