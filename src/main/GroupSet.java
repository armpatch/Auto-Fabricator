package main;

import java.util.ArrayList;

public class GroupSet {
    private float diameter;
    private boolean isPulledTee;

    private ArrayList<PipeGroup> pipeGroups = new ArrayList<>();

    GroupSet(float diameter, boolean isPulledTee) {
        setDiameter(diameter);
        setPulledTee(isPulledTee);
    }

    void addPipeGroup(PipeGroup pipeGroup) {
        pipeGroups.add(pipeGroup);
    }

    ArrayList<PipeGroup> getPipeGroups() {
        return pipeGroups;
    }

    int size() {
        return pipeGroups.size();
    }

    // getters and setters

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    boolean isPulledTee() {
        return isPulledTee;
    }

    private void setPulledTee(boolean pulledTee) {
        isPulledTee = pulledTee;
    }
}
