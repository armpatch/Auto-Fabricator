package main;

import java.util.ArrayList;

public class CutGroupFactory {

    static float[] pipeDiameters = {0.5f, 0.75f, 1.0f, 1.25f, 1.5f};

    public static ArrayList<CutGroup> getFilledCutGroups(ArrayList<PipeCut> pipeCuts) throws Exception {
        ArrayList<CutGroup> cutGroups = getEmptyCutGroups();

        for (PipeCut pipeCut: pipeCuts) {
            CutGroup matchingCutGroup = getMatchingCutGroup(pipeCut, cutGroups);
        }



    }



    private static ArrayList<CutGroup> getEmptyCutGroups() {
        ArrayList<CutGroup> emptyCutGroups = new ArrayList<>();

        for (float pipeDiameter: pipeDiameters){
            emptyCutGroups.add(new CutGroup(pipeDiameter,true));
            emptyCutGroups.add(new CutGroup(pipeDiameter,false));
        }

        return emptyCutGroups;
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


}
