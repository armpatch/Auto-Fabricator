package main;

import java.util.ArrayList;

public class pipeCutFactory {

    final int FIRST_ROW = 1;

    public ArrayList<PipeCut> getPipeCutList(ArrayList<String> rawCSVRows) {

        ArrayList<PipeCut> pipeCuts = new ArrayList<>(rawCSVRows.size());

        for (int arrayIndex = FIRST_ROW; arrayIndex < rawCSVRows.size(); arrayIndex++) {
            String rowString = rawCSVRows.get(arrayIndex);

            String[] pipeCutRowData = rowString.split(",");

            PipeCut pipeCut = getPipeCut(pipeCutRowData);

            pipeCuts.add(pipeCut);
        }

        return pipeCuts;
    }

    private PipeCut getPipeCut(String[] pipeCutRowData) {
        PipeCut pipeCut = new PipeCut();

        pipeCut.setRowData(pipeCutRowData);

        pipeCut.setLengthDecimal(Integer.valueOf(pipeCutRowData[PipeCSVReader.LENGTH_DECIMAL]));
        pipeCut.getService(pipeCutRowData[PipeCSVReader.SERVICE]);

        pipeCut.setPulledTee(isPulledTee(pipeCutRowData[PipeCSVReader.SPOOL]));
        pipeCut.setDiameter(getDiameter(pipeCutRowData[PipeCSVReader.DIAMETER]));

        return pipeCut;
    }

    private boolean isPulledTee(String spool) {
        return spool.contains("PT");
    }

    private float getDiameter(String diameterString) {
        return Float.valueOf(diameterString);
    }



}
