package pwc.da.nse.options;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leo
 */
public class OptionsTest {

    @Test
    public void testSomeMethod() {
        String string = Options.JSON_OBJECT.getString("csv_split");
        System.out.println(string);
    }
    
}
