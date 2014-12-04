package logic;

import gui.SeaBattleGui;

//-1 - пустая ячейка
// 0 - размещен корабль
// 1 - был выстрел по пустой ячейке
// 2 - был выстрел по кораблю

public class SeaBattle {

    private SeaBattleGui gui;

    public SeaBattle() {

    }

    public void start() {
        gui = new SeaBattleGui();
    }
}
