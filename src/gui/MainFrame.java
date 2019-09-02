package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame {

    private JFrame frame;
    private JFileChooser fileChooser;

    private String outputFolderPath;
    private String sourceFilePath;

    public MainFrame() {
        setupFrame();
        showFrame();
    }

    private void setupFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // setup frame size
        frame = new JFrame("TC-50 Pipe Sorter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(460, 200);
        frame.setLocationByPlatform(true);
        frame.setLayout(null);
        frame.setResizable(false);

        setupSourceChooser();
        setupOutputChooser();
        setupConvertButton();
    }

    private void setupSourceChooser() {
        int y = 20;

        // first text field
        JTextField textField1 = new JTextField();
        textField1.setBounds(20, y,300,30);
        frame.add(textField1);

        JButton browserButton1 = new JButton("Browse");
        browserButton1.setBounds(340,y,100,30);
        frame.add(browserButton1);

    }

    private void setupOutputChooser() {
        int y = 60;

        JTextField textField2 = new JTextField();
        textField2.setBounds(20,y,300,30);
        frame.add(textField2);

        JButton browserButton2 = new JButton("Browse");
        browserButton2.setBounds(340,60,100,30);
        frame.add(browserButton2);

        browserButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseOutputFolder();
            }
        });
    }

    private void setupConvertButton() {
        String title = "Convert";
        JButton button = new JButton(title);
        button.setBounds(20, 100, 150, 50);

        frame.add(button);
    }

    private void showFrame() {
        frame.setVisible(true);
    }

    private void chooseOutputFolder() {
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setDialogTitle("Title");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String outputFolderPath = selectedFile.getAbsolutePath();
            System.out.println("Selected file: " + outputFolderPath);
        }
    }

}