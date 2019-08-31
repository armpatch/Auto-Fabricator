package main;

import java.util.ArrayList;

public class TestPrinter {

    public static void print(Pipe pipe) {
        String[] rowData = pipe.getRowData();
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
        String messageHeader6 = batch.size() + " Pipes:";

        System.out.println(messageHeader1);
        System.out.println(messageHeader2);
        System.out.println(messageHeader3);
        System.out.println(messageHeader4);
        System.out.println(messageHeader5);
        System.out.println(messageHeader6);

        ArrayList<Pipe> pipes = batch.getPipes();

        for (Pipe pipe : pipes) {
            print(pipe);
        }
    }

    public static void print(PipeGroup group) {
        String messageHeader1 = "\n-----print(PipeGroup)-----";
        String messageHeader2 = "Service = " + group.getService();
        String messageHeader3 = "Diameter = " + group.getDiameter();
        String messageHeader4 = "Pulled Tee? " + group.isPulledTee();
        String messageHeader5 = group.size() + " Pipes:";

        System.out.println(messageHeader1);
        System.out.println(messageHeader2);
        System.out.println(messageHeader3);
        System.out.println(messageHeader4);
        System.out.println(messageHeader5);

        ArrayList<Pipe> pipes = group.getPipes();

        for (Pipe pipe : pipes) {
            print(pipe);
        }
    }
}
