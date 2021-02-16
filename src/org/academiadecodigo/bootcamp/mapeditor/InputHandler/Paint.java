package org.academiadecodigo.bootcamp.mapeditor.InputHandler;

import org.academiadecodigo.bootcamp.mapeditor.Grid.MapEditorGrid;
import org.academiadecodigo.bootcamp.mapeditor.Painter.Painter;

public class Paint {

    private Painter painter;
    private MapEditorGrid mapEditorGrid;

    public Paint (MapEditorGrid mapEditorGrid, Painter painter) {

        this.mapEditorGrid = mapEditorGrid;
        this.painter = painter;
    }

    public void fill() {

        painter.paint();
    }

    public void erase() {

        painter.eraseColor();
    }

    public void clearGrid() {

        mapEditorGrid.clear();
    }
}
