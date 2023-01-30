package com.g2b1.dsa.gradedassignment02.problem04;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) {
        SortedMap<Integer, Integer> possibilites = new TreeMap<>();
        possibilites.put((int) '[', (int) ']');
        possibilites.put((int) '(', (int) ')');
        possibilites.put((int) '{', (int) '}');

        String input1 = "([[{}]])";
        String input2 = "([[{}]]))";

        if (Boolean.TRUE.equals(isBalancedBrackets(input1, possibilites))) {
            System.out.println(String.format("%s is balanced", input1));
        } else {
            System.out.println(String.format("%s is not balanced", input1));
        }

        if (Boolean.TRUE.equals(isBalancedBrackets(input2, possibilites))) {
            System.out.println(String.format("%s is balanced", input2));
        } else {
            System.out.println(String.format("%s is not balanced", input2));
        }
    }

    private static Boolean isBalancedBrackets(String input, SortedMap<Integer, Integer> possibilites) {
        var items = input.chars().boxed().toList();
        var primaryElements = possibilites.keySet();
        primaryElements.retainAll(items);
        Boolean checkFlag = true;
        for (var key : primaryElements) {
            if (Collections.frequency(items, key) != Collections.frequency(items, possibilites.get(key))) {
                checkFlag = false;
                break;
            }
        }
        return checkFlag;
    }
}
