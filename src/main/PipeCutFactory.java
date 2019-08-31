package main;

import java.util.ArrayList;

class PipeCutFactory {

    private final static int FIRST_ROW = 1;

    static ArrayList<PipeCut> getPipeCutList(ArrayList<String> rawCSVRows) {

        ArrayList<PipeCut> pipeCuts = new ArrayList<>(rawCSVRows.size());

        for (int arrayIndex = FIRST_ROW; arrayIndex < rawCSVRows.size(); arrayIndex++) {
            String rowString = rawCSVRows.get(arrayIndex);

            String[] pipeCutRowData = rowString.split(",");

            PipeCut pipeCut = getPipeCut(pipeCutRowData);

            pipeCuts.add(pipeCut);
        }

        return pipeCuts;
    }

    private static PipeCut getPipeCut(String[] pipeCutRowData) {
        PipeCut pipeCut = new PipeCut();

        pipeCut.setRowData(pipeCutRowData);

        pipeCut.setLength(Float.valueOf(pipeCutRowData[PipeCSVReader.LENGTH_DECIMAL]));
        pipeCut.setService(pipeCutRowData[PipeCSVReader.SERVICE]);

        pipeCut.setPulledTee(isPulledTee(pipeCutRowData[PipeCSVReader.SPOOL]));
        pipeCut.setDiameter(getDiameter(pipeCutRowData[PipeCSVReader.DIAMETER]));

        return pipeCut;
    }

    private static boolean isPulledTee(String spool) {
        return spool.contains("PT");
    }

    private static float getDiameter(String valueAsString) {
        float diameter = 0;

        switch (valueAsString) {
            case "0 1/2":
                diameter = 0.5f;
                break;
            case "0 3/4":
                diameter = 0.75f;
                break;
            case "1":
                diameter = 1f;
                break;
            case "1 1/4":
                diameter = 1.25f;
                break;
            case "1 1/2":
                diameter = 1.5f;
                break;
        }

        return diameter;
    }

}
