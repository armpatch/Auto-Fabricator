package main;

import java.io.IOException;
import java.util.ArrayList;

public class Coordinator {

    static void start() throws IOException {
        ArrayList<String[]> csvRows = CSVReader.getDataRows();
        ArrayList<Pipe> pipes = PipeFactory.getPipesFrom(csvRows);
        ArrayList<PipeGroup> pipeGroups = PipeGroupFactory.createPipeGroups(pipes);
        ArrayList<GroupSet> groupSets = GroupSetFactory.createGroupSets(pipeGroups);

        for (GroupSet groupSet : groupSets) {
            processIntoCSV(groupSet);
        }
    }

    private static void processIntoCSV(GroupSet groupSet) {
        ArrayList<Bundle> groupSetBundles = new ArrayList<>();

        // make bundles from each pipe group
        for (PipeGroup pipeGroup: groupSet.getPipeGroups()) {
            ArrayList<Bundle> bundles = BundleFactory.createBundlesFrom(pipeGroup);
            groupSetBundles.addAll(bundles);
        }
        // we now have a combined set of bundles for all pipes in the GroupSet

        // now send this list of bundles to its own csv;
        // we will need a file name and a path.


    }



}
