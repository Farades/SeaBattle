package logic;

public class Cell {
    private int x, y;
    private int state;

    public Cell(int _state, int _x, int _y) {
        x = _x;
        y = _y;
        state = _state;
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
