package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class CSVReader {

    static  int JOB = 0;
    static  int SPOOL = 1;
    static  int ITEM_NO = 2;
    static  int AREA = 3;
    static  int SERVICE = 4;
    static  int MATERIAL = 5;
    static  int DIAMETER = 6;
    static  int END1 = 7;
    static  int CONNECTOR1 = 8;
    static  int CONNECTOR2 = 9;
    static  int LENGTH_DECIMAL = 10;
    static  int PRINTER = 11;
    static  int BIN = 12;
    static  int LABEL = 13;

    private static final String pathToCsv = "C:\\Users\\Aaron\\IdeaProjects\\Pipe Cutter Algo\\" +
            "csv\\input\\pipes.csv";

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

    private static String[] splitAndFormat(String rowDataRaw) {
        String output = rowDataRaw.replace("\"", "");
        return output.split(",");
    }

}
