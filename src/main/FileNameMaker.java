package main;

public class FileNameMaker {
    static final String TRADE = "PL";
    static final String AREA = "AREA";
    static final String MACHINE_NAME = "TCC-50";
    static final String FILE_EXTENSION = ".csv";

    // EX:
    // 380200_PL-Lev04-T2-TCC-50-(PT)-1.5
    // 380200_PL-Lev04T2-TCC-50-1.25

    static String getFileName(String jobNumber, boolean isPulledTee, float pipeDiameter) {
        String pulledTee = isPulledTee? "(PT)-" : "";
        String size = String.valueOf(pipeDiameter);

        String fileName = jobNumber + "_" + TRADE + "-" + AREA + "-" + MACHINE_NAME + "-" + pulledTee + size + FILE_EXTENSION;

        return removeReservedCharacters(fileName);
    }

    private static String removeReservedCharacters(String fileName) {
        String cleanFileName = fileName;

        String[] reservedCharacters = {"<", ">", ":", "\"", "/", "\\", "|", "?", "*"};

        for (String reservedCharacter : reservedCharacters) {
            cleanFileName = cleanFileName.replace(reservedCharacter, "");
        }

        return cleanFileName;
    }
}
