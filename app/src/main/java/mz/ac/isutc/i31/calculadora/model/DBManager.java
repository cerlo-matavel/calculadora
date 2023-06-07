package mz.ac.isutc.i31.calculadora.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class DBManager {

    public static void save(File file, String data){

        try (FileOutputStream fos = new FileOutputStream(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos))
        ) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        } catch (IOException e) {
            // o que fazer caso nao grave
        }
    }

    public static ArrayList<String> read(File file){

        ArrayList<String> fileContents = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContents.add(line);
            }
        } catch (IOException e) {
            //Toast.makeText(this, "Nao existem operacoes anteriores", Toast.LENGTH_SHORT).show();
        }

        return fileContents;
    }
}
