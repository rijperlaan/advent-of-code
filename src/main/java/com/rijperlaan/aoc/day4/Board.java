package com.rijperlaan.aoc.day4;

import lombok.Data;

import java.util.Arrays;

@Data
public class Board {
    private int[][] numbers;
    private boolean[][] complete;
    private int length;

    public Board(String[] rowStrings) {
        length = rowStrings.length;

        numbers = new int[length][length];
        complete = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            Arrays.fill(complete[i], false);

            if (rowStrings[i].startsWith(" ")) {
                rowStrings[i] = rowStrings[i].substring(1);
            }
            String[] rowNumbers = rowStrings[i].split("\\s+");
            for (int j = 0; j < length; j++) {
                numbers[i][j] = Integer.parseInt(rowNumbers[j]);
            }
        }

    }

    public void complete(int number) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (numbers[i][j] == number) {
                    complete[i][j] = true;
                }
            }
        }
    }

    public boolean hasBingo() {
        for (int i = 0; i < length; i++) {
            boolean row = true;
            boolean column = true;

            for (int j = 0; j < length; j++) {
                if (!complete[i][j]) {
                    row = false;
                }
                if (!complete[j][i]) {
                    column = false;
                }
            }

            if (row || column) {
                return true;
            }
        }

        return false;
    }

    public int getScore(int lastNumber) {
        int score = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (!complete[i][j]) {
                    score += numbers[i][j];
                }
            }
        }

        return score * lastNumber;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append("[");
            for (int j = 0; j < length; j++) {
                if (complete[i][j]) {
                    builder.append("x");
                } else {
                    builder.append(" ");
                }
            }
            builder.append("]\n");
        }
        return builder.toString();
    }
}
