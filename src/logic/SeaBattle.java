package logic;

import gui.SeaBattleGui;

//-1 - пустая ячейка
// 0 - размещен корабль
// 1 - был выстрел по пустой ячейке
// 2 - был выстрел по кораблю

public class SeaBattle {
    private Field userField;
    private Field compField;
    private SeaBattleGui gui;

    public SeaBattle() {
        userField = new Field();
        compField = new Field();
        gui = new SeaBattleGui(userField, compField);
    }

    public void start() {

    }
}
