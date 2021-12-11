package com.rijperlaan.aoc.day08;

import com.rijperlaan.aoc.Util;

import java.util.Arrays;
import java.util.List;

public class Day8 {
    public static void main(String[] args) {
        List<String> input = Util.readFileAsStrings("inputs/day8-1.txt");

        System.out.println("--- Part 1 : ---");
        part1(input);

        System.out.println("\n--- Part 2 : ---");
        part2(input);
    }

    public static void part1(List<String> input) {
        int total = 0;

        for (String line : input) {
            String[] outputs = line.split(" \\| ")[1].split(" ");
            for (String symbols : outputs) {
                switch (symbols.length()) {
                    case 2, 3, 4, 7 -> total++;
                }
            }
        }

        System.out.println("total = " + total);
    }

    public static void part2(List<String> input) {
        int total = 0;

        for (String line : input) {
            String zero = "";
            String one = "";
            String two = "";
            String three = "";
            String four = "";
            String five = "";
            String six = "";
            String seven = "";
            String eight = "";
            String nine = "";


            String[] inputs = line.split(" \\| ")[0].split(" ");

            for (int i = 0; i < inputs.length; i++) {
                String symbols = inputs[i];
                switch (symbols.length()) {
                    case 2 -> {
                        one = symbols;
                        inputs[i] = "";
                    }
                    case 3 -> {
                        seven = symbols;
                        inputs[i] = "";
                    }
                    case 4 -> {
                        four = symbols;
                        inputs[i] = "";
                    }
                    case 7 -> {
                        eight = symbols;
                        inputs[i] = "";
                    }
                }
            }

            for (int i = 0; i < inputs.length; i++) {
                String[] inputs2 = Arrays.copyOf(inputs, inputs.length);
                String symbols = inputs2[i];

                if (!symbols.isEmpty()) {
                    if (symbols.length() == 5) {
                        // 2, 3, 5
                        if (containsAllCharacters(symbols, one)) {
                            three = symbols;
                        } else {
                            if (five.isEmpty()) {
                                five = symbols;
                            } else {
                                two = symbols;
                            }
                        }
                    } else {
                        // 0, 6, 9
                        if (containsAllCharacters(symbols, four)) {
                            nine = symbols;
                        } else if (containsAllCharacters(symbols, one)) {
                            zero = symbols;
                        } else {
                            six = symbols;
                        }
                    }
                }
                inputs2[i] = "";
            }

            if (occurrences(six, five) != 5) {
                String temp = five;
                five = two;
                two = temp;
            }

            StringBuilder subtotal = new StringBuilder();
            String[] outputs = line.split(" \\| ")[1].split(" ");

            for (String symbols : outputs) {
                if (symbols.length() == zero.length() && containsAllCharacters(symbols, zero)) {
                    subtotal.append("0");
                } else if (symbols.length() == one.length() && containsAllCharacters(symbols, one)) {
                    subtotal.append("1");
                } else if (symbols.length() == two.length() && containsAllCharacters(symbols, two)) {
                    subtotal.append("2");
                } else if (symbols.length() == three.length() && containsAllCharacters(symbols, three)) {
                    subtotal.append("3");
                } else if (symbols.length() == four.length() && containsAllCharacters(symbols, four)) {
                    subtotal.append("4");
                } else if (symbols.length() == five.length() && containsAllCharacters(symbols, five)) {
                    subtotal.append("5");
                } else if (symbols.length() == six.length() && containsAllCharacters(symbols, six)) {
                    subtotal.append("6");
                } else if (symbols.length() == seven.length() && containsAllCharacters(symbols, seven)) {
                    subtotal.append("7");
                } else if (symbols.length() == eight.length() && containsAllCharacters(symbols, eight)) {
                    subtotal.append("8");
                } else if (symbols.length() == nine.length() && containsAllCharacters(symbols, nine)) {
                    subtotal.append("9");
                }
            }
            total += Integer.parseInt(subtotal.toString());
        }


        System.out.println("total = " + total);
    }

    public static boolean containsAllCharacters(String string, String chars) {
        for (char c : chars.toCharArray()) {
            if (!string.contains("" + c)) {
                return false;
            }
        }
        return true;
    }

    public static int occurrences(String string, String chars) {
        int res = 0;
        for (char c : chars.toCharArray()) {
            if (string.contains("" + c)) {
                res++;
            }
        }
        return res;
    }


}
