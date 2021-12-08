package com.rijperlaan.aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Integer> readFileAsIntegers(String fileName) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
                list.add(Integer.parseInt(line));
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<String> readFileAsStrings(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
                list.add(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static String readFileAsString(String fileName) {
        String result = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            result = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
