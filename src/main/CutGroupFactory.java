package main;

import java.util.ArrayList;

public class CutGroupFactory {

    static float[] pipeDiameters = {0.5f, 0.75f, 1.0f, 1.25f, 1.5f};

    public static ArrayList<CutGroup> getFilledCutGroups(ArrayList<PipeCut> pipeCuts) throws Exception {
        ArrayList<CutGroup> cutGroups = getEmptyCutGroups();

        sortPipeCutsIntoCutGroups(cutGroups, pipeCuts);
        removeEmptyCutGroups(cutGroups);

        return cutGroups;
    }

    private static ArrayList<CutGroup> getEmptyCutGroups() {
        ArrayList<CutGroup> emptyCutGroups = new ArrayList<>();

        for (float pipeDiameter: pipeDiameters){
            emptyCutGroups.add(new CutGroup(pipeDiameter,true));
            emptyCutGroups.add(new CutGroup(pipeDiameter,false));
        }

        return emptyCutGroups;
    }

    private static void sortPipeCutsIntoCutGroups(ArrayList<CutGroup> cutGroups, ArrayList<PipeCut> pipeCuts)
            throws Exception {
        for (PipeCut pipeCut: pipeCuts) {
            CutGroup matchingCutGroup = getMatchingCutGroup(pipeCut, cutGroups);
            matchingCutGroup.addPipeCut(pipeCut);
        }
    }

    private static CutGroup getMatchingCutGroup(PipeCut pipeCut, ArrayList<CutGroup> cutGroups) throws Exception {
        for (CutGroup cutGroup: cutGroups) {
            if (pipeCut.isPulledTee() == cutGroup.isPulledTee() &&
            pipeCut.getDiameter() == cutGroup.getPipeDiameter()) {
                return cutGroup;
            }
        }
        throw new Exception("getMatchingCutGroup: Could not find a group that matches PipeCut");
    }

    private static void removeEmptyCutGroups(ArrayList<CutGroup> cutGroups) {
        for (CutGroup cutGroup: cutGroups) {
            if (cutGroup.size() == 0) {
                cutGroups.remove(cutGroup);
            }
        }
    }

    private static ArrayList<CutGroup> getNonEmptyCutGroups(ArrayList<CutGroup> inputGroups) {
        ArrayList<CutGroup> nonEmptyGroups = new ArrayList<>();

        for (CutGroup cutGroup : inputGroups) {
            if (cutGroup.size() != 0)
                nonEmptyGroups.add(cutGroup);
        }

        return nonEmptyGroups;
    }

}
