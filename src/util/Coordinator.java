package util;

import io.CSVReader;
import io.CSVWriter;
import io.FileNameFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Coordinator {

    private static String jobNumber = "";
    private static String folderPath;
    private static String sourceFilePath;

    private static String[] csvHeaderRow;

    public static void startConversion() throws IOException {
        CSVReader.setFilePath(sourceFilePath);
        ArrayList<String[]> csvRows = CSVReader.getDataRows();
        jobNumber = csvRows.get(0)[0];
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

        String fileName = FileNameFactory.getFileName(jobNumber, groupSet.isPulledTee(), groupSet.getDiameter());
        String filePath = folderPath + "\\" + fileName;

        CSVWriter csvWriter = new CSVWriter(filePath);
        csvWriter.initFileWriter();
        csvWriter.appendRow(csvHeaderRow);
        csvWriter.writeBundlesToFile(groupSetBundles);
        csvWriter.closeWriter();
    }

    public static void setOutputPath(String filePath) {
        Coordinator.folderPath = filePath;
    }

    public static void setSourcePath(String filePath) {
        Coordinator.sourceFilePath = filePath;
    }
}
