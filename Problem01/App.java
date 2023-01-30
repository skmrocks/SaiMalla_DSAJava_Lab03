package com.g2b1.dsa.gradedassignment02.problem03;

import java.util.HashSet;
import java.util.Set;

class TNode {
    Integer data;
    TNode left = null;
    TNode right = null;

    TNode(Integer data) {
        this.data = data;
    }
}

public class App {

    public static void main(String[] args) {

        try {
            System.out.println("Enter Node Elements:");
            TNode root = null;
            String inputString = null;

            do {
                inputString = System.console().readLine();
                if (!inputString.isEmpty()) {
                    root = add(root, Integer.parseInt(inputString));
                }
            } while (!inputString.isEmpty());

            System.out.println("Enter sum:");
            Integer target = Integer.parseInt(System.console().readLine());

            Set<Integer> set = new HashSet<>();

            if (!findPair(root, target, set)) {
                System.out.println("Nodes are not found");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred.");
        }
    }

    private static TNode add(TNode appRoot, int appKey) {

        if (appRoot == null) {
            return new TNode(appKey);
        }

        if (appKey < appRoot.data) {
            appRoot.left = add(appRoot.left, appKey);
        } else {
            appRoot.right = add(appRoot.right, appKey);
        }

        return appRoot;
    }

    private static boolean findPair(TNode appRoot, int query, Set<Integer> items) {
        try {

            if (appRoot == null) {
                return false;
            }

            if (findPair(appRoot.left, query, items)) {
                return true;
            }

            if (items.contains(query - appRoot.data)) {
                System.out.println("Pair found (" + (query - appRoot.data) + ", "
                        + appRoot.data + ")");
                return true;
            } else {
                items.add(appRoot.data);
            }

            return findPair(appRoot.right, query, items);
        } catch (Exception e) {
            return false;
        }
    }
}
