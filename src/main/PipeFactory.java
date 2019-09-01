package main;

import java.util.ArrayList;

class PipeFactory {

    private final static int FIRST_ROW = 1;

    static ArrayList<Pipe> createPipesFrom(ArrayList<String> rawCSVRows) {

        ArrayList<Pipe> pipes = new ArrayList<>(rawCSVRows.size());

        for (int arrayIndex = FIRST_ROW; arrayIndex < rawCSVRows.size(); arrayIndex++) {
            String rowString = rawCSVRows.get(arrayIndex);

            String[] pipeRowData = rowString.split(",");

            Pipe pipe = getPipe(pipeRowData);

            pipes.add(pipe);
        }

        return pipes;
    }

    private static Pipe getPipe(String[] pipeRowData) {
        Pipe pipe = new Pipe();

        pipe.setRowData(pipeRowData);

        pipe.setLength(Float.valueOf(pipeRowData[PipeCSVReader.LENGTH_DECIMAL]));
        pipe.setService(pipeRowData[PipeCSVReader.SERVICE]);

        pipe.setPulledTee(isPulledTee(pipeRowData[PipeCSVReader.SPOOL]));
        pipe.setDiameter(getDiameter(pipeRowData[PipeCSVReader.DIAMETER]));

        return pipe;
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
