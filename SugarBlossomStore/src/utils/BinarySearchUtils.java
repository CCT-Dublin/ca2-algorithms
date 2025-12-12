/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.List;
import model.Employee;

/**
 * Utility class that implements the Binary Search algorithm for locating
 * an {@link Employee} inside a sorted list.
 *
 * Binary Search requires the list to be sorted alphabetically by employee name.
 * When this condition is met, the algorithm operates in O(log n) time,
 * making it significantly more efficient than a linear search on large datasets.
 *
 * This class is used in the SEARCH functionality of the application.
 *
 * @author mariana
 */
public class BinarySearchUtils {

    /**
     * Performs a binary search on a sorted list of Employee objects.
     *
     * @param list        the list of employees, already sorted alphabetically
     * @param targetName  the name being searched for (case-insensitive)
     * @return the index where the employee is found, or -1 if not present
     */
    public static int binarySearch(List<Employee> list, String targetName) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {

            // Middle index of the current search range
            int mid = (low + high) / 2;

            // Compare the name at 'mid' with the target
            int comparison = list.get(mid).getName().compareToIgnoreCase(targetName);

            // Exact match found
            if (comparison == 0) {
                return mid;
            }

            // If the target name comes after the mid element alphabetically,
            // search the right half
            if (comparison < 0) {
                low = mid + 1;
            }
            // Otherwise, search the left half
            else {
                high = mid - 1;
            }
        }

        // No match found
        return -1;
    }
}
