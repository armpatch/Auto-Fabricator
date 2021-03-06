package util;

import io.CSVReader;
import io.CSVWriter;
import io.FileNameFactory;
import io.JobInfo;

import java.io.IOException;
import java.util.ArrayList;

public class Coordinator {

    public static void startConversion(String sourceFilepath, String outputFolderPath) throws IOException {
        ArrayList<String[]> csvRows = CSVReader.getPipeDataRows(sourceFilepath);
        JobInfo.jobNumber = (csvRows.get(0)[0]);
        JobInfo.headerRow = CSVReader.getHeaderRow(sourceFilepath);

        for (GroupSet groupSet : createGroupSets(csvRows)) {
            outputToCSV(groupSet, outputFolderPath);
        }
    }

    private static ArrayList<GroupSet> createGroupSets(ArrayList<String[]> csvRows) {
        ArrayList<Pipe> pipes = PipeFactory.createPipesFrom(csvRows);
        ArrayList<PipeGroup> pipeGroups = PipeGroupFactory.createPipeGroups(pipes);
        return GroupSetFactory.createGroupSets(pipeGroups);
    }

    private static void outputToCSV(GroupSet groupSet, String outputFolderPath) throws IOException {
        ArrayList<Bundle> allBundles = new ArrayList<>();

        // make bundles from each pipe group
        for (PipeGroup pipeGroup: groupSet.getPipeGroups()) {
            ArrayList<Bundle> bundles = BundleFactory.createBundlesFrom(pipeGroup);
            allBundles.addAll(bundles);
        }

        String fileName = FileNameFactory.createFileNameWith(JobInfo.jobNumber, groupSet.isPulledTee(), groupSet.getDiameter());
        String filePath = outputFolderPath + "\\" + fileName;

        CSVWriter csvWriter = new CSVWriter(filePath);
        csvWriter.appendRow(JobInfo.headerRow);
        csvWriter.appendBundleRows(allBundles);
        csvWriter.appendTerminatingRow();
        csvWriter.close();
    }

}
