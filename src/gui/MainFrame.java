package gui;

import logic.Logic;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public JTextPane pane = new JTextPane();
    public JButton btn = new JButton();

    public MainFrame() {
        super();
        setMainFrameProperties();

        add(btn);
        setButtonProperties();

        add(pane);
        setPaneProperties();
    }

    private void setPaneProperties() {
        pane.setContentType("text/html");
        pane.setText("<html>" + Logic.getClipboardContent() + "</html>");
        pane.setEditable(false);
    }

    private void setButtonProperties() {
        btn.setText("Print clipboard content");
        btn.addActionListener(e -> pane.setText(Logic.getClipboardContent()));
        btn.setSize(this.getWidth(), this.getHeight() / 2);
    }

    private void setMainFrameProperties() {
        setAlwaysOnTop(true);
        setLayout(new GridLayout());
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        this.add(pane);
        pane.getInputMap().put(KeyStroke.getKeyStroke("F2"), (Logic.getClipboardContent()));
        this.add(btn);
    }


}
