package general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class pipeCutFactory {

    private static final String pathToCsv = "C:\\Users\\Aaron\\IdeaProjects\\Pipe Cutter Algo\\" +
                    "research\\pipe csvs\\Original\\pipes.csv";

    public static ArrayList<PipeCut> getPipeCutsFrom(ArrayList<String> rawCSVRows) {
        final int FIRST_ROW = 1;

        ArrayList<PipeCut> pipeCuts = new ArrayList<>(rawCSVRows.size());

        for (int arrayIndex = FIRST_ROW; arrayIndex < rawCSVRows.size(); arrayIndex++) {
            String rowString = rawCSVRows.get(arrayIndex);

            String[] pipeCutData = rowString.split(",");

            PipeCut pipeCut = new PipeCut();

            pipeCut.setRowData(rowString.split(","));
            pipeCut.setService(pipeCutData[4]);
            pipeCut.setRawLength(Integer.valueOf(pipeCutData[10]));

            pipeCuts.add(pipeCut);
        }

        return pipeCuts;
    }

    static ArrayList<String> getRowsFromCSV(String path) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));

        String row;
        ArrayList<String> rows = new ArrayList<>();

        while ((row = csvReader.readLine()) != null) {
            rows.add(row);
        }
        csvReader.close();

        return rows;
    }
}
