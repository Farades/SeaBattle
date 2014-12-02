package logic;

//-1 - пустая ячейка
// 0 - размещен корабль
// 1 - был выстрел по пустой ячейке
// 2 - был выстрел по кораблю

public class Cell {
    private int x, y;
    private int state;

    public Cell(int _state, int _x, int _y) {
        x = _x;
        y = _y;
        state = _state;
    }

    public boolean fire() {
        if (state == -1) {
            state = 1;
        } else if (state == 0) {
            state = 2;
        } else {
            return false;
        }
        return true;
    }

    public int getState() {
        return state;
    }

    public void setShip() {
        state = 0;
    }

    public void setFired() {
        state = 2;
    }

    public void setEmpty() {
        state = -1;
    }

    public void setMiss() {
        state = 1;
    }
}
