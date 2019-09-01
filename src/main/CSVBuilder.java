package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class CSVBuilder {

    private static final String pathToCsv = "C:\\Users\\Aaron\\IdeaProjects\\Pipe Cutter Algo\\" +
            "research\\pipe csvs\\Original\\pipes.csv"; // TODO refactor duplicate code

    private FileWriter fileWriter;

    private void createCSVFrom(PipeGroup[] pipeGroups) throws IOException {
        fileWriter = new FileWriter(getFilePath());


    }

    void writeRow(String[] data) throws IOException {
        for (String field : data) {
            fileWriter.append(field);
            fileWriter.append(",");
        }
        fileWriter.append("\n");
    }

    private void finishCSV() throws IOException {
        fileWriter.flush();
        fileWriter.close();
    }

    private static String getFilePath() {
        String pathToFolder = "C:\\Users\\Aaron\\IdeaProjects\\Pipe Cutter Algo\\csv\\output\\";
        String fileName = "pipeOutput.csv";

        return pathToFolder + fileName;
    }

}
