package com.emented.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import com.emented.dto.InputData;
import com.emented.exception.WrongFileDataFormat;

public class FileWorker {

    private double a;
    private double b;
    private double e;


    public FileWorker() {

    }

    public void writeAnswerToFile(String answer) {
        try {
            Path file = Paths.get("answer_" + UUID.randomUUID() + ".txt");
            Files.write(file, List.of(answer), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }


    public InputData readInputData(File input) throws Exception {

        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {

            readInterval(reader);
            readE(reader);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return new InputData(a, b, e);
    }

    private void readInterval(BufferedReader reader) throws IOException, WrongFileDataFormat {

        String line = reader.readLine();
        if (line == null || line.isBlank()) {
            throw new WrongFileDataFormat("Empty file!");
        }
        String[] splitted = line.trim().replaceAll(" +", " ").split(" ");
        if (splitted.length != 2) {
            throw new WrongFileDataFormat("Invalid line: " + line + "\nsupposed 2 numbers, given - " + splitted.length);
        }
        try {
            a = Double.parseDouble(splitted[0].replaceAll(",", "."));
            b = Double.parseDouble(splitted[1].replaceAll(",", "."));

            if (a < -100 || a > 100) {
                throw new WrongFileDataFormat("Right border must be a floating point number between -100 and 100");
            }

            if (b < -100 || b > 100) {
                throw new WrongFileDataFormat("Left border must be a floating point number between -100 and 100");
            }

            if (a >= b) {
                throw new WrongFileDataFormat("Right boarder must be greater then left");
            }
        } catch (Exception e) {
            throw new WrongFileDataFormat("Borders must be floating point numbers");
        }


    }

    private void readE(BufferedReader reader) throws IOException, WrongFileDataFormat {
        String line = reader.readLine();
        if (line == null || line.isBlank()) {
            throw new WrongFileDataFormat("Supposed to get two lines, but got only 1");
        }
        try {
            e = Float.parseFloat(line.trim().replaceAll(",", "."));
        } catch (NumberFormatException e) {
            throw new WrongFileDataFormat("Accuracy must be a floating point number");
        }

        if (e <= 0 || e >= 1) {
            throw new WrongFileDataFormat("Accuracy must be greater then 0 and less then 1");
        }
    }

}
