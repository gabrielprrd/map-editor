package org.academiadecodigo.bootcamp.mapeditor.Painter;

import org.academiadecodigo.bootcamp.mapeditor.Grid.Cell.Cell;
import org.academiadecodigo.bootcamp.mapeditor.Grid.MapEditorGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Painter {

    private Rectangle cursor;
    private MapEditorGrid grid;
    private Color color;
    private int col;
    private int row;
    private int cellSize;

    public Painter(MapEditorGrid grid, Color color, int col, int row, int size1, int size2) {
        this.grid = grid;
        this.color = color;
        this.cellSize = size1;

        cursor = new Rectangle(col, row, size1, size2);
    }

    public void init() {
        cursor.setColor(Color.BLACK);
        cursor.fill();
    }

    public Rectangle getCursor() {
        return cursor;
    }

    public MapEditorGrid getGrid() {
        return grid;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void updateRowToUp() {
        row -= cellSize;
    }

    public void updateRowToDown() {
        row += cellSize;
    }

    public void updateColToLeft() {
        col -= cellSize;
    }

    public void updateColToRight() {
        col += cellSize;
    }

    public void paint() {
        for (Cell cell : grid.getCells()) {

            if (cell.getCol() - grid.getPadding() == col &&
                    cell.getRow() - grid.getPadding() == row) {

                cell.paint(color);
                cell.fill(true);
            }
        }
    }

    public void eraseColor() {
        for (Cell cell : grid.getCells()) {

            if (cell.getCol() - grid.getPadding() == col &&
                    cell.getRow() - grid.getPadding() == row) {

                cell.getShape().draw();
                cell.fill(false);
            }
        }
    }
}
