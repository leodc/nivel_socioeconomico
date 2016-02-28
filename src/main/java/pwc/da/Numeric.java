package pwc.da;

import java.util.regex.Pattern;

/**
 *
 * @author leo
 */
public class Numeric {

    public static boolean isPositiveNumber(String candidate) {
        return Pattern.matches("[0-9]*\\.?[0-9]*", candidate);
    }

    public static int getPositiveNumber(String candidate, int defaultValue) {
        return (isPositiveNumber(candidate) ? Integer.parseInt(candidate) : defaultValue);
    }
    
    public static double getPositiveNumber(String candidate, double defaultValue){
        return (isPositiveNumber(candidate) ? Double.parseDouble(candidate) : defaultValue);
    }

}
