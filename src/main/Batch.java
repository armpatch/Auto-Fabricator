package main;

import java.util.ArrayList;
import java.util.UUID;

public class Batch {
    private static int MAX_STOCK_LENGTH = 220; // inches

    private ArrayList<PipeCut> pipeCuts;

    private UUID uuid;

    private String service;
    private float diameter;
    private boolean isPulledTee;

    private float totalLength;

    public Batch(String service, float diameter, boolean isPulledTee) {
        setService(service);
        setDiameter(diameter);
        setPulledTee(isPulledTee);
    }

    public boolean addPipeCut(PipeCut pipeCut) {
        totalLength += pipeCut.getLength();
        return pipeCuts.add(pipeCut);
    }

    public int size() {
        return pipeCuts.size();
    }

    public float remainingLength() {
        return MAX_STOCK_LENGTH - getTotalLength();
    }

    public PipeCut getPipeCut(int index) {
        return pipeCuts.get(index);
    }

    public ArrayList<PipeCut> getPipeCuts() {
        return pipeCuts;
    }

    // getters and setters

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public boolean isPulledTee() {
        return isPulledTee;
    }

    public void setPulledTee(boolean pulledTee) {
        isPulledTee = pulledTee;
    }

    public float getTotalLength() {
        return totalLength;
    }
}
