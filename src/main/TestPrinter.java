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



}
