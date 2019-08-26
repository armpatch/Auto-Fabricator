package general;

import java.util.UUID;

public class PipeCut {
    private UUID uuid;

    private int jobNumber;
    private String spool;
    private String itemNumber;
    private String area;
    private String service;
    private String material;
    private String end1;
    private String lengthFractional;
    private String connector1;
    private String connector2;
    private int rawLength;
    private String printer;
    private String bin;

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getSpool() {
        return spool;
    }

    public void setSpool(String spool) {
        this.spool = spool;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getEnd1() {
        return end1;
    }

    public void setEnd1(String end1) {
        this.end1 = end1;
    }

    public String getLengthFractional() {
        return lengthFractional;
    }

    public void setLengthFractional(String lengthFractional) {
        this.lengthFractional = lengthFractional;
    }

    public String getConnector1() {
        return connector1;
    }

    public void setConnector1(String connector1) {
        this.connector1 = connector1;
    }

    public String getConnector2() {
        return connector2;
    }

    public void setConnector2(String connector2) {
        this.connector2 = connector2;
    }

    public int getRawLength() {
        return rawLength;
    }

    public void setRawLength(int rawLength) {
        this.rawLength = rawLength;
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    private String label;

    public PipeCut() {
        uuid = UUID.randomUUID();
    }
}
