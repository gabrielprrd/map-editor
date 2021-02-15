package org.academiadecodigo.bootcamp.mapeditor.Painter;

import org.academiadecodigo.bootcamp.mapeditor.Grid.Cell.Cell;
import org.academiadecodigo.bootcamp.mapeditor.Grid.MapEditorGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Painter {

    private Rectangle cursor;
    private Color color;

    public Painter(MapEditorGrid grid, Color color, int col, int row, int size1, int size2) {
        this.color = color;

        cursor = new Rectangle(col, row, size1, size2);
    }

    public void init() {
        cursor.setColor(color);
        cursor.fill();
    }

    public void fill() {
        //cell.paint(color);
    }

}
