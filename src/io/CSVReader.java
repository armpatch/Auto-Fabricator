package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static int SPOOL_COLUMN = 1;
    public static int SERVICE_COLUMN = 4;
    public static int DIAMETER_COLUMN = 6;
    public static int LENGTH_COLUMN = 10;

    public static ArrayList<String[]> getPipeDataRows(String filepath) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(filepath));

        ArrayList<String[]> rows = new ArrayList<>();

        String row;

        while ((row = csvReader.readLine()) != null) {
            rows.add(splitAndFormat(row));
        }
        csvReader.close();

        rows.remove(0);
        return rows;
    }

    public static String[] getHeaderRow(String filepath) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(filepath));

        String row = csvReader.readLine();

        csvReader.close();

        return splitAndFormat(row);
    }

    private static String[] splitAndFormat(String rowDataRaw) {
        String output = rowDataRaw.replace("\"", "");
        return output.split(",");
    }
}
