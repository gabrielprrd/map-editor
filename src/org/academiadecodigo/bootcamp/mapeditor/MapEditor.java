package org.academiadecodigo.bootcamp.mapeditor;

import org.academiadecodigo.bootcamp.mapeditor.Grid.MapEditorGrid;
import org.academiadecodigo.bootcamp.mapeditor.InputHandler.MapEditorKeyboardHandler;
import org.academiadecodigo.bootcamp.mapeditor.Painter.Painter;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class MapEditor {

    private int cols;
    private int rows;
    MapEditorGrid mapEditorGrid;
    Painter painter;

    private MapEditorKeyboardHandler mapEditorKeyboardHandler;
    private Keyboard keyboard;
    private KeyboardEvent keyboardEvent;
    private KeyboardEventType keyboardEventType;

    public MapEditor(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void init() {

        // instantiate grid
        mapEditorGrid = new MapEditorGrid(this, cols, rows);
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

        initInputHandlers();
    }

    public void initInputHandlers() {
        mapEditorKeyboardHandler = new MapEditorKeyboardHandler(this, painter);
        keyboard = new Keyboard(mapEditorKeyboardHandler);
        keyboardEvent = new KeyboardEvent();
        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_E, KeyboardEventType.KEY_PRESSED);
    }

    public Painter getPainter() {
        return painter;
    }

    public MapEditorGrid getMapEditorGrid() {
        return mapEditorGrid;
    }
}
