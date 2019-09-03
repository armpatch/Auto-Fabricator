package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    // csv column data
    public static int JOB = 0;
    public static int SPOOL = 1;
    public static int ITEM_NO = 2;
    public static int AREA = 3;
    public static int SERVICE = 4;
    public static int MATERIAL = 5;
    public static int DIAMETER = 6;
    public static int END1 = 7;
    public static int CONNECTOR1 = 8;
    public static int CONNECTOR2 = 9;
    public static int LENGTH_DECIMAL = 10;
    public static int PRINTER = 11;
    public static int BIN = 12;
    public static int LABEL = 13;

    private static String filePath;

    public static ArrayList<String[]> getDataRows() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(filePath));

        ArrayList<String[]> rows = new ArrayList<>();

        String row;

        while ((row = csvReader.readLine()) != null) {
            rows.add(splitAndFormat(row));
        }
        csvReader.close();

        rows.remove(0);
        return rows;
    }

    public static String[] getHeaderRow() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(filePath));

        String row = csvReader.readLine();

        csvReader.close();

        return splitAndFormat(row);
    }

    private static String[] splitAndFormat(String rowDataRaw) {
        String output = rowDataRaw.replace("\"", "");
        return output.split(",");
    }

    public static void setFilePath(String filePath) {
        CSVReader.filePath = filePath;
    }
}
