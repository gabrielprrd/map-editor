package org.academiadecodigo.bootcamp.mapeditor.Grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MapEditorGrid implements Grid {

    static final int CELL_SIZE = 10;
    static final int PADDING = 10;
    private int cols;
    private int rows;
    private Rectangle grid;
    // private GridPosition gridPosition;

    public MapEditorGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;

        grid = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
    }

    @Override
    public void init() {
        grid.draw();
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

    @Override
    public GridPosition makeGridPosition() {
        return null;
    }

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return null;
    }

    public int getWidth() {
        return cols*CELL_SIZE;
    }

    public int getHeight() {
        return rows*CELL_SIZE;
    }

    public void generateCells() {
        for (int i=0; i<cols; i++) {
            for (int j=0; j<rows; j++) {

                new Rectangle(PADDING+(CELL_SIZE*i), PADDING+(CELL_SIZE*j), CELL_SIZE, CELL_SIZE).draw();
            }
        }
    }
}
