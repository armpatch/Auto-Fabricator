package main;

import java.util.ArrayList;
import java.util.UUID;

public class CutGroup {
    private UUID uuid;

    private ArrayList<PipeCut> pipeCuts;
    private float pipeDiameter;
    private boolean isPulledTee;
    private String service;

    public CutGroup(float pipeDiameter, boolean isPulledTee, String service) {
        uuid = UUID.randomUUID();

        setPipeDiameter(pipeDiameter);
        setPulledTee(isPulledTee);
        setService(service);
    }

    public void addPipeCut(PipeCut pipeCut) {
        pipeCuts.add(pipeCut);
    }

    public PipeCut getPipeCut(int index) {
        return pipeCuts.get(index);
    }

    public int size() {
        return pipeCuts.size();
    }

    public void sortByLength() {
        pipeCuts.sort(PipeCut.getLengthComparator());
    }

    // getters and setters

    public float getPipeDiameter() {
        return pipeDiameter;
    }

    public void setPipeDiameter(float pipeDiameter) {
        this.pipeDiameter = pipeDiameter;
    }

    public boolean isPulledTee() {
        return isPulledTee;
    }

    public void setPulledTee(boolean pulledTee) {
        isPulledTee = pulledTee;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}