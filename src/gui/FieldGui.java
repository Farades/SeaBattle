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
                FieldCellGui temp = new FieldCellGui(field.getCells()[x][y]);
                temp.setBorder(BorderFactory.createLineBorder(Color.gray));
                int state = temp.getCell().getState();
                temp.reDraw();
                add(temp);
            }
        }
    }
}
