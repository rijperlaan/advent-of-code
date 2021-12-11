package com.rijperlaan.aoc.day04;

import com.rijperlaan.aoc.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day4 {
    public static void main(String[] args) {
        List<String> input = Util.readFileAsStrings("inputs/day4-1.txt");

        System.out.println("--- Part 1 & 2: ---");
        part1(input);
    }

    public static void part1(List<String> input) {
        Queue<String> queue = new LinkedList<>(input);

        String[] order = queue.remove().split(",");
        queue.remove();

        List<Board> boards = new ArrayList<>();

        while (!queue.isEmpty()) {
            Board board = new Board(new String[]{queue.remove(), queue.remove(), queue.remove(), queue.remove(), queue.remove()});
            boards.add(board);
            if (!queue.isEmpty()) {
                queue.remove();
            }
        }

        int firstBoardScore = -1;
        int lastBoardScore = -1;

        for (String current : order) {
            for (Board board : boards) {
                if (!board.hasBingo()) {
                    int number = Integer.parseInt(current);
                    board.complete(number);
                    if (board.hasBingo()) {
                        int score = board.getScore(number);
                        if (firstBoardScore == -1) {
                            firstBoardScore = score;
                        }
                        lastBoardScore = board.getScore(number);
                    }
                }

            }
        }

        System.out.println("firstBoardScore = " + firstBoardScore);
        System.out.println("lastBoardScore = " + lastBoardScore);
    }
}
