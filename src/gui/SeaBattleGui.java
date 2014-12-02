package gui;

import logic.Field;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SeaBattleGui extends JFrame {
    private FieldGui userField;
    private FieldGui compField;

    public final static String TITLE = "JavaBase - SeaBattle";
    public final static int WIDTH = 950;
    public final static int HEIGHT = 500;

    public SeaBattleGui(Field _userField, Field _compField) {
        userField = new FieldGui(_userField);
        compField = new FieldGui(_compField);
        userField.setBounds(10, 10, 450, 450);
        compField.setBounds(480, 10, 450, 450);

        JPanel background = new JPanel();
        background.setLayout(null);
        background.add(userField);
        background.add(compField);
        getContentPane().add(background);

        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, WIDTH, HEIGHT);
        setVisible(true);
        setResizable(false);
    }

}
