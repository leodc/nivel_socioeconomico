package pwc.da.nse.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pwc.da.nse.Localidad;

/**
 *
 * @author leo
 */
public class LocalidadWriter {

    static private class Counter {

        private double e_counter;
        private double d_counter;
        private double dPlus_counter;
        private double cMinus_counter;
        private double c_counter;
        private double cPlus_counter;
        private double ab_counter;

        private int total;

        private void add(double points) {
            if (points < 33) {
                e_counter += points;
            } else if (points < 80) {
                d_counter += points;
            } else if (points < 105) {
                dPlus_counter += points;
            } else if (points < 128) {
                cMinus_counter += points;
            } else if (points < 155) {
                c_counter += points;
            } else if (points < 193) {
                cPlus_counter += points;
            } else {
                ab_counter += points;
            }

            total += points;
        }

    }

    public static void writeNewFile(String file, List<Localidad> localidadList) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add(localidadList.get(0).getHeaders());

        Iterator<Localidad> localidadIterator = localidadList.iterator();

        Counter counter = new Counter();
        while (localidadIterator.hasNext()) {
            Localidad localidad = localidadIterator.next();

            lines.add(localidad.toString());
            counter.add(localidad.getAverage());
        }

        System.out.println("--- Creando archivo de salida.");
        System.out.println("AB:\t" + getAverage(counter.ab_counter, counter.total));
        System.out.println("C+:\t" + getAverage(counter.cPlus_counter , counter.total));
        System.out.println("C:\t" + getAverage(counter.c_counter , counter.total));
        System.out.println("C-:\t" + getAverage(counter.cMinus_counter , counter.total));
        System.out.println("D+:\t" + getAverage(counter.dPlus_counter , counter.total));
        System.out.println("D:\t" + getAverage(counter.d_counter , counter.total));
        System.out.println("E:\t" + getAverage(counter.e_counter , counter.total));

        Files.write(Paths.get(file), lines, StandardCharsets.UTF_8);
    }
    
    private static double getAverage(double counter, double total){
        return ((counter/total)*100);
    }

}
