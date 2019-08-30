package main;

import java.util.ArrayList;

public class CutGroup {
    private ArrayList<PipeCut> pipeCuts = new ArrayList<>();
    private float diameter;
    private boolean isPulledTee;
    private String service;

    CutGroup(float diameter, boolean isPulledTee, String service) {
        setDiameter(diameter);
        setPulledTee(isPulledTee);
        setService(service);
    }

    void addPipeCut(PipeCut pipeCut) {
        pipeCuts.add(pipeCut);
    }

    void removePipeCut(PipeCut pipeCut) {
        pipeCuts.remove(pipeCut);
    }

    PipeCut getPipeCut(int index) {
        return pipeCuts.get(index);
    }

    ArrayList<PipeCut> getPipeCuts() {
        return pipeCuts;
    }

    public int size() {
        return pipeCuts.size();
    }

    void sortByLength() {
        pipeCuts.sort(PipeCut.getLengthComparator());
    }

    // getters and setters

    float getDiameter() {
        return diameter;
    }

    private void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    boolean isPulledTee() {
        return isPulledTee;
    }

    private void setPulledTee(boolean pulledTee) {
        isPulledTee = pulledTee;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}