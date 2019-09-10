package io;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNameFactory {
    private static final String TRADE = "PL";
    private static final String AREA = "AREA";
    private static final String MACHINE_NAME = "TCC-50";

    // EX:
    // 380200_PL-Lev04-T2-TCC-50-(PT)-1.5
    // 380200_PL-Lev04T2-TCC-50-1.25

    public static String createFileNameWith(String jobNumber, boolean isPulledTee, float pipeDiameter) {
        String pulledTee = isPulledTee? "(PT)-" : "";
        String size = String.valueOf(pipeDiameter);
        String timeStamp = getTimeStamp();

        String fileName = jobNumber + "_" + TRADE + "-" + AREA + "-" +
                MACHINE_NAME + "-" + pulledTee + size + "_" + timeStamp + ".csv";

        return removeReservedCharacters(fileName);
    }

    private static String removeReservedCharacters(String fileName) {
        String[] reservedCharacters = {"<", ">", "\"", "/", "\\", "|", "?", "*"};

        for (String character : reservedCharacters) {
            fileName = fileName.replace(character, "");
        }

        return fileName;
    }

    private static String getTimeStamp() {
        String pattern = "dd.MM.YY_hh.mm";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        return dateFormat.format(new Date());
    }
}