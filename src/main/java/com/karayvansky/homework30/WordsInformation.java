package com.karayvansky.homework30;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordsInformation {

    public static void main(String[] args) {
        FileReader fileReader = null;
        String line = null;
        try {
            fileReader = new FileReader("d:\\SomeText.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Integer> result = new HashMap<String, Integer>();
        while (line != null) {
            String[] parts = line.split(" ");
            for (String word : parts) {
                if (word.length() > 3) {
                    word = word.replace('.', ' ');
                    word = word.replaceAll("[!,-?]", "");
                    if (result.containsKey(word)) {
                        result.put(word, result.get(word) + 1);
                    } else {
                        result.put(word, 1);
                    }
                }
            }
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result);
        try {
            insertMapToFile(new FileWriter("d:\\TextOut.txt"), result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertMapToFile(FileWriter file, Map<String, Integer> map) {
        try (BufferedWriter writer = new BufferedWriter(file)) {
            for (String word : map.keySet()) {
                writer.write(word + " : " + map.get(word));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
