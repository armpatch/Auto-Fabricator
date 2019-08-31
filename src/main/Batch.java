package main;

import java.util.ArrayList;

public class Batch {

    private ArrayList<Pipe> pipes = new ArrayList<>();

    private String service;
    private float diameter;
    private boolean isPulledTee;

    private float totalLength;

    int MAX_TOTAL_LENGTH = 220; // inches

    Batch(String service, float diameter, boolean isPulledTee) {
        setService(service);
        setDiameter(diameter);
        setPulledTee(isPulledTee);
    }

    void addPipe(Pipe pipe) {
        totalLength += pipe.getLength();
        pipes.add(pipe);
    }

    public int size() {
        return pipes.size();
    }

    float getUncutLengthRemaining() {
        return MAX_TOTAL_LENGTH - totalLength;
    }

    public Pipe getPipe(int index) {
        return pipes.get(index);
    }

    public ArrayList<Pipe> getPipes() {
        return pipes;
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

    public float getTotalLength() {
        return totalLength;
    }
}
