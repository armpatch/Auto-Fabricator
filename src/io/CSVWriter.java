package io;

import util.Bundle;
import util.Pipe;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWriter {

    private String filePath;
    private FileWriter fileWriter;

    public CSVWriter(String filePath) {
        setFilePath(filePath);
    }

    public void open() throws IOException {
        fileWriter = new FileWriter(getFilePath());
    }

    public void appendBundleRows(ArrayList<Bundle> bundles) throws IOException {
        for (Bundle bundle : bundles) {
            ArrayList<Pipe> pipes = bundle.getPipes();
            for (Pipe pipe : pipes) {
                appendRow(pipe.getRowData());
            }
            appendRow(new String[] {});
        }
    }

    public void appendEndRow() throws IOException {
        String[] endRow = new String[] {JobInfo.getJobNumber(), "END", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
        appendRow(endRow);
    }

    public void appendRow(String[] data) throws IOException {
        if (data != null) {
            for (String field : data) {
                fileWriter.append(field);
                fileWriter.append(",");
            }
        }
        fileWriter.append("\n");
    }

    public void close() throws IOException {
        fileWriter.flush();
        fileWriter.close();
    }

    // getters and setters
    private String getFilePath() {
        return filePath;
    }

    private void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
