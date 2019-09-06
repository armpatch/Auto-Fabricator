package gui;

import io.FilepathChecker;
import util.Coordinator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StartWindow {

    private JFrame frame;
    private JTextField sourceTextField = new JTextField();
    private JTextField outputTextField = new JTextField();

    private String sourcePath = "";
    private String outputPath = "";

    private final boolean TESTING_ENABLED = true;

    StartWindow() {
        setupJFrame();

        if (TESTING_ENABLED) {
            setSourcePath("C:\\Users\\Aaron\\IdeaProjects\\Pipe Cutter Algo\\csv\\input\\pipes.csv");
            sourceTextField.setText(sourcePath);
            setOutputPath("C:\\Users\\Aaron\\IdeaProjects\\Pipe Cutter Algo\\csv\\output");
            outputTextField.setText(outputPath);
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
        sourceTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent event) {textChanged(event);}

            @Override
            public void removeUpdate(DocumentEvent event) {textChanged(event);}

            @Override
            public void changedUpdate(DocumentEvent event) {textChanged(event);}

            private void textChanged(DocumentEvent event) {
                Document doc = event.getDocument();

                try {
                    String text = doc.getText(0, doc.getLength());
                    setSourcePath(text);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        });

        JButton browserButton1 = new JButton("Browse");
        browserButton1.setBounds(340,y2,100,30);
        frame.add(browserButton1);

        browserButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSourceChooserWindow();
            }
        });
    }

    private void addOutputFieldAndButton() {
        int y1 = 110;

        JLabel header = new JLabel("Output Folder Location");
        header.setBounds(20,y1, 300, 30);
        frame.add(header);

        int y2 = 140;
        frame.add(outputTextField);
        outputTextField.setBounds(20,y2,300,30);
        outputTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent event) {
                textChanged(event);
            }

            @Override
            public void removeUpdate(DocumentEvent event) {
                textChanged(event);
            }

            @Override
            public void changedUpdate(DocumentEvent event) {
                textChanged(event);
            }

            private void textChanged(DocumentEvent event) {
                Document doc = event.getDocument();

                try {
                    String text = doc.getText(0, doc.getLength());
                    setOutputPath(text);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        });

        JButton browserButton2 = new JButton("Browse");
        browserButton2.setBounds(340,y2,100,30);
        frame.add(browserButton2);

        browserButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOutputChooserWindow();
            }
        });
    }

    private void addConvertButton() {
        String title = "Convert";
        JButton button = new JButton(title);
        button.setBounds(20, 200, 150, 50);
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beginConversion();
            }
        });
    }

    private void showSourceChooserWindow() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setDialogTitle("Select Source File");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            setSourcePath(filePath);
            sourceTextField.setText(filePath);
        }
    }

    private void showOutputChooserWindow() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setDialogTitle("Select Output Folder");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            String folderPath = fileChooser.getSelectedFile().getAbsolutePath();
            setOutputPath(folderPath);
            outputTextField.setText(folderPath);
            System.out.println("Selected file: " + outputPath);
        }
    }

    private void setOutputPath(String path) {
        outputPath = path;
    }

    private void setSourcePath(String path) {
        this.sourcePath = path;
    }

    private void beginConversion () {
        if (!pathsAreValid()) {
            return;
        }

        try {
            Coordinator.startConversion(sourcePath, outputPath);
            JOptionPane.showMessageDialog(frame,
                    "Conversion Complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean pathsAreValid() {
        return FilepathChecker.isFile(sourcePath) &&
                FilepathChecker.isDirectory(outputPath);
    }
}