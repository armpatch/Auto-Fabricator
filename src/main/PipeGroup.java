package main;

import java.util.ArrayList;

public class PipeGroup {
    private ArrayList<Pipe> pipes = new ArrayList<>();
    private float diameter;
    private boolean isPulledTee;
    private String service;

    PipeGroup(float diameter, boolean isPulledTee, String service) {
        setDiameter(diameter);
        setPulledTee(isPulledTee);
        setService(service);
    }

    void addPipe(Pipe pipe) {
        pipes.add(pipe);
    }

    void removePipe(Pipe pipe) {
        pipes.remove(pipe);
    }

    Pipe getPipe(int index) {
        return pipes.get(index);
    }

    ArrayList<Pipe> getPipes() {
        return pipes;
    }

    public int size() {
        return pipes.size();
    }

    void sortByLength() {
        pipes.sort(Pipe.getLengthComparator());
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