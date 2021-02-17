package org.academiadecodigo.bootcamp.mapeditor.Grid.Cell;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static org.academiadecodigo.bootcamp.mapeditor.Grid.MapEditorGrid.CELL_SIZE;
import static org.academiadecodigo.bootcamp.mapeditor.Grid.MapEditorGrid.PADDING;

public class Cell {

    private Rectangle rect;
    private boolean filled;
    private int col;
    private int row;

    public Cell(int col, int row) {
        this.col = col;
        this.row = row;

        rect = new Rectangle(col * CELL_SIZE + PADDING, row * CELL_SIZE + PADDING, CELL_SIZE, CELL_SIZE);
    }

    public Rectangle getShape() {
        return rect;
    }

    public void paint(Color color) {

        filled = true;
        rect.setColor(color);
        rect.fill();
    }

    public void erase() {
        filled = false;
        rect.draw();
    }


    public void fill(boolean filled) {

        this.filled = filled;
    }

    public boolean isFilled() {

        return filled;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return filled ? "1" : "0";
    }
}
