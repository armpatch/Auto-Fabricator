package main;

import java.util.Comparator;

public class Pipe {

    private String[] rowData;
    private float lengthDecimal;
    private String service;

    private boolean pulledTee;
    private float diameter;

    String[] getRowData() {
        return rowData;
    }

    void setRowData(String[] rowData) {
        this.rowData = rowData;
    }

    public float getLength() {
        return lengthDecimal;
    }

    public void setLength(float lengthDecimal) {
        this.lengthDecimal = lengthDecimal;
    }

    public String getService() {
        return service;
    }

    void setService(String waterService) {
        this.service = waterService;
    }

    boolean isPulledTee() {
        return pulledTee;
    }

    void setPulledTee(boolean pulledTee) {
        this.pulledTee = pulledTee;
    }

    float getDiameter() {
        return diameter;
    }

    void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    static Comparator<Pipe> getLengthComparator(){
        return new Comparator<Pipe>() {
            @Override
            public int compare(Pipe o1, Pipe o2) {
                float length1 = o1.getLength();
                float length2 = o2.getLength();

                return Float.compare(length1, length2);
            }
        };
    }
}
