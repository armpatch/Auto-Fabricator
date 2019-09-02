package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static final int JOB = 0;
    public static final int SPOOL = 1;
    public static final int ITEM_NO = 2;
    public static final int AREA = 3;
    public static final int SERVICE = 4;
    public static final int MATERIAL = 5;
    public static final int DIAMETER = 6;
    public static final int END1 = 7;
    public static final int CONNECTOR1 = 8;
    public static final int CONNECTOR2 = 9;
    public static final int LENGTH_DECIMAL = 10;
    public static final int PRINTER = 11;
    public static final int BIN = 12;
    public static final int LABEL = 13;

    private static final String pathToCsv = "C:\\Users\\Aaron\\IdeaProjects\\Pipe Cutter Algo\\" +
            "research\\pipe csvs\\Original\\pipes.csv";

    static ArrayList<String[]> getDataRows() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));

        ArrayList<String[]> rows = new ArrayList<>();

        String row;

        while ((row = csvReader.readLine()) != null) {
            rows.add(splitAndFormat(row));
        }
        csvReader.close();

        rows.remove(0);
        return rows;
    }

    static String[] getHeaderRow() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));

        String row = csvReader.readLine();

        csvReader.close();

        return splitAndFormat(row);
    }

    static String[] splitAndFormat(String rowDataRaw) {
        String output = rowDataRaw.replace("\"", "");
        return output.split(",");
    }

}
