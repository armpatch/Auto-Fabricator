package UI;

import javax.swing.*;

public class MainFrame {

    JFrame frame;

    public MainFrame() {
        setupWindow();
        setupButtons();
        showWindow();
    }

    private void setupWindow() {
        frame = new JFrame("Cut Pipe Sorter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);
    }

    private void setupButtons() {
        JButton button = new JButton("Create Files");
        button.setBounds(200, 150, 90, 50);
        frame.add(button);
    }

    private void showWindow() {
        frame.setVisible(true);
    }


}
