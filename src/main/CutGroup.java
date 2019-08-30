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

    public void addPipeCut(PipeCut pipeCut) {
        pipeCuts.add(pipeCut);
    }

    public void removePipeCut(PipeCut pipeCut) {
        pipeCuts.remove(pipeCut);
    }

    public int size() {
        return pipeCuts.size();
    }

    public void sortByLength() {
        pipeCuts.sort(PipeCut.getLengthComparator());
    }
}