package logic;

import java.util.ArrayList;

public class Ship {
    int size;
    private ArrayList<Cell> cells;

    public Ship(final ArrayList<Cell> _cells) {
        cells = _cells;
        size = cells.size();
    }

    public boolean isDead() {
        for (Cell cell : cells) {
            if (cell.getState() == 0) {
                return false;
            }
        }
        return true;
    }
}
