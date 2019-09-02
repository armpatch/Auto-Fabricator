package util;

import java.util.ArrayList;

class BundleFactory {

    static ArrayList<Bundle> createBundlesFrom(PipeGroup pipeGroup) {
        ArrayList<Bundle> bundles = new ArrayList<>();

        while (pipeGroup.size() > 0) {
            Bundle currentBundle = makeBundleFrom(pipeGroup);

            if (currentBundle.getCount() != 0) {
                bundles.add(currentBundle);
            }
        }
        return bundles;
    }

    private static Bundle makeBundleFrom(PipeGroup pipeGroup) {
        Bundle bundle = new Bundle(
                pipeGroup.getService(),
                pipeGroup.getDiameter(),
                pipeGroup.isPulledTee());

        while (pipeGroup.size() > 0) {
            Pipe pipe = findLongestPipe(pipeGroup, bundle.getRemainingLength());

            if (pipe != null) {
                pipeGroup.removePipe(pipe);
                bundle.addPipe(pipe);
            } else {
                break;
            }
        }
        return bundle;
    }

    private static Pipe findLongestPipe(PipeGroup pipeGroup, float maxLength) {
        for (int index = 0; index < pipeGroup.size(); index++ ) {
            Pipe pipe = pipeGroup.getPipe(index);

            if (pipe.getLength() <= maxLength)
                return pipe;
        }
        return null;
    }
}
