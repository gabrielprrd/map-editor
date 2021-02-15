package org.academiadecodigo.bootcamp.mapeditor.InputHandler;

import org.academiadecodigo.bootcamp.mapeditor.Painter.Painter;

public class Paint {

    private Painter painter;

    public Paint (Painter painter) {

        this.painter = painter;
    }

    public void fill() {

        painter.paint();
    }

    public void erase() {

        painter.eraseColor();
    }
}
