// Mergesort.java
// Your Name

import java.io.*;
import java.util.*;

public class Mergesort {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Mergesort <filename>");
            return;
        }

        String filename = args[0];
        List<Integer> unsorted = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            fileScanner.useDelimiter("\\s+"); // Using whitespace delimiter

            while (fileScanner.hasNext()) {
                if (fileScanner.hasNextInt()) {
                    unsorted.add(fileScanner.nextInt());
                } else {
                    fileScanner.next(); // Skip non-integer values
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File '" + filename + "' not found.");
            return;
        }

        System.out.println("Narasimha Reddy Putta");
        System.out.println("Unsorted array: " + unsorted);
        List<Integer> sorted = mergesort(unsorted);
        System.out.println("Sorted array: " + sorted);
    }

    private static List<Integer> mergesort(List<Integer> array) {
        if (array.size() <= 1) {
            return array;
        }

        int mid = array.size() / 2;
        List<Integer> left = mergesort(new ArrayList<>(array.subList(0, mid)));
        List<Integer> right = mergesort(new ArrayList<>(array.subList(mid, array.size())));

        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                result.add(left.get(leftIndex++));
            } else {
                result.add(right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            result.add(left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            result.add(right.get(rightIndex++));
        }

        return result;
    }
}
