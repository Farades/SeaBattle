package logic;

import java.util.ArrayList;

public class Field {
    public static final int ROW_COUNT = 10;
    public static final int COL_COUNT = 10;
    public static final int COUNT = ROW_COUNT * COL_COUNT;
    private ArrayList<Cell> cellList;

    public Field() {
        cellList = new ArrayList<Cell>();
        for (int x = 0; x < ROW_COUNT; x++) {
            for (int y = 0; y < COL_COUNT; y++) {
                cellList.add(new Cell(-1, x, y));
            }
        }
        addShips();
    }

    public ArrayList<Cell> getCellList() {
        return cellList;
    }

    private void addShips() {
//        for (int x = 0; x < ROW_COUNT; x++) {
//            for (int y = 0; y < COL_COUNT; y++) {
//                Random rand = new Random();
//                int state = rand.nextInt(4) - 1;
//                cellList.add(new Cell(state, x, y));
//            }
//        }
    }
}
