package main;

import java.util.ArrayList;

class BatchFactory {

    static ArrayList<Batch> createBatchesFrom(PipeGroup pipeGroup) {
        ArrayList<Batch> batches = new ArrayList<>();

        while (pipeGroup.size() > 0) {
            Batch currentBatch = makeBatchFrom(pipeGroup);

            if (currentBatch.getCount() != 0) {
                batches.add(currentBatch);
            }
        }
        return batches;
    }

    private static Batch makeBatchFrom(PipeGroup pipeGroup) {
        Batch batch = new Batch(
                pipeGroup.getService(),
                pipeGroup.getDiameter(),
                pipeGroup.isPulledTee());

        while (pipeGroup.size() > 0) {
            Pipe pipe = getLongestPipe(pipeGroup, batch.getRemainingLength());

            if (pipe != null) {
                pipeGroup.removePipe(pipe);
                batch.addPipe(pipe);

            } else {
                break;
            }
        }
        return batch;
    }

    private static Pipe getLongestPipe(PipeGroup pipeGroup, float maxLength) {
        for (int index = 0; index < pipeGroup.size(); index++ ) {
            Pipe pipe = pipeGroup.getPipe(index);

            if (pipe.getLength() <= maxLength)
                return pipe;
        }
        return null;
    }
}
