package gui;

import logic.Field;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeaBattleGui extends JFrame {
    private FieldGui userField;
    private FieldGui compField;

    public final static String TITLE = "JavaBase - SeaBattle";
    public final static int WIDTH = 950;
    public final static int HEIGHT = 550;

    public SeaBattleGui(Field _userField, Field _compField) {
        userField = new FieldGui(_userField, false);
        compField = new FieldGui(_compField, true);
        userField.setBounds(10, 10, 450, 450);
        compField.setBounds(480, 10, 450, 450);

        JLabel userLabel = new JLabel("Компьютер сделал ход:");
        userLabel.setBounds(140, 480, 180, 20);
        JLabel compLabel = new JLabel("Игрок сделал ход:");
        compLabel.setBounds(630, 480, 150, 20);

        JPanel background = new JPanel();
        background.setLayout(null);
        background.add(userField);
        background.add(compField);
        background.add(userLabel);
        background.add(compLabel);
        getContentPane().add(background);

        setTitle(TITLE);
        addMenu();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, WIDTH, HEIGHT);
        setVisible(true);
        setResizable(false);
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuDebug = new JMenu("Отладка");
        JMenuItem menuItemDebugShow = new JMenuItem("Показать скрытое)");
        menuItemDebugShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                compField.invertEnemyFlag();
                compField.reDrawField();
            }
        });

        menuDebug.add(menuItemDebugShow);

        menuBar.add(menuDebug);

        setJMenuBar(menuBar);
    }

}
