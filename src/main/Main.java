package main;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        // read csv row into an array of strings
        ArrayList<String> csvRows;
        csvRows = PipeCSVReader.getRowsFromCSV();

        // create pipes from the list of csv rows
        ArrayList<PipeCut> pipeCutList;
        pipeCutList = PipeCutFactory.getPipeCutList(csvRows);

        // create pipe groups separated by size and pulled tees


    }
}
