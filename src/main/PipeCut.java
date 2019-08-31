package main;

import java.util.Comparator;

public class PipeCut {

    private String[] rowData;
    private float lengthDecimal;
    private String service;

    private boolean pulledTee;
    private float diameter;

    PipeCut() {
    }


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

    static Comparator<PipeCut> getLengthComparator(){
        return new Comparator<PipeCut>() {
            @Override
            public int compare(PipeCut o1, PipeCut o2) {
                float length1 = o1.getLength();
                float length2 = o2.getLength();

                return Float.compare(length1, length2);
            }
        };
    }
}
