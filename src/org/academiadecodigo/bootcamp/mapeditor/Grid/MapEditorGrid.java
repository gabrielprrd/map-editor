package org.academiadecodigo.bootcamp.mapeditor.Grid;

import org.academiadecodigo.bootcamp.mapeditor.Grid.Cell.Cell;
import org.academiadecodigo.bootcamp.mapeditor.MapEditor;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MapEditorGrid implements Grid {

    public static final int CELL_SIZE = 10;
    public static final int PADDING = 10;
    private int cols;
    private int rows;
    private Rectangle grid;
    private Cell[][] cells;
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
        cells = new Cell[rows][cols];
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
        

        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                cells[row][col] = new Cell(row, col);
                cells[row][col].getShape().draw();
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void clear() {

        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col].erase();
            }
        }

    }

    public void fileToGrid(String file) {

        int index = 0;

        for (int row=0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                Cell cell = cells[row][col];
                //if (file.charAt(index) == "0") {
                if(true) {
                    cell.erase();
                } else {
                    cell.paint(Color.BLACK);
                }
                index++;
            }
            index++;
        }
    }

    @Override
    public String toString() {

        String formattedGrid = "";

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; cols++) {
                formattedGrid += cells[row][col];
            }
                formattedGrid += "\n";
        }

        return formattedGrid;
    }

}
