package UI;

import javax.swing.*;

public class MainFrame {

    private JFrame frame;

    public MainFrame() {
        setupWindow();
        setupButtonsAndFields();
        showWindow();
    }

    private void setupWindow() {
        frame = new JFrame("Cut Pipe Sorter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);
    }

    private void setupButtonsAndFields() {





        JButton button = new JButton("Create Files");
        button.setBounds(200, 150, 90, 50);
        frame.add(button);
    }

    private void showWindow() {
        frame.setVisible(true);
    }


}
