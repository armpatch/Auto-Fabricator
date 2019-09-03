package util;

import io.CSVReader;
import io.CSVWriter;
import io.FileNameMaker;

import java.io.IOException;
import java.util.ArrayList;

public class Coordinator {

    private static String jobNumber = "380200"; // TODO fix this placeholder
    private static String outputFolderPath;
    private static String sourceFilePath;

    private static String[] csvHeaderRow;

    public static void startConversion() throws IOException {
        CSVReader.setFilePath(sourceFilePath);
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

        String fileName = FileNameMaker.getFileName(jobNumber, groupSet.isPulledTee(), groupSet.getDiameter());
        String filePath = outputFolderPath + "\\" + fileName;

        CSVWriter csvWriter = new CSVWriter(filePath);
        csvWriter.initFileWriter();
        csvWriter.appendRow(csvHeaderRow);
        csvWriter.writeBundlesToFile(groupSetBundles);
        csvWriter.closeWriter();
    }

    public static void setOutputFolderPath(String outputFolderPath) {
        Coordinator.outputFolderPath = outputFolderPath;
    }

    public static void setSourceFilePath(String sourceFilePath) {
        Coordinator.sourceFilePath = sourceFilePath;
    }
}
