package org.academiadecodigo.bootcamp.mapeditor.InputHandler;

import org.academiadecodigo.bootcamp.mapeditor.Painter.Painter;

public class Movement {

    private Painter painter;
    private int distance;

    public Movement(Painter painter) {

        this.painter = painter;
        distance = painter.getGrid().getCellSize();
    }

    public void moveDown() {
        if (painter.getRow() == painter.getGrid().getHeight()) return;

        painter.getCursor().translate(0, distance);
        painter.updateRowToDown();
    }

    public void moveUp() {
        if (painter.getRow() == 0) return;

        painter.getCursor().translate(0, -distance);
        painter.updateRowToUp();
    }

    public void moveLeft() {
        if (painter.getCol() == 0) return;

        painter.getCursor().translate(-distance, 0);
        painter.updateColToLeft();
    }

    public void moveRight() {
        if (painter.getCol() == painter.getGrid().getWidth()) return;

        painter.getCursor().translate(distance, 0);
        painter.updateColToRight();
    }
}
