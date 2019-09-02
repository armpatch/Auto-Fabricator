package main;

import java.util.ArrayList;

class GroupSetFactory {

    private static float[] pipeDiameters = {0.5f, 0.75f, 1.0f, 1.25f, 1.5f};

    static ArrayList<GroupSet> createGroupSets(ArrayList<PipeGroup> pipeGroups) {
        ArrayList<GroupSet> groupSets = getEmptyGroupSets();

        fillGroupSetsWithPipeGroups(pipeGroups, groupSets);
        removeEmptyGroupSets(groupSets);

        return groupSets;
    }

    private static ArrayList<GroupSet> getEmptyGroupSets() {
        ArrayList<GroupSet> emptyGroupSets = new ArrayList<>();

        // sorted by: diameter, pulled tee
        for (float pipeDiameter: pipeDiameters){
            emptyGroupSets.add(new GroupSet(pipeDiameter,true));
            emptyGroupSets.add(new GroupSet(pipeDiameter,false));
        }

        return emptyGroupSets;
    }

    private static void fillGroupSetsWithPipeGroups(ArrayList<PipeGroup> pipeGroups,
                                                    ArrayList<GroupSet> groupSets) {

        for (PipeGroup pipeGroup : pipeGroups) {
            GroupSet matchingGroupSet = getMatchingGroupSet(pipeGroup, groupSets);
            matchingGroupSet.addPipeGroup(pipeGroup);
        }
    }

    private static GroupSet getMatchingGroupSet(PipeGroup pipeGroup, ArrayList<GroupSet> groupSets) {
        GroupSet output = null;
        for (GroupSet groupSet: groupSets) {
            if (pipeGroup.isPulledTee() == groupSet.isPulledTee() &&
                    pipeGroup.getDiameter() == groupSet.getDiameter())
            {
                output = groupSet;
            }
        }
        return output;
    }

    private static void removeEmptyGroupSets(ArrayList<GroupSet> groupSets) {
        ArrayList<GroupSet> setsToRemove = new ArrayList<>();

        for (GroupSet set: groupSets) {
            if (set.size() == 0) setsToRemove.add(set);
        }

        groupSets.removeAll(setsToRemove);
    }
}
