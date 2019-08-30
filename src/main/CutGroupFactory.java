package main;

import java.util.ArrayList;

class CutGroupFactory {

    private static float[] pipeDiameters = {0.5f, 0.75f, 1.0f, 1.25f, 1.5f};
    private static String[] services = {"HW", "CW"};

    static ArrayList<CutGroup> createCutGroups(ArrayList<PipeCut> pipeCuts) {
        ArrayList<CutGroup> cutGroups = getEmptyCutGroups();

        putPipeCutsIntoGroups(pipeCuts, cutGroups);
        removeEmptyGroups(cutGroups);

        return cutGroups;
    }

    private static ArrayList<CutGroup> getEmptyCutGroups() {
        ArrayList<CutGroup> emptyCutGroups = new ArrayList<>();

        for (float pipeDiameter: pipeDiameters){
            for (String service: services) {
                emptyCutGroups.add(new CutGroup(pipeDiameter,true, service));
                emptyCutGroups.add(new CutGroup(pipeDiameter,false, service));
            }
        }

        return emptyCutGroups;
    }

    private static void putPipeCutsIntoGroups(ArrayList<PipeCut> pipeCuts, ArrayList<CutGroup> cutGroups) {
        for (PipeCut pipeCut: pipeCuts) {
            CutGroup matchingCutGroup = getMatchingCutGroup(pipeCut, cutGroups);
            matchingCutGroup.addPipeCut(pipeCut);
        }
    }

    private static CutGroup getMatchingCutGroup(PipeCut pipeCut, ArrayList<CutGroup> cutGroups) {
        CutGroup output = null;
        for (CutGroup cutGroup: cutGroups) {
            if (pipeCut.isPulledTee() == cutGroup.isPulledTee() &&
            pipeCut.getDiameter() == cutGroup.getDiameter()) {
                output = cutGroup;
            }
        }
        return output;
    }

    private static void removeEmptyGroups(ArrayList<CutGroup> cutGroups) {
        ArrayList<CutGroup> groupsToRemove = new ArrayList<>();

        for (CutGroup group: cutGroups) {
            if (group.size() == 0) groupsToRemove.add(group);
        }

        cutGroups.removeAll(groupsToRemove);
    }

}
