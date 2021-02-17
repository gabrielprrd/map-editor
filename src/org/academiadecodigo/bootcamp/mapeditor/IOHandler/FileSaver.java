package org.academiadecodigo.bootcamp.mapeditor.IOHandler;

import java.io.*;

public class FileSaver {

    public void save(String formattedGrid) {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter("saved-drawing.txt"));
            writer.write(formattedGrid);
            writer.close();

        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

}
