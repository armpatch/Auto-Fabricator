package util;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Bundle {

    private ArrayList<Pipe> pipes = new ArrayList<>();

    private String service;
    private float diameter;
    private boolean isPulledTee;

    private float combinedLength;

    private int MAX_COMBINED_LENGTH = 223; // inches

    Bundle(String service, float diameter, boolean isPulledTee) {
        setService(service);
        setDiameter(diameter);
        setPulledTee(isPulledTee);
    }

    void addPipe(Pipe pipe) {
        setCombinedLength(getCombinedLength() + pipe.getLength());
        pipes.add(pipe);
    }

    public ArrayList<Pipe> getPipes() {
        return pipes;
    }

    public int getCount() {
        return pipes.size();
    }

    float getRemainingLength() {
        return MAX_COMBINED_LENGTH - getCombinedLength();
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

    private void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public boolean isPulledTee() {
        return isPulledTee;
    }

    private void setPulledTee(boolean pulledTee) {
        isPulledTee = pulledTee;
    }

    private void setCombinedLength(float length) {
        DecimalFormat df = new DecimalFormat(".##");

        combinedLength = Float.valueOf(df.format(length));
    }

    public float getCombinedLength() {
        return combinedLength;
    }
}
