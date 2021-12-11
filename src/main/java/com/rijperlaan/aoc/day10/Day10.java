package com.rijperlaan.aoc.day10;

import com.rijperlaan.aoc.Util;

import java.util.*;

public class Day10 {
    public static final List<Character> opening = new ArrayList<>();
    public static final List<Character> closing = new ArrayList<>();
    public static final Map<Character, Integer> points = new HashMap<>();


    public static void main(String[] args) {
        List<String> input = Util.readFileAsStrings("inputs/day10-1.txt");
        opening.add('(');
        opening.add('[');
        opening.add('{');
        opening.add('<');

        closing.add(')');
        closing.add(']');
        closing.add('}');
        closing.add('>');

        points.put(')', 3);
        points.put(']', 57);
        points.put('}', 1197);
        points.put('>', 25137);

        System.out.println("--- Part 1 : ---");
        part1(input);

        System.out.println("\n--- Part 2 : ---");
        part2(input);
    }


    public static void part1(List<String> input) {
        int score = 0;
        for (String line : input) {
            char[] chars = line.toCharArray();
            Stack<Integer> stack = new Stack<>();
            for (char aChar : chars) {
                int index = opening.indexOf(aChar);
                if (index != -1) {
                    stack.add(index);
                } else {
                    index = closing.indexOf(aChar);
                    int lastOpener = stack.pop();
                    if (index != lastOpener) {
                        score += points.get(aChar);
                    }
                }
            }
        }
        System.out.println("score = " + score);
    }

    public static void part2(List<String> input) {
        List<Long> scores = new ArrayList<>();
        for (String line : input) {
            char[] chars = line.toCharArray();
            Stack<Integer> stack = new Stack<>();
            for (char aChar : chars) {
                int index = opening.indexOf(aChar);
                if (index != -1) {
                    stack.add(index);
                } else {
                    index = closing.indexOf(aChar);
                    int lastOpener = stack.pop();
                    if (index != lastOpener) {
                        stack.clear();
                        break;
                    }
                }
            }

            if (stack.isEmpty()) {
                continue;
            }

            long subTotal = 0;

            while (!stack.isEmpty()) {
                int current = stack.pop() + 1;
                subTotal = subTotal * 5 + current;
            }
            scores.add(subTotal);
        }

        Collections.sort(scores);
        long score = scores.get(scores.size() / 2);
        System.out.println("score = " + score);
    }
}
