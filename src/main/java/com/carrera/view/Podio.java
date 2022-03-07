package com.carrera.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Podio extends JFrame {
    public Podio(String result) {
        init(result);
    }

    public void init(String result) {
        JPanel panel = new JPanel();
        JScrollPane scrollBar = new JScrollPane(panel,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JTextArea txt = new JTextArea(result);
        panel.add(txt);
        this.add(scrollBar);
        this.setSize(500,700);
        this.setVisible(true);

    }
}
