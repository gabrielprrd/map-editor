package org.academiadecodigo.bootcamp.mapeditor;

import org.academiadecodigo.bootcamp.mapeditor.Grid.MapEditorGrid;

public class MapEditor {

    private int cols;
    private int rows;

    public MapEditor(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void init() {
        MapEditorGrid mapEditorGrid = new MapEditorGrid(cols, rows);
        mapEditorGrid.init();
    }
}
