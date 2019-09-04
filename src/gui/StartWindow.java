package gui;

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
    private JTextField textField1 = new JTextField();
    private JTextField textField2 = new JTextField();

    private String sourceFilePath = "";
    private String outputFolderPath = "";

    StartWindow() {
        setupJFrame();
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
        frame.setSize(460, 200);
        frame.setLocationByPlatform(true);
        frame.setLayout(null);
        frame.setResizable(false);

        addSourceFieldAndButton();
        addOutputFieldAndButton();
        addConvertButton();
    }

    private void addSourceFieldAndButton() {
        int y = 20;

        frame.add(textField1);
        textField1.setBounds(20, y,300,30);
        textField1.getDocument().addDocumentListener(new DocumentListener() {
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
                    setSourceFilePath(text);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        });

        JButton browserButton1 = new JButton("Browse");
        browserButton1.setBounds(340,y,100,30);
        frame.add(browserButton1);

        browserButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFileChooserWindow();
            }
        });
    }

    private void addOutputFieldAndButton() {
        int y = 60;

        frame.add(textField2);
        textField2.setBounds(20,y,300,30);
        textField2.getDocument().addDocumentListener(new DocumentListener() {
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
                    setOutputFolderPath(text);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        });

        JButton browserButton2 = new JButton("Browse");
        browserButton2.setBounds(340,60,100,30);
        frame.add(browserButton2);

        browserButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFolderChooserWindow();
            }
        });
    }

    private void addConvertButton() {
        String title = "Convert";
        JButton button = new JButton(title);
        button.setBounds(20, 100, 150, 50);
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beginConversion();
            }
        });
    }

    private void showFileChooserWindow() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setDialogTitle("Select Source File");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            setSourceFilePath(filePath); // TODO this field setter seems redundant
            textField1.setText(filePath);
        }
    }

    private void showFolderChooserWindow() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setDialogTitle("Select Output Folder");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            String folderPath = fileChooser.getSelectedFile().getAbsolutePath();
            setOutputFolderPath(folderPath);
            textField2.setText(folderPath);
            System.out.println("Selected file: " + outputFolderPath);
        }
    }

    private void setOutputFolderPath(String path) {outputFolderPath = path;}

    private void setSourceFilePath(String path) {this.sourceFilePath = path;}

    private void beginConversion () {
        if (pathsAreInvalid()) {
            return;
        }

        try {
            Coordinator.startConversion(sourceFilePath, outputFolderPath);
            JOptionPane.showMessageDialog(null,
                    "Conversion Complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean pathsAreInvalid() {
        boolean isSourcePathValid = false;
        boolean isOutputPathValid = false;
        File sourceFile = new File(sourceFilePath);
        File outputFile = new File(outputFolderPath);

        System.out.println(" ");
        System.out.println("MainFrame: source = " + sourceFilePath);
        System.out.println("MainFrame: output = " + outputFolderPath);

        if (sourceFile.isFile()) {
            isSourcePathValid = true;
        } else {
            System.out.println("MainFrame: source file path is not valid");
        }

        if (outputFile.isDirectory()) {
            isOutputPathValid = true;
        } else {
            System.out.println("MainFrame: output folder path is not valid");
        }

        return isSourcePathValid || isOutputPathValid;
    }
}