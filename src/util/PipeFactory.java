package util;

import io.CSVReader;

import java.util.ArrayList;

class PipeFactory {

    static ArrayList<Pipe> createPipesFrom(ArrayList<String[]> rows) {

        ArrayList<Pipe> pipes = new ArrayList<>(rows.size());

        for (String[] row : rows) {
            Pipe pipe = createPipeFrom(row);
            pipes.add(pipe);
        }

        return pipes;
    }

    private static Pipe createPipeFrom(String[] row) {
        Pipe pipe = new Pipe();

        pipe.setRowData(row);
        pipe.setLength(Float.parseFloat(row[CSVReader.LENGTH_COLUMN]));
        pipe.setService(row[CSVReader.SERVICE_COLUMN]);

        pipe.setPulledTee(isPulledTee(row[CSVReader.SPOOL_COLUMN]));
        pipe.setDiameter(getDiameter(row[CSVReader.DIAMETER_COLUMN]));

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
