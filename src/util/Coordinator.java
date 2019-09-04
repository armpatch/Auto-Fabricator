package util;

import io.CSVReader;
import io.CSVWriter;
import io.FilenameFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Coordinator {

    private static String jobNumber = "";

    private static String[] csvHeaderRow;

    public static void startConversion(String sourceFilePath, String outputFolderPath) throws IOException {
        CSVReader.setFilePath(sourceFilePath);
        ArrayList<String[]> csvRows = CSVReader.getDataRows();
        jobNumber = csvRows.get(0)[0];
        csvHeaderRow = CSVReader.getHeaderRow();
        ArrayList<Pipe> pipes = PipeFactory.getPipesFrom(csvRows);
        ArrayList<PipeGroup> pipeGroups = PipeGroupFactory.createPipeGroups(pipes);
        ArrayList<GroupSet> groupSets = GroupSetFactory.createGroupSets(pipeGroups);

        for (GroupSet groupSet : groupSets) {
            outputToCSV(groupSet, outputFolderPath);
        }
    }

    private static void outputToCSV(GroupSet groupSet, String outputFolderPath) throws IOException {
        ArrayList<Bundle> groupSetBundles = new ArrayList<>();

        // make bundles from each pipe group
        for (PipeGroup pipeGroup: groupSet.getPipeGroups()) {
            ArrayList<Bundle> bundles = BundleFactory.createBundlesFrom(pipeGroup);
            groupSetBundles.addAll(bundles);
        }

        String fileName = FilenameFactory.getFileName(jobNumber, groupSet.isPulledTee(), groupSet.getDiameter());
        String filePath = outputFolderPath + "\\" + fileName;

        CSVWriter csvWriter = new CSVWriter(filePath);
        csvWriter.initFileWriter();
        csvWriter.appendRow(csvHeaderRow);
        csvWriter.writeBundlesToFile(groupSetBundles);
        csvWriter.closeWriter();
    }

}
