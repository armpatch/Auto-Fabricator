package main;

public class TestPrinter {

    public static void print(PipeCut pipeCut) {
        String[] rowData = pipeCut.getRowData();
        String message = "";

        for (String data : rowData) {
            message = message.concat(data + " ");
        }

        System.out.println(message);
    }

    public static void print(Batch batch) {
        String messageHeader1 = "Batch Print";
        String messageHeader2 = "Service = " + batch.getService();
        String messageHeader3 = "Diameter = " + batch.getDiameter();
        String messageHeader4 = "Pulled Tee? " + batch.isPulledTee();

        System.out.println(messageHeader1);
        System.out.println(messageHeader2);
        System.out.println(messageHeader3);
        System.out.println(messageHeader4);
    }
}
