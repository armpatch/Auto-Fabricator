package io;

public class JobInfo {

    private static String jobNumber;
    private static String[] headerRow;

    public static String getJobNumber() {
        return jobNumber;
    }

    public static void setJobNumber(String jobNumber) {
        JobInfo.jobNumber = jobNumber;
    }

    public static String[] getHeaderRow() {
        return headerRow;
    }

    public static void setHeaderRow(String[] headerRow) {
        JobInfo.headerRow = headerRow;
    }
}
