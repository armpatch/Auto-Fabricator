package main;

import java.util.UUID;

public class PipeCut {

    private UUID uuid;

    private String[] rowData;
    private int lengthDecimal;
    private String service;

    private boolean pulledTee;
    private float diameter;

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

    public int getLengthDecimal() {
        return lengthDecimal;
    }

    public void setLengthDecimal(int lengthDecimal) {
        this.lengthDecimal = lengthDecimal;
    }

    public String getService() {
        return service;
    }

    public void getService(String waterService) {
        this.service = waterService;
    }

    public boolean isPulledTee() {
        return pulledTee;
    }

    public void setPulledTee(boolean pulledTee) {
        this.pulledTee = pulledTee;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }
}
