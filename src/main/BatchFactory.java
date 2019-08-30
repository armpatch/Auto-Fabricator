package main;

import java.util.ArrayList;

class BatchFactory {

    static ArrayList<Batch> createBatchesFrom(CutGroup cutGroup) {
        cutGroup.sortByLength();
        ArrayList<Batch> batches = new ArrayList<>();

        while (cutGroup.size() > 0) {
            Batch currentBatch = makeBatchFrom(cutGroup);

            if (currentBatch.size() != 0) {
                batches.add(currentBatch);
            }
        }
        return batches;
    }

    private static Batch makeBatchFrom(CutGroup cutGroup) {
        Batch batch = new Batch(
                cutGroup.getService(),
                cutGroup.getDiameter(),
                cutGroup.isPulledTee());

        while (cutGroup.size() > 0) {
            PipeCut pipeCut = getLongestPipeCut(cutGroup, batch.remainingLength());

            if (pipeCut != null) {
                cutGroup.removePipeCut(pipeCut);
                batch.addPipeCut(pipeCut);

            } else {
                break;
            }
        }
        return batch;
    }

    private static PipeCut getLongestPipeCut(CutGroup cutGroup, float maxLength) {
        for (int index = 0; index < cutGroup.size(); index++ ) {
            PipeCut pipeCut = cutGroup.getPipeCut(index);

            if (pipeCut.getLength() <= maxLength)
                return pipeCut;
        }
        return null;
    }
}
