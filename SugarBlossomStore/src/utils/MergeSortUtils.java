/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.List;
import java.util.ArrayList;

/**
 * Utility class that implements the Merge Sort algorithm.
 *
 * Merge Sort is a stable, divide-and-conquer sorting algorithm with
 * O(n log n) time complexity. It is used in this project to sort the
 * applicant names loaded from the form file.
 *
 * The algorithm works recursively by splitting the list into halves
 * and merging them back together in alphabetical order.
 *
 * @author mariana
 */
public class MergeSortUtils {

    /**
     * Recursively divides the list into halves and merges them back
     * in sorted order.
     *
     * @param names the list of names to be sorted
     * @return a new list containing the names in alphabetical order
     */
    public static List<String> mergeSort(List<String> names) {

        // Lists of size 0 or 1 are already sorted
        if (names.size() <= 1) {
            return names;
        }

        int mid = names.size() / 2;

        // Divide list into left and right halves
        List<String> left = mergeSort(new ArrayList<>(names.subList(0, mid)));
        List<String> right = mergeSort(new ArrayList<>(names.subList(mid, names.size())));

        return merge(left, right);
    }

    /**
     * Merges two already-sorted lists into a single sorted list.
     *
     * @param left  the left sorted half
     * @param right the right sorted half
     * @return a new list containing all elements in alphabetical order
     */
    private static List<String> merge(List<String> left, List<String> right) {
        List<String> result = new ArrayList<>();

        int i = 0, j = 0;

        // Compare elements from both lists and append the smaller one
        while (i < left.size() && j < right.size()) {

            if (left.get(i).compareToIgnoreCase(right.get(j)) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Append remaining elements from each list
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
