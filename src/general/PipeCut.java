package general;

import java.util.UUID;

public class PipeCut {

    private UUID uuid;

    private String[] rowData;
    private String spool;
    private String service;

    private String diameter; // end1 on csv
    private int lengthDecimal;

    public PipeCut() {
        uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String[] getRowData() {
        return rowData;
    }

    public void setRowData(String[] rowData) {
        this.rowData = rowData;
    }

    public String getSpool() {
        return spool;
    }

    public void setSpool(String spool) {
        this.spool = spool;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public int getLengthDecimal() {
        return lengthDecimal;
    }

    public void setLengthDecimal(int lengthDecimal) {
        this.lengthDecimal = lengthDecimal;
    }




}
