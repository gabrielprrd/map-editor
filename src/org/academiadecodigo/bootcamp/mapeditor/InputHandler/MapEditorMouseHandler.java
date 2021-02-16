package org.academiadecodigo.bootcamp.mapeditor.InputHandler;

import org.academiadecodigo.bootcamp.mapeditor.MapEditor;
import org.academiadecodigo.bootcamp.mapeditor.Painter.Painter;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MapEditorMouseHandler implements MouseHandler {

    private MapEditor mapEditor;
    private Painter painter;
    private Paint paint;

    public  MapEditorMouseHandler(MapEditor mapEditor, Painter painter) {
        this.mapEditor = mapEditor;
        this.painter = painter;

        paint = new Paint(mapEditor.getMapEditorGrid(), painter);
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        paint.fill();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        painter.setY((int) mouseEvent.getY());
        painter.setX((int) mouseEvent.getX());
        System.out.println("y:" + painter.getY() +", x:" + painter.getX());
        System.out.println("col:" + painter.getCol() +", row:" + painter.getRow());

    }
}
