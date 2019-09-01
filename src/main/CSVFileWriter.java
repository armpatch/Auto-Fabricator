package main;

import java.io.FileWriter;
import java.io.IOException;

public class CSVFileWriter {

    private static String TEST_FILE_PATH =
            "C:\\Users\\Aaron\\IdeaProjects\\Pipe Cutter Algo\\csv\\output\\" +
                    "pipeOutput.csv";

    private String filePath;

    private FileWriter fileWriter;

    private CSVFileWriter(String filePath) {
        setFilePath(filePath);
    }

    void initFileWriter() throws IOException {
        fileWriter = new FileWriter(getFilePath());
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

    private void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private String getFilePath() {
        return filePath;
    }

}
