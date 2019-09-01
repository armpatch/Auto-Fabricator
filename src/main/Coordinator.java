package main;

import java.io.IOException;
import java.util.ArrayList;

public class Coordinator {

    void start() throws IOException {
        ArrayList<String[]> csvRows = PipeCSVReader.getDataRows();
        ArrayList<Pipe> pipes = PipeFactory.createPipesFrom(csvRows);
        ArrayList<PipeGroup> pipeGroups = PipeGroupFactory.createPipeGroups(pipes);


    }
}
