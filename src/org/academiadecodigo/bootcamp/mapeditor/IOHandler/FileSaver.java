package org.academiadecodigo.bootcamp.mapeditor.IOHandler;

import org.academiadecodigo.bootcamp.mapeditor.Grid.Cell.Cell;

import java.io.*;
import java.util.ArrayList;

public class FileSaver {

    private FileInputStream in = null;
    private FileOutputStream out = null;
    private ArrayList<Cell> cells;

    public FileSaver(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    private String convertGrid() {

        // convert cell state to string in order to know where is filled
        ArrayList<String> myArr = new ArrayList<>();

        for (Cell cell : cells) {

            if (cell.isFilled()) {
                myArr.add("1");
            }
            myArr.add("0");
        }

        return String.join("", myArr);
    }

    public void save(String dst) {

        try {

            this.in = new FileInputStream(convertGrid());
            this.out = new FileOutputStream(dst);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] buffer = new byte[1024];
        int bytesRead = 0;

        while (true) {
            try {

                if ((bytesRead = in.read(buffer)) == -1) break;
                    out.write(buffer, 0, bytesRead);
                    in.close();
                    out.close();
                    System.out.println("trying to save file");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
