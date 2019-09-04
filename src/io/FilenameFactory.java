package io;

public class FilenameFactory {
    private static final String TRADE = "PL";
    private static final String AREA = "AREA";
    private static final String MACHINE_NAME = "TCC-50";
    private static final String FILE_EXTENSION = ".csv";

    // EX:
    // 380200_PL-Lev04-T2-TCC-50-(PT)-1.5
    // 380200_PL-Lev04T2-TCC-50-1.25

    public static String createFileNameWith(String jobNumber, boolean isPulledTee, float pipeDiameter) {
        String pulledTee = isPulledTee? "(PT)-" : "";
        String size = String.valueOf(pipeDiameter);

        String fileName = jobNumber + "_" + TRADE + "-" + AREA + "-" + MACHINE_NAME + "-" + pulledTee + size + FILE_EXTENSION;

        return removeReservedCharacters(fileName);
    }

    private static String removeReservedCharacters(String fileName) {
        String output = fileName;

        String[] reservedCharacters = {"<", ">", ":", "\"", "/", "\\", "|", "?", "*"};

        for (String reservedCharacter : reservedCharacters) {
            output = output.replace(reservedCharacter, "");
        }

        return output;
    }
}
