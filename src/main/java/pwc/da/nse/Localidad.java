package pwc.da.nse;

/**
 *
 * @author leo
 */
public final class Localidad {

    private String nse;

    private String cve_ent;
    private String cve_mun;
    private String cve_loc;

    private int records;

    private double points = 0;
    
    private double average;

    public Localidad(Amai_8x7 amai_8x7) {
        records = amai_8x7.getVivienda().getFactor_viv();

        cve_ent = amai_8x7.getCve_ent();
        cve_mun = amai_8x7.getCve_mun();
        cve_loc = amai_8x7.getCve_loc();

        setPoints(amai_8x7.getPoints());
    }

    public void setCve_ent(String cve_ent) {
        this.cve_ent = cve_ent;
    }

    public void setCve_loc(String cve_loc) {
        this.cve_loc = cve_loc;
    }

    public void setCve_mun(String cve_mun) {
        this.cve_mun = cve_mun;
    }

    public void setNse(String nse) {
        this.nse = nse;
    }

    /**
     * Allways you call this function make sure you have set the records
     * correctly.
     *
     * @param points -> (points/records)
     */
    public void setPoints(double points) {
        this.points += points;
        average = this.points / records;

        if (average < 33) {
            nse = "E";
        } else if (average < 80) {
            nse = "D";
        } else if (average < 105) {
            nse = "D+";
        } else if (average < 128) {
            nse = "C-";
        } else if (average < 155) {
            nse = "C";
        } else if (average < 193) {
            nse = "C+";
        } else {
            nse = "AB";
        }
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public String getCve_ent() {
        return cve_ent;
    }

    public String getCve_loc() {
        return cve_loc;
    }

    public String getCve_mun() {
        return cve_mun;
    }

    public String getNse() {
        return nse;
    }

    public double getPoints() {
        return points;
    }

    public int getRecords() {
        return records;
    }

    public double getAverage() {
        return average;
    }
    
    

    public void addLocalidad(Amai_8x7 amai_8x7) {
        double amaiPoints = amai_8x7.getPoints();

        records += amai_8x7.getVivienda().getFactor_viv();
        setPoints(amaiPoints);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append(cve_ent).append(",");
        stringBuilder.append(cve_mun).append(",");
        stringBuilder.append(cve_loc).append(",");
        stringBuilder.append(records).append(",");
        stringBuilder.append(average).append(",");
        stringBuilder.append(nse);
        
        return stringBuilder.toString();
    }
    
    public String getHeaders(){
        return "cve_ent,cve_mun,cve_loc,records,average_points,nse";
    }

}
