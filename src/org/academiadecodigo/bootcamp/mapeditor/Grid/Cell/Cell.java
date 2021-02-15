package org.academiadecodigo.bootcamp.mapeditor.Grid.Cell;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private Rectangle rect;
    private boolean filled;

    public Cell(int col, int row, int size, int size2) {

        rect = new Rectangle(col, row, size, size2);
    }

    public Rectangle getShape() {
        return rect;
    }

    public void paint(Color color) {

        rect.setColor(color);
        rect.fill();
    }

    public void fill(boolean filled) {

        this.filled = filled;
    }

    public boolean isFilled() {

        return filled;
    }
}
