package main;

import java.io.IOException;
import java.util.ArrayList;

public class Coordinator {

    static String jobNumber = "380200";
    static String folderPath = "C:\\Users\\Aaron\\IdeaProjects\\Pipe Cutter Algo\\csv\\output\\";
    static String[] csvHeaderRow;

    static void start() throws IOException {
        ArrayList<String[]> csvRows = CSVReader.getDataRows();
        csvHeaderRow = CSVReader.getHeaderRow();
        ArrayList<Pipe> pipes = PipeFactory.getPipesFrom(csvRows);
        ArrayList<PipeGroup> pipeGroups = PipeGroupFactory.createPipeGroups(pipes);
        ArrayList<GroupSet> groupSets = GroupSetFactory.createGroupSets(pipeGroups);

        for (GroupSet groupSet : groupSets) {
            processIntoCSV(groupSet);
        }
    }

    private static void processIntoCSV(GroupSet groupSet) throws IOException {
        ArrayList<Bundle> groupSetBundles = new ArrayList<>();

        // make bundles from each pipe group
        for (PipeGroup pipeGroup: groupSet.getPipeGroups()) {
            ArrayList<Bundle> bundles = BundleFactory.createBundlesFrom(pipeGroup);
            groupSetBundles.addAll(bundles);
        }
        // we now have a combined set of bundles for all pipes in the GroupSet

        String fileName = FileNameMaker.getFileName(jobNumber, groupSet.isPulledTee(), groupSet.getDiameter());
        String filePath = folderPath + fileName;

        CSVWriter csvWriter = new CSVWriter(filePath);

        csvWriter.initFileWriter();
        csvWriter.appendRow(csvHeaderRow);
        csvWriter.writeBundlesToFile(groupSetBundles);
        csvWriter.closeWriter();
    }
}
