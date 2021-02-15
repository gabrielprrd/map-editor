package org.academiadecodigo.bootcamp.mapeditor.InputHandler;

import org.academiadecodigo.bootcamp.mapeditor.MapEditor;
import org.academiadecodigo.bootcamp.mapeditor.Painter.Painter;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MapEditorKeyboardHandler implements KeyboardHandler {

    private MapEditor mapEditor;
    private Movement movement;
    private Paint paint;

    public MapEditorKeyboardHandler(MapEditor mapEditor, Painter painter) {

        this.mapEditor = mapEditor;
        movement = new Movement(painter);
        paint = new Paint(painter);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                paint.fill();
                break;
            case KeyboardEvent.KEY_E:
                paint.erase();
                break;
            case KeyboardEvent.KEY_UP:
                movement.moveUp();
                break;
            case KeyboardEvent.KEY_DOWN:
                movement.moveDown();
                break;
            case KeyboardEvent.KEY_LEFT:
                movement.moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                movement.moveRight();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
