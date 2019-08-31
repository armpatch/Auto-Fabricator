package main;

import java.util.ArrayList;

class PipeGroupFactory {

    private static float[] pipeDiameters = {0.5f, 0.75f, 1.0f, 1.25f, 1.5f};
    private static String[] services = {"HW", "CW"};

    static ArrayList<PipeGroup> createPipeGroups(ArrayList<Pipe> pipes) {
        ArrayList<PipeGroup> pipeGroups = getEmptyPipeGroups();

        fillPipeGroupsWithPipe(pipes, pipeGroups);
        removeEmptyGroups(pipeGroups);

        return pipeGroups;
    }

    private static ArrayList<PipeGroup> getEmptyPipeGroups() {
        ArrayList<PipeGroup> emptyPipeGroups = new ArrayList<>();

        for (float pipeDiameter: pipeDiameters){
            for (String service: services) {
                emptyPipeGroups.add(new PipeGroup(pipeDiameter,true, service));
                emptyPipeGroups.add(new PipeGroup(pipeDiameter,false, service));
            }
        }

        return emptyPipeGroups;
    }

    private static void fillPipeGroupsWithPipe(ArrayList<Pipe> pipes, ArrayList<PipeGroup> pipeGroups) {
        for (Pipe pipe : pipes) {
            PipeGroup matchingPipeGroup = getMatchingPipeGroup(pipe, pipeGroups);
            matchingPipeGroup.addPipe(pipe);
        }
    }

    private static PipeGroup getMatchingPipeGroup(Pipe pipe, ArrayList<PipeGroup> pipeGroups) {
        PipeGroup output = null;
        for (PipeGroup pipeGroup : pipeGroups) {
            if (pipe.isPulledTee() == pipeGroup.isPulledTee() &&
            pipe.getDiameter() == pipeGroup.getDiameter() &&
            pipe.getService().equals(pipeGroup.getService()))
            {
                output = pipeGroup;
            }
        }
        return output;
    }

    private static void removeEmptyGroups(ArrayList<PipeGroup> pipeGroups) {
        ArrayList<PipeGroup> groupsToRemove = new ArrayList<>();

        for (PipeGroup group: pipeGroups) {
            if (group.size() == 0) groupsToRemove.add(group);
        }

        pipeGroups.removeAll(groupsToRemove);
    }

}
