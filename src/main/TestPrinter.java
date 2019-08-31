package main;

import java.util.ArrayList;

public class TestPrinter {

    private static void printRaw(Pipe pipe) {
        String[] rowData = pipe.getRowData();
        String message = "    ";

        for (String data : rowData) {
            message = message.concat(data + " ");
        }

        System.out.println(message);
    }


    private static void printBrief(Pipe pipe) {
        String messageDiameter = pipe.getDiameter() + "\" ";
        String messageService = pipe.getService() + " ";
        String messageIsPulledTee = (pipe.isPulledTee())? "PT " : "";
        String messagePipeLength = (pipe.getLength()) + "\"";

        String messageCombined = messageDiameter + messageService + messageIsPulledTee +
                "\t\t\t" + messagePipeLength;

        System.out.println(messageCombined);
    }

    public static void print(Batch batch) {
        String pipeCount = "Batch has " + batch.getCount() + " pipe(s))";
        String totalLength = "Total = " + batch.getTotalLength() + "\"";
        String diameter = batch.getDiameter() + "\" ";
        String service = batch.getService() + " ";
        String isPulledTee = (batch.isPulledTee())? "PT" : "";
        String lineBreak = "\n----------------------------------";

        String messageCombined = "\n\n" + diameter + service + isPulledTee + "\t\t" + totalLength + lineBreak;

        System.out.println(messageCombined);

        ArrayList<Pipe> pipes = batch.getPipes();

        for (Pipe pipe : pipes) {
            printBrief(pipe);
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
            printRaw(pipe);
        }
    }
}
