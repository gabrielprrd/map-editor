package org.academiadecodigo.bootcamp.mapeditor.Grid;

import org.academiadecodigo.bootcamp.mapeditor.Grid.Cell.Cell;
import org.academiadecodigo.bootcamp.mapeditor.MapEditor;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;

public class MapEditorGrid implements Grid {

    static final int CELL_SIZE = 10;
    static final int PADDING = 10;
    private int cols;
    private int rows;
    private Rectangle grid;
    private ArrayList<Cell> cells;
    private MapEditor mapEditor;

    public MapEditorGrid(MapEditor mapEditor, int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.mapEditor = mapEditor;

        grid = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
    }

    @Override
    public void init() {
        grid.draw();
        cells = new ArrayList<>();
        generateCells();
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public int getRows() {
        return rows;
    }

    public int getWidth() {
        return cols*CELL_SIZE;
    }

    public int getHeight() {
        return rows*CELL_SIZE;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }

    public int getPadding() {
        return PADDING;
    }

    public void generateCells() {

        for (int i=0; i<cols; i++) {
            for (int j=0; j<rows; j++) {

                Cell cell = new Cell(PADDING+(CELL_SIZE*i), PADDING+(CELL_SIZE*j), CELL_SIZE, CELL_SIZE);
                cells.add(cell);
            }
        }

        for (Cell cell : cells) {
            cell.getShape().draw();
        }
    }

    public void paintCell() {
        for (Cell cell : cells) {

            if (cell.getCol()-getPadding() == mapEditor.getPainter().getCol() &&
                cell.getRow()-getPadding() == mapEditor.getPainter().getRow()) {

                cell.paint(grid.getColor());
                cell.fill(true);
            }
        }
    }

   public void eraseColor() {
        for (Cell cell : cells) {

            if (cell.getCol()-getPadding() == mapEditor.getPainter().getCol() &&
                cell.getRow()-getPadding() == mapEditor.getPainter().getRow()) {

                cell.getShape().draw();
                cell.fill(false);
            }
        }
   }
}
