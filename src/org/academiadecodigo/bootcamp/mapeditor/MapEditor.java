package org.academiadecodigo.bootcamp.mapeditor;

import org.academiadecodigo.bootcamp.mapeditor.Grid.MapEditorGrid;
import org.academiadecodigo.bootcamp.mapeditor.Painter.Painter;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class MapEditor {

    private int cols;
    private int rows;
    MapEditorGrid mapEditorGrid;
    Painter painter;

    public MapEditor(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void init() {

        // instantiate grid
        mapEditorGrid = new MapEditorGrid(cols, rows);
        mapEditorGrid.init();

        // instantiate painter
        painter = new Painter(
                mapEditorGrid,
                Color.BLACK,
                mapEditorGrid.getPadding(),
                mapEditorGrid.getPadding(),
                mapEditorGrid.getCellSize(),
                mapEditorGrid.getCellSize());
        painter.init();
    }

}
