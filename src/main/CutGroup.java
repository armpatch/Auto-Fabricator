package main;

import java.util.ArrayList;
import java.util.UUID;

public class CutGroup {
    private UUID uuid;

    private ArrayList<PipeCut> pipeCuts;
    private float pipeDiameter;
    private boolean isPulledTee;

    public CutGroup(float pipeDiameter, boolean isPulledTee) {
        uuid = UUID.randomUUID();

        this.pipeDiameter = pipeDiameter;
        this.isPulledTee = isPulledTee;
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
}