package logic;

import java.util.ArrayList;

public class Field {
    public static final int ROW_COUNT = 10;
    public static final int COL_COUNT = 10;
    public static final int COUNT = ROW_COUNT * COL_COUNT;
    private Cell[][] cellList;

    public Field() {
        cellList = new Cell[ROW_COUNT][COL_COUNT];
        for (int x = 0; x < ROW_COUNT; x++) {
            for (int y = 0; y < COL_COUNT; y++) {
                cellList[x][y] = new Cell(-1, x, y);
            }
        }
        addShips();
    }

    public Cell[][] getCellList() {
        return cellList;
    }

    private boolean freedom(int x, int y) {
        int[] displacementX = { -1, 0, 1, -1, 1, -1,  0,  1 };
        int[] displacementY = {  1, 1, 1,  0, 0, -1, -1, -1 };
        if ( (x > 0) && (y > 0) && (y < 10) && (x < 10) ) {
            return true;
        } else {
            return false;
        }
    }

    private void addShips() {
        for (int sizeShip = 4; sizeShip > 3; sizeShip--) {
//            for (int countShip = 0; countShip < 5 - sizeShip; countShip++) {
                int x = 0;
                int y = 0;
                int orientationX = 0;
                int orientationY = 0;
                boolean condition = true;
                while(condition) {
                    x = Helper.randInt(0, ROW_COUNT - 1);
                    y = Helper.randInt(0, COL_COUNT - 1);
                    orientationX = Helper.randInt(0, 1);
                    orientationY = (orientationX != 0) ? 0 : 1;
                    condition = true;
                    for (int i = 0; i < sizeShip; i++) {
                        int newX = x + orientationX * i;
                        int newY = y + orientationY * i;
                        if ( freedom(newX, newY) == false ) {
                            condition = true;
                            break;
                        } else {
                            condition = false;
                        }
                    }
                }
                for (int i = 0; i < sizeShip; i++) {
                    int newX = x + orientationX * i;
                    int newY = y + orientationY * i;
                    cellList[x][y].setShip();
                    System.out.println("x - " + newX + " y - " + newY);
                }
//            }
        }
    }
}
