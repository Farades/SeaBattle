package gui;

import javax.swing.*;
import java.awt.Color;

import logic.Cell;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        cell.fire();
        reDraw();
    }

    public void mouseEntered(MouseEvent e) {
        setBackground(new Color(5, 232, 89));
    }

    public void mouseExited(MouseEvent e) {
        reDraw();
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
                setBackground(new Color(0, 162, 255));
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
