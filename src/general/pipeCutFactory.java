package general;

import java.util.ArrayList;

public class pipeCutFactory {

    public static ArrayList<PipeCut> getPipeCutsFrom(ArrayList<String> rawCSVRows) {
        final int FIRST_ROW = 1;

        ArrayList<PipeCut> pipeCuts = new ArrayList<>(rawCSVRows.size());

        for (int arrayIndex = FIRST_ROW; arrayIndex < rawCSVRows.size(); arrayIndex++) {
            String rowString = rawCSVRows.get(arrayIndex);

            String[] pipeCutData = rowString.split(",");

            PipeCut pipeCut = new PipeCut();

            pipeCut.setRowData(rowString.split(","));
            pipeCut.setSpool(pipeCutData[PipeCSV.SPOOL]);
            pipeCut.setService(pipeCutData[PipeCSV.SERVICE]);
            pipeCut.setDiameter(pipeCutData[PipeCSV.DIAMETER]);
            pipeCut.setLengthDecimal(Integer.valueOf(pipeCutData[PipeCSV.LENGTH_DECIMAL]));

            pipeCuts.add(pipeCut);
        }

        return pipeCuts;
    }


}
