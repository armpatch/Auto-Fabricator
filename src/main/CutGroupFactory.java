package main;

import java.util.ArrayList;

public class CutGroupFactory {

    static float[] pipeDiameters = {0.5f, 0.75f, 1.0f, 1.25f, 1.5f};

    public static ArrayList<CutGroup> getCutGroups(ArrayList<PipeCut> pipeCuts) {
        ArrayList<CutGroup> cutGroups = new ArrayList<>();


    }



    private static ArrayList<CutGroup> getEmptyCutGroups() {
        ArrayList<CutGroup> emptyCutGroups = new ArrayList<>();

        for (float pipeDiameter: pipeDiameters){
            emptyCutGroups.add(new CutGroup(pipeDiameter,true));
            emptyCutGroups.add(new CutGroup(pipeDiameter,false));
        }

        return emptyCutGroups;
    }


}
