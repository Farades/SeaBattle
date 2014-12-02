package gui;

import logic.Field;

import javax.swing.*;
import java.awt.*;

public class FieldGui extends JPanel {
    private Field field;

    public FieldGui(Field _field) {
        field = _field;
        setLayout(new GridLayout(10, 10, 3, 3));
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(new Color(0, 162, 255), 2));
        reDraw();
    }

    private void reDraw() {
        for (int x = 0; x < Field.ROW_COUNT; x++) {
            for (int y = 0; y < Field.COL_COUNT; y++) {
                JPanel test = new JPanel();
                test.setBorder(BorderFactory.createLineBorder(Color.gray));
                int state = field.getCellList()[x][y].getState();
                switch (state) {
                    case -1:
                        test.setBackground(new Color(235, 235, 235));
                        break;
                    case 0:
                        test.setBackground(new Color(0, 162, 255));
                        break;
                    case 1:
                        test.setBackground(Color.yellow);
                        break;
                    case 2:
                        test.setBackground(new Color(255, 60, 60));
                        break;
                    default:
                        ;
                        break;
                }
                add(test);
            }
        }
    }
}
