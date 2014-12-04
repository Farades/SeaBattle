package gui;

import logic.Field;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO Доработать счетчик ходов и вывод последних ходов игрока и противника

public class SeaBattleGui extends JFrame {
    private FieldGui userFieldGui;
    private FieldGui compFieldGui;
    private JPanel background;

    private String userName = "";
    private int stepCount;

    public final static String TITLE = "JavaBase - SeaBattle";
    public final static int WIDTH = 950;
    public final static int HEIGHT = 550;

    public SeaBattleGui() {
        setWelcomeWindow();

        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, WIDTH, HEIGHT);
        setVisible(true);
        setResizable(false);
    }

    private void setupFieldsGui() {
        addMenu();
        userFieldGui = new FieldGui(new Field(), false);
        compFieldGui = new FieldGui(new Field(), true);
        userFieldGui.setBounds(10, 10, 450, 450);
        compFieldGui.setBounds(480, 10, 450, 450);

        JLabel userLabel = new JLabel("Компьютер сделал ход:");
        userLabel.setBounds(140, 470, 180, 20);
        JLabel compLabel = new JLabel("Игрок сделал ход:");
        compLabel.setBounds(630, 470, 150, 20);
        JLabel userNameLabel = new JLabel(userName + ", Вы сделали " + stepCount + " хода(-ов)");
        userNameLabel.setBounds(370, 470, 200, 20);

        background = new JPanel();
        background.setLayout(null);
        background.add(userFieldGui);
        background.add(compFieldGui);
        background.add(userLabel);
        background.add(compLabel);
        background.add(userNameLabel);
        getContentPane().add(background);
    }

    private void setWelcomeWindow() {
        background = new JPanel();
        background.setLayout(null);
        final JTextField userNameInput = new JTextField(20);
        userNameInput.setBounds(350, 200, 150, 30);
        JButton start = new JButton("Начать игру");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName = userNameInput.getText();
                background.removeAll();
                background.setVisible(false);
                setupFieldsGui();
            }
        });
        start.setBounds(530, 200, 130, 30);
        JLabel userNameLabel = new JLabel("Введите свое имя:");
        userNameLabel.setBounds(220, 200, 130, 30);

        background.add(userNameInput);
        background.add(start);
        background.add(userNameLabel);
        getContentPane().add(background);
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuDebug = new JMenu("Отладка");
        JMenu menuMenu = new JMenu("Меню");
        JMenuItem menuItemDebugShow = new JMenuItem("Показать/скрыть корабли");
        JMenuItem menuItemMenuRestart = new JMenuItem("Начать заново");
        menuItemDebugShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                compFieldGui.invertEnemyFlag();
                compFieldGui.reDrawField();
            }
        });
        menuItemMenuRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                background.setVisible(false);
                background.removeAll();
                setupFieldsGui();
            }
        });

        menuDebug.add(menuItemDebugShow);
        menuMenu.add(menuItemMenuRestart);

        menuBar.add(menuMenu);
        menuBar.add(menuDebug);

        setJMenuBar(menuBar);
    }

}
