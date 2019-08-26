package general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class pipeCutFactory {

    private static final String pathToCsv = "C:\\Users\\Aaron\\IdeaProjects\\Pipe Cutter Algo\\" +
                    "research\\pipe csvs\\Original\\pipes.csv";

    public static ArrayList<PipeCut> getPipeCuts(ArrayList<String> rows) {
        final int FIRST_ROW = 1;

        ArrayList<PipeCut> pipeCuts = new ArrayList<>(rows.size());

        for (int arrayIndex = FIRST_ROW; arrayIndex < rows.size(); arrayIndex++) {
            String rowString = rows.get(arrayIndex);

            String[] pipeCutData = rowString.split(",");

            PipeCut pipeCut = new PipeCut();

            pipeCut.setJobNumber(Integer.valueOf(pipeCutData[0]));
            pipeCut.setSpool(pipeCutData[1]);
            pipeCut.setItemNumber(pipeCutData[2]);
            pipeCut.setArea(pipeCutData[3]);
            pipeCut.setService(pipeCutData[4]);
            pipeCut.setMaterial(pipeCutData[5]);
            pipeCut.setEnd1(pipeCutData[6]);
            pipeCut.setLengthFractional(pipeCutData[7]);
            pipeCut.setConnector1(pipeCutData[8]);
            pipeCut.setConnector2(pipeCutData[9]);
            pipeCut.setRawLength(Integer.valueOf(pipeCutData[10]));
            pipeCut.setPrinter(pipeCutData[11]);
            pipeCut.setBin(pipeCutData[12]);

            pipeCuts.add(pipeCut);
        }

        return pipeCuts;
    }

    static ArrayList<String> getRowsFromCSV() throws IOException {
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
