package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        // read csv row into an array of strings
        ArrayList<String> csvRows;
        csvRows = PipeCSVReader.getRowsFromCSV();

        // create pipes from the list of csv rows
        ArrayList<Pipe> pipes;
        pipes = PipeFactory.getPipeList(csvRows);

        // create pipe groups separated by size and pulled tees
        ArrayList<PipeGroup> pipeGroups;
        pipeGroups = PipeGroupFactory.createPipeGroups(pipes);

        for (PipeGroup pipeGroup : pipeGroups) {
            ArrayList<Batch> batches = BatchFactory.createBatchesFrom(pipeGroup);
            for (Batch batch : batches) {
                TestPrinter.print(batch);
            }
        }

        // create batches from group

    }
}
