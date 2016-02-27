package pwc.da.nse;

/**
 *
 * @author Leo
 */
public class Options {
    
    public final static String CSV_FILE_NAME_VIVIENDAS = "viviendas.csv";
    public final static String CSV_FILE_NAME_HOGARES = "hogares.csv";
    public final static String CSV_FILE_NAME_CONCENTRODEHOGAR = "concentradohogar.csv";
    public final static String CSV_FILE_NAME_AGEBS = "ageb.csv";
    
    public final static String CSV_FILE_NAME_OUT = "out.csv";
    
    public final static String CSV_SPLIT = ";";
    public final static String CSV_SECONDARY_SPLIT = ",";
    public final static String OUT_CSV_SPLIT = ",";
    
    public final static String[] VIVIENDAS_FIELDS = {"cuart_dorm","mat_pisos","bano_comp",
                                                     "regadera","focos_inca","focos_ahor",
                                                     "est_socio","factor_viv","ubica_geo",
                                                     "ageb"};
    
    public final static String[] HOGARES_FIELDS = {};
    
    public final static String[] CONCENTRODEHOGAR_FIELDS = {};
    
    public final static String[] OUT_HEADERS = {"cve_ageb","ubica_geo","records","points","nse","est_socio"};
    
}
