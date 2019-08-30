package main;

import java.util.ArrayList;

public class TestPrinter {

    public static void print(PipeCut pipeCut) {
        String[] rowData = pipeCut.getRowData();
        String message = "    ";

        for (String data : rowData) {
            message = message.concat(data + " ");
        }

        System.out.println(message);
    }

    public static void print(Batch batch) {
        String messageHeader1 = "\n-----print(Batch)-----";
        String messageHeader2 = "Service = " + batch.getService();
        String messageHeader3 = "Diameter = " + batch.getDiameter();
        String messageHeader4 = "Pulled Tee? " + batch.isPulledTee();
        String messageHeader5 = "Total Length = " + batch.getTotalLength();
        String messageHeader6 = batch.size() + " PipeCuts:";

        System.out.println(messageHeader1);
        System.out.println(messageHeader2);
        System.out.println(messageHeader3);
        System.out.println(messageHeader4);
        System.out.println(messageHeader5);
        System.out.println(messageHeader6);

        ArrayList<PipeCut> pipeCuts = batch.getPipeCuts();

        for (PipeCut pipeCut : pipeCuts) {
            print(pipeCut);
        }
    }

    public static void print(CutGroup group) {
        String messageHeader1 = "\n-----print(CutGroup)-----";
        String messageHeader2 = "Service = " + group.getService();
        String messageHeader3 = "Diameter = " + group.getDiameter();
        String messageHeader4 = "Pulled Tee? " + group.isPulledTee();
        String messageHeader5 = group.size() + " PipeCuts:";

        System.out.println(messageHeader1);
        System.out.println(messageHeader2);
        System.out.println(messageHeader3);
        System.out.println(messageHeader4);
        System.out.println(messageHeader5);

        ArrayList<PipeCut> pipeCuts = group.getPipeCuts();

        for (PipeCut pipeCut : pipeCuts) {
            print(pipeCut);
        }
    }
}
