package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        // read csv row into an array of strings
        ArrayList<String> csvRows;
        csvRows = PipeCSVReader.getRowsFromCSV();

        // create pipes from the list of csv rows
        ArrayList<PipeCut> pipeCuts;
        pipeCuts = PipeCutFactory.getPipeCutList(csvRows);

        // create pipe groups separated by size and pulled tees
        ArrayList<CutGroup> cutGroups;
        cutGroups = CutGroupFactory.getCutGroups(pipeCuts);

    }
}
