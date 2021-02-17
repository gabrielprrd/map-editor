package org.academiadecodigo.bootcamp.mapeditor;

import org.academiadecodigo.bootcamp.mapeditor.Grid.MapEditorGrid;
import org.academiadecodigo.bootcamp.mapeditor.IOHandler.FileLoader;
import org.academiadecodigo.bootcamp.mapeditor.IOHandler.FileSaver;
import org.academiadecodigo.bootcamp.mapeditor.InputHandler.MapEditorKeyboardHandler;
import org.academiadecodigo.bootcamp.mapeditor.InputHandler.MapEditorMouseHandler;
import org.academiadecodigo.bootcamp.mapeditor.Painter.Painter;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;


public class MapEditor {

    private int cols;
    private int rows;
    MapEditorGrid mapEditorGrid;
    Painter painter;
    FileSaver fileSaver;
    FileLoader fileLoader;

    private MapEditorKeyboardHandler mapEditorKeyboardHandler;
    private Keyboard keyboard;
    private KeyboardEvent keyboardEvent;
    private KeyboardEventType keyboardEventType;

    private MapEditorMouseHandler mapEditorMouseHandler;
    private Mouse mouse;
    private MouseEvent mouseEvent;
    private MouseEventType mouseEventType;

    public MapEditor(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void init() {

        // instantiate grid
        mapEditorGrid = new MapEditorGrid(this, cols, rows);
        mapEditorGrid.init();

        // instantiate file saver and loader
        fileSaver = new FileSaver();
        fileLoader = new FileLoader();

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

        // keyboard
        mapEditorKeyboardHandler = new MapEditorKeyboardHandler(this, painter);
        keyboard = new Keyboard(mapEditorKeyboardHandler);
        keyboardEvent = new KeyboardEvent();
        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_E, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_S, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_L, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_C, KeyboardEventType.KEY_PRESSED);

        // mouse
        mapEditorMouseHandler = new MapEditorMouseHandler(this, painter);
        mouse = new Mouse(mapEditorMouseHandler);
        mouseEvent = new MouseEvent(painter.getY(), painter.getX(), mouseEventType);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

    }

    public Painter getPainter() {
        return painter;
    }

    public MapEditorGrid getMapEditorGrid() {
        return mapEditorGrid;
    }

    public FileSaver getFileSaver() {
        return fileSaver;
    }

    public void load() {
        mapEditorGrid.fileToGrid(fileLoader.load());
    }

}
