package battleship.view;

import java.awt.*;
import java.awt.event.*;
import java.util.function.*;

import javax.swing.*;

import battleship.model.*;

public class FieldDisplay extends JButton {

    private static final long serialVersionUID = 1L;
    
    private Coordinate coordinate;
    
    private Field field;
    
    private int size;

    public FieldDisplay(Coordinate pCoordinate, Field pField) {
        coordinate = pCoordinate;
        field = pField;
        size = 20;
    }

    public void setField(Field pField) {
        field = pField;
        repaint();
    }

    public void setSize(int pSize) {
        size = pSize;
        invalidate();
        repaint();
    }

    @Override
    public Dimension getSize() {
        return new Dimension(size,size);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size,size);
    }

    public void addListener(final Consumer<Coordinate> listener) {
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.accept(coordinate);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(100,100,200));
        g.fillRect(0,0,size,size);
        g.setColor(new Color(200,200,200));
        g.drawRect(0,0,size,size);
        switch (field) {
            case WATER_HIT:
                g.setColor(Color.WHITE);
                g.drawLine(0,0,size,size);
                g.drawLine(size,0,0,size);
                break;
            case SHIP:
                g.setColor(Color.BLACK);
                g.fillOval(0,0,size,size);
                break;
            case SHIP_HIT:
                g.setColor(Color.RED);
                g.fillOval(0,0,size,size);
                g.setColor(Color.BLACK);
                g.drawOval(0,0,size,size);
            case null, default:
                // Wenn dieser Fall erreicht wird, hast du dich zu g.fingern()
        }
    }
}
