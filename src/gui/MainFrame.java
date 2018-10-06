package gui;

import logic.Logic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    public List<JComponent> componentList = new ArrayList<>();

    public JTextPane listPane = new JTextPane();
    public JButton powerButton = new JButton();

    public MainFrame() {
        super();
        setMainFrameProperties();

        createComponents();
        addComponents();
    }

    private void createComponents() {
        createPowerButton();
        createListPane();
    }

    private void addComponents() {
        for (JComponent jComponent : componentList) {
            this.add(jComponent);
        }
    }

    public void createPowerButton() {
        setPowerButtonProperties();
    }

    public void createListPane() {

    }

    private void setListPaneProperties() {
        listPane.setContentType("text/html");
        listPane.setText("<html>" + Logic.getClipboardContent() + "</html>");
        listPane.setEditable(false);
    }

    private void setPowerButtonProperties() {
        if (!Logic.startedRecording) {
            powerButton.setText("Click to start recording");
        } else {
            powerButton.setText("Click to stop recording");
        }
        powerButton.addActionListener(e -> Logic.powerButtonPushed());
        powerButton.setSize(this.getWidth(), this.getHeight() / 2);
    }

    private void setMainFrameProperties() {
        setAlwaysOnTop(true);
        setLayout(new GridLayout());
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
