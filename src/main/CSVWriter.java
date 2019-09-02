package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWriter {

    private static String TEST_FILE_PATH =
            "C:\\Users\\Aaron\\IdeaProjects\\Pipe Cutter Algo\\csv\\output\\" +
                    "pipeOutput.csv";

    private String filePath;

    private FileWriter fileWriter;

    CSVWriter(String filePath) {
        setFilePath(filePath);
    }

    void initFileWriter() throws IOException {
        fileWriter = new FileWriter(getFilePath());
    }

    void writeBundlesToFile(ArrayList<Bundle> bundles) throws IOException {
        for (Bundle bundle : bundles) {
            ArrayList<Pipe> pipes = bundle.getPipes();
            for (Pipe pipe : pipes) {
                appendRow(pipe.getRowData());
            }
            appendRow(new String[] {});
        }

    }

    void appendRow(String[] data) throws IOException {
        if (data != null) {
            for (String field : data) {
                fileWriter.append(field);
                fileWriter.append(",");
            }
        }

        fileWriter.append("\n");
    }

    void closeWriter() throws IOException {
        fileWriter.flush();
        fileWriter.close();
    }

    // getters and setters
    private String getFilePath() {return filePath;}
    private void setFilePath(String filePath) {this.filePath = filePath;}
}
