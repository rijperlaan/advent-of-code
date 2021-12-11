package com.rijperlaan.aoc.day01;

import com.rijperlaan.aoc.Util;

import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        List<Integer> input = Util.readFileAsIntegers("inputs/day1-1.txt");
        int increases = 0;
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i) < input.get(i + 1)) {
                increases++;
            }
        }

        System.out.println("increases p1 = " + increases);
    }

    public static void part2() {
        List<Integer> input = Util.readFileAsIntegers("inputs/day1-2.txt");
        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < input.size() - 2; i++) {
            sums.add(input.get(i) + input.get(i + 1) + input.get(i + 2));
        }

        int increases = 0;
        for (int i = 0; i < sums.size() - 1; i++) {
            if (sums.get(i) < sums.get(i + 1)) {
                increases++;
            }
        }

        System.out.println("increases p2 = " + increases);
    }
}
