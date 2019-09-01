package main;

import java.util.ArrayList;

class PipeFactory {

    static ArrayList<Pipe> createPipesFrom(ArrayList<String[]> rows) {

        ArrayList<Pipe> pipes = new ArrayList<>(rows.size());

        for (String[] row : rows) {
            Pipe pipe = getPipeFrom(row);
            pipes.add(pipe);
        }

        return pipes;
    }

    private static Pipe getPipeFrom(String[] row) {
        Pipe pipe = new Pipe();

        pipe.setRowData(row);
        pipe.setLength(Float.valueOf(row[PipeCSVReader.LENGTH_DECIMAL]));
        pipe.setService(row[PipeCSVReader.SERVICE]);

        pipe.setPulledTee(isPulledTee(row[PipeCSVReader.SPOOL]));
        pipe.setDiameter(getDiameter(row[PipeCSVReader.DIAMETER]));

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
