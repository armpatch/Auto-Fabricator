package main;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Bundle {

    private ArrayList<Pipe> pipes = new ArrayList<>();

    private String service;
    private float diameter;
    private boolean isPulledTee;

    private float totalLength;

    private int TOTAL_LENGTH_MAX = 223; // inches

    Bundle(String service, float diameter, boolean isPulledTee) {
        setService(service);
        setDiameter(diameter);
        setPulledTee(isPulledTee);
    }

    void addPipe(Pipe pipe) {
        setTotalLength(getTotalLength() + pipe.getLength());
        pipes.add(pipe);
    }

    ArrayList<Pipe> getPipes() {
        return pipes;
    }

    public int getCount() {
        return pipes.size();
    }

    float getRemainingLength() {
        return TOTAL_LENGTH_MAX - getTotalLength();
    }

    // getters and setters

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

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

    private void setTotalLength(float length) {
        DecimalFormat df = new DecimalFormat(".##");

        totalLength = Float.valueOf(df.format(length));
    }

    float getTotalLength() {
        return totalLength;
    }
}
