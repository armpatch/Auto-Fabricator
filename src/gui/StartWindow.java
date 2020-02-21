package gui;

import io.FilepathChecker;
import util.Coordinator;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class StartWindow {

    private JFrame frame;
    private JTextField sourceTextField = new JTextField();
    private JTextField outputTextField = new JTextField();

    private final boolean TESTING_ENABLED = true;

    StartWindow() {
        setupJFrame();

        if (TESTING_ENABLED) {
            sourceTextField.setText("test\\csv\\input\\pipes.csv");
            outputTextField.setText("test\\csv\\output");
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    private void setupJFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException e) {
            e.printStackTrace();
        }

        // setup frame size
        frame = new JFrame("TC-50 Pipe Sorter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(460, 320);
        frame.setLocationByPlatform(true);
        frame.setLayout(null);
        frame.setResizable(false);

        addSourceFieldAndButton();
        addOutputFieldAndButton();
        addConvertButton();
    }

    private void addSourceFieldAndButton() {
        int y1 = 30;

        JLabel header = new JLabel("Source File Location");
        header.setBounds(20,y1, 300, 30);
        frame.add(header);

        int y2 = 60;

        frame.add(sourceTextField);
        sourceTextField.setBounds(20, y2,300,30);

        JButton browserButton1 = new JButton("Browse");
        browserButton1.setBounds(340,y2,100,30);
        frame.add(browserButton1);

        browserButton1.addActionListener(e -> showSourceChooserWindow());
    }

    private void addOutputFieldAndButton() {
        int y1 = 110;

        JLabel header = new JLabel("Output Folder Location");
        header.setBounds(20,y1, 300, 30);
        frame.add(header);

        int y2 = 140;
        frame.add(outputTextField);
        outputTextField.setBounds(20,y2,300,30);

        JButton browserButton2 = new JButton("Browse");
        browserButton2.setBounds(340,y2,100,30);
        frame.add(browserButton2);

        browserButton2.addActionListener(e -> showOutputChooserWindow());
    }

    private void addConvertButton() {
        String title = "Convert";
        JButton button = new JButton(title);
        button.setBounds(20, 200, 150, 50);
        frame.add(button);
        button.addActionListener(e -> beginConversion());
    }

    private void showSourceChooserWindow() {
        JFileChooser fileChooser = new JFileChooser();

        File textField = new File(sourceTextField.getText());

        fileChooser.setCurrentDirectory(textField.isFile()? textField : new File(System.getProperty("user.home")));
        fileChooser.setDialogTitle("Select Source File");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            sourceTextField.setText(filePath);
        }
    }

    private void showOutputChooserWindow() {
        JFileChooser fileChooser = new JFileChooser();
        File textField = new File(outputTextField.getText());

        fileChooser.setCurrentDirectory(textField.isDirectory()? textField : new File(System.getProperty("user.home")));
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setDialogTitle("Select Output Folder");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            String folderPath = fileChooser.getSelectedFile().getAbsolutePath();
            outputTextField.setText(folderPath);
            System.out.println("Selected file: " + folderPath);
        }
    }

    private void beginConversion () {
        if (!pathsAreValid()) {
            return;
        }

        try {
            Coordinator.startConversion(sourceTextField.getText(), outputTextField.getText());
            JOptionPane.showMessageDialog(frame,
                    "Conversion Complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean pathsAreValid() {
        return FilepathChecker.isFile(sourceTextField.getText()) &&
                FilepathChecker.isDirectory(outputTextField.getText());
    }
}