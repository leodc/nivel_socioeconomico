package pwc.da.nse.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import pwc.da.nse.Options;

/**
 *
 * @author Leo
 */
public class CsvReader {

    public static Object[] getLines(String file_name) throws IOException {
        Path path = Paths.get(file_name);

        return Files.lines(path, StandardCharsets.UTF_8).skip(1).toArray();
    }

    public static void get(String fileName) throws IOException {

        try ( BufferedReader br = new BufferedReader( new FileReader(fileName) ) ) {

            String line;
            String[] headerLine = br.readLine().split(Options.CSV_SPLIT);
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } 
    }

}
