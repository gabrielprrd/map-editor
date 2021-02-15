package org.academiadecodigo.bootcamp.mapeditor.InputHandler;

import org.academiadecodigo.bootcamp.mapeditor.Grid.MapEditorGrid;
import org.academiadecodigo.bootcamp.mapeditor.Painter.Painter;

public class Paint {

    private Painter painter;
    private MapEditorGrid mapEditorGrid;

    public Paint (MapEditorGrid mapEditorGrid) {

        this.mapEditorGrid = mapEditorGrid;
    }

    public void fill() {

        mapEditorGrid.paintCell();
    }

    public void erase() {

        mapEditorGrid.eraseColor();
    }
}
