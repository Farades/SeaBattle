package gui;

import logic.Cell;
import logic.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldGui extends JPanel {
    private Field field;
    private boolean enemyFlag;
    private FieldCellGui[][] cellsGui;
    private String[] letters = {"", "А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "К"};

    public FieldGui(Field _field, boolean _enemyFlag) {
        field = _field;
        cellsGui = new FieldCellGui[Field.ROW_COUNT][Field.COL_COUNT];
        enemyFlag = _enemyFlag;
        setLayout(new GridLayout(Field.ROW_COUNT + 1, Field.COL_COUNT + 1, 3, 3));
        setBackground(Color.white);
        if (isEnemyField()) {
            setBorder(BorderFactory.createLineBorder(new Color(255, 9, 36), 2));
        } else {
            setBorder(BorderFactory.createLineBorder(new Color(15, 204, 51), 2));
        }
        initField();
    }

    public boolean isEnemyField() {
        return enemyFlag;
    }

    public void invertEnemyFlag() {
        enemyFlag = !enemyFlag;
    }

    public void reDrawField() {
        for (int x = 0; x < Field.ROW_COUNT; x++) {
            for (int y = 0; y < Field.COL_COUNT; y++) {
                cellsGui[x][y].reDraw();
            }
        }
    }

    private void addLeters() {
        for (String letter : letters) {
            JLabel temp = new JLabel(letter);
            temp.setHorizontalAlignment(JLabel.CENTER);
            temp.setVerticalAlignment(JLabel.CENTER);
            add(temp);
        }
    }

    private JLabel labelNumber(int n) {
        JLabel res = new JLabel("" + n);
        res.setHorizontalAlignment(JLabel.CENTER);
        res.setVerticalAlignment(JLabel.CENTER);
        return res;
    }

    private void initField() {
        addLeters();

        for (int x = 0; x < Field.ROW_COUNT; x++) {
            for (int y = -1; y < Field.COL_COUNT; y++) {
                if ((y==-1)) {
                    add(labelNumber(x + 1));
                } else {
                    FieldCellGui temp = new FieldCellGui(field.getCells()[x][y]);
                    cellsGui[x][y] = temp;
                    temp.setBorder(BorderFactory.createLineBorder(Color.gray));
                    int state = temp.getCell().getState();
                    temp.reDraw();
                    add(temp);
                }
            }
        }
    }

    public class FieldCellGui extends JPanel implements MouseListener {
        private Cell cell;

        public FieldCellGui(Cell _cell) {
            cell = _cell;
            addMouseListener(this);
        }

        public Cell getCell() {
            return cell;
        }

        public void mouseClicked(MouseEvent e) {
            if (isEnemyField()) {
                cell.fire();
                reDraw();
            }
        }

        public void mouseEntered(MouseEvent e) {
            if (isEnemyField()) {
                setBackground(new Color(5, 232, 89));
            }
        }

        public void mouseExited(MouseEvent e) {
            if (isEnemyField()) {
                reDraw();
            }
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void reDraw() {
            int state = cell.getState();
            switch (state) {
                case -1:
                    setBackground(new Color(235, 235, 235));
                    break;
                case 0:
                    if (isEnemyField()) {
                        setBackground(new Color(235, 235, 235));
                    } else {
                        setBackground(new Color(0, 162, 255));
                    }
                    break;
                case 1:
                    setBackground(Color.yellow);
                    break;
                case 2:
                    setBackground(new Color(255, 60, 60));
                    break;
                default:
                    ;
                    break;
            }
        }
    }
}
