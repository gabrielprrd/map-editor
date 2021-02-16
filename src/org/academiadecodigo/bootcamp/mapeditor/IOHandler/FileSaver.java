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

        // convert cell state to string in order to store in a text file
        ArrayList<String> stringsArray = new ArrayList<>();

        for (Cell cell : cells) {

            if (cell.isFilled()) {
                stringsArray.add("1");
            }
            stringsArray.add("0");
        }

        return String.join("", stringsArray);
    }

    public void save(String dst) {
        // BufferedWriter bufferedWriter = new BufferedWriter(new Writer(convertGrid()));

        try {
            this.out = new FileOutputStream(dst);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] buffer = new byte[1024];
        int bytesRead = 0;

        try {
            if ((bytesRead = in.read(buffer)) == -1) {

                out.write(buffer, 0, bytesRead);
                System.out.println("trying to save file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
        out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
