package com.urise.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainStream {
    public static void main(String[] args) {
        int[] values1 = {1,2,3,3,2,3};
        int[] values2 = {9,8};

        System.out.println("values1: " + Arrays.toString(values1) + " out: " + minValue(values1));
        System.out.println("values2: " + Arrays.toString(values2) + " out: " + minValue(values2));

        List<Integer> integers = new ArrayList<>();
        for (int i = 2; i < 10; i++) {
            integers.add(i);
        }
        System.out.println("integers: " + integers.toString() + " out: " + oddOrEven(integers));
    }

    private static int minValue(int[] values) {
        return Arrays.stream(values).sorted().distinct().reduce(0, (x, y) -> (x * 10) + y);
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        Map<Boolean, List<Integer>> oddOrEven =
                integers.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0));
        return oddOrEven.get(integers.stream().mapToInt(Integer::intValue).sum() % 2 != 0);
    }
}
