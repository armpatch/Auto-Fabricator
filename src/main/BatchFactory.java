package main;

import java.util.ArrayList;

public class BatchFactory {
    private static int stockLength = 220; // inches

    public ArrayList<Batch> createBatchesFrom(CutGroup cutGroup) {
        cutGroup.sortByLength();
        ArrayList<Batch> batches = new ArrayList<>();

        while (cutGroup.size() > 0) {
            Batch currentBatch = new Batch(
                    cutGroup.getService(),
                    cutGroup.getDiameter(),
                    cutGroup.isPulledTee());

            while (cutGroup.size() > 0) {





            }


        }
        return batches;
    }

    private static PipeCut findLongestPipe(CutGroup cutGroup, float maxLength) {
        for (int index = 0; index < cutGroup.size(); index++ ) {
            PipeCut pipeCut = cutGroup.getPipeCut(index);
            if (pipeCut.getLength() <= maxLength)
                return pipeCut;
        }
        return null;
    }



}
