package org.academiadecodigo.bootcamp.mapeditor.IOHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {

    BufferedReader reader = null;
    String result = "";

    public String load() {
        try {

            String line;
            reader = new BufferedReader(new FileReader("saved-drawing.txt"));
            while ((line = reader.readLine()) != null) {
                result += line + "\n";

            }

        } catch (IOException ex) {
            System.err.println("Something went wrong");
        } finally {

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;

    }
}
