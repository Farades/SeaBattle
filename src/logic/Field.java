package logic;

import java.util.ArrayList;

public class Field {
    public static final int ROW_COUNT = 10;
    public static final int COL_COUNT = 10;
    public static final int COUNT = ROW_COUNT * COL_COUNT;
    private Cell[][] cellList;

    public Field() {
        cellList = new Cell[ROW_COUNT][COL_COUNT];
        clearField();
        addShips();
    }

    public Cell[][] getCellList() {
        return cellList;
    }

    private boolean validateCoord(int x, int y) {
        boolean res = false;
        if ((x >= 0) && (x < ROW_COUNT) && (y >= 0) && (y < COL_COUNT)) {
            res = true;
        }
        return res;
    }

    private boolean freedom(int x, int y) {
        //Если точка внутри игрового поля и пустая, то проверяем свободны ли клетки вокруг нее
        //При этом есть "особые" точки. В углах и по краям игрового поля. Их обрабатываем по особому.
        if (validateCoord(x, y) && (cellList[x][y].getState() == -1)) {
            if ((x == 0) && (y == 0)) {//Нижний левый угол поля
                int[] displacementX = {0, 1, 1};
                int[] displacementY = {1, 1, 0};
                for (int i = 0; i < 3; i++) {
                    int dx = x + displacementX[i];
                    int dy = y + displacementY[i];
                    if (cellList[dx][dy].getState() != -1) {
                        return false;
                    }
                }
            } else if ((x == 0) && (y == COL_COUNT - 1)) {//Верхний левый угол поля
                int[] displacementX = {1, 1, 0};
                int[] displacementY = {0, -1, -1};
                for (int i = 0; i < 3; i++) {
                    int dx = x + displacementX[i];
                    int dy = y + displacementY[i];
                    if (cellList[dx][dy].getState() != -1) {
                        return false;
                    }
                }
            } else if ((x == ROW_COUNT - 1) && (y == COL_COUNT - 1)) {//Верхний правый угол поля
                int[] displacementX = {-1, -1, 0};
                int[] displacementY = {0, -1, -1};
                for (int i = 0; i < 3; i++) {
                    int dx = x + displacementX[i];
                    int dy = y + displacementY[i];
                    if (cellList[dx][dy].getState() != -1) {
                        return false;
                    }
                }
            } else if ((x == ROW_COUNT - 1) && (y == 0)) {//Нижний правый угол поля
                int[] displacementX = {-1, -1, 0};
                int[] displacementY = {0, 1, 1};
                for (int i = 0; i < 3; i++) {
                    int dx = x + displacementX[i];
                    int dy = y + displacementY[i];
                    if (cellList[dx][dy].getState() != -1) {
                        return false;
                    }
                }
            } else if (x == 0) { //Левый край поля
                int[] displacementX = {0, 1, 1, 1, 0};
                int[] displacementY = {1, 1, 0, -1, -1};
                for (int i = 0; i < 5; i++) {
                    int dx = x + displacementX[i];
                    int dy = y + displacementY[i];
                    if (cellList[dx][dy].getState() != -1) {
                        return false;
                    }
                }
            } else if (y == COL_COUNT - 1) {//Верхний край поля
                int[] displacementX = {-1, -1, 0, 1, 1};
                int[] displacementY = {0, -1, -1, -1, 0};
                for (int i = 0; i < 5; i++) {
                    int dx = x + displacementX[i];
                    int dy = y + displacementY[i];
                    if (cellList[dx][dy].getState() != -1) {
                        return false;
                    }
                }
            } else if (x == ROW_COUNT - 1) {//Правый край поля
                int[] displacementX = {0, -1, -1, -1, 0};
                int[] displacementY = {1, 1, 0, -1, -1};
                for (int i = 0; i < 5; i++) {
                    int dx = x + displacementX[i];
                    int dy = y + displacementY[i];
                    if (cellList[dx][dy].getState() != -1) {
                        return false;
                    }
                }
            } else if (y == 0) {//Нижний край поля
                int[] displacementX = {-1, -1, 0, 1, 1};
                int[] displacementY = {0, 1, 1, 1, 0};
                for (int i = 0; i < 5; i++) {
                    int dx = x + displacementX[i];
                    int dy = y + displacementY[i];
                    if (cellList[dx][dy].getState() != -1) {
                        return false;
                    }
                }
            } else {//"Не особые" клетки
                int[] displacementX = {-1, 0, 1, -1, 1, -1, 0, 1};
                int[] displacementY = {1, 1, 1, 0, 0, -1, -1, -1};
                for (int i = 0; i < 8; i++) {
                    int dx = x + displacementX[i];
                    int dy = y + displacementY[i];
                    if (cellList[dx][dy].getState() != -1) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private void clearField() {
        for (int x = 0; x < ROW_COUNT; x++) {
            for (int y = 0; y < COL_COUNT; y++) {
                cellList[x][y] = new Cell(-1, x, y);
            }
        }
    }

    private void addShips() {
        int iterCount = 0;
        for (int sizeShip = 4; sizeShip > 0; sizeShip--) {
            for (int countShip = 0; countShip < 5 - sizeShip; countShip++) {
                int x = 0;
                int y = 0;
                int orientationX = 0;
                int orientationY = 0;
                boolean condition = true;
                while (condition) {
                    x = Helper.randInt(0, ROW_COUNT - 1);
                    y = Helper.randInt(0, COL_COUNT - 1);
                    orientationX = Helper.randInt(0, 1);
                    orientationY = (orientationX != 0) ? 0 : 1;
                    condition = true;
                    for (int i = 0; i < sizeShip; i++) {
                        iterCount++;
                        int newX = x + orientationX * i;
                        int newY = y + orientationY * i;
                        if (!freedom(newX, newY)) {
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
                    cellList[newX][newY].setShip();
                }
            }
        }
        System.out.println("Count iteration for add ships: " + iterCount);
    }
}
