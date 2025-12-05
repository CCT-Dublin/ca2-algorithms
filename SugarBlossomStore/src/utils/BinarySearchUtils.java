/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.List;
import model.Employee;

/**
 * Utility class that provides a binary search implementation for
 * locating an Employee within a sorted list.
 *
 * The list must be sorted alphabetically by employee name for
 * binary search to operate correctly.
 *
 * @author mariana
 */
public class BinarySearchUtils {

    /**
     * Performs a binary search on a sorted list of Employee objects.
     *
     * @param list        the list of employees, already sorted by name
     * @param targetName  the name to search for
     * @return the index where the employee is found, or -1 if not present
     */
    public static int binarySearch(List<Employee> list, String targetName) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {

            // Calculate the middle index of the current range
            int mid = (low + high) / 2;

            // Compare the target name with the name stored at 'mid'
            int comparison = list.get(mid).getName().compareToIgnoreCase(targetName);

            // Exact match found
            if (comparison == 0) {
                return mid;
            }

            // If target name is alphabetically after the mid element,
            // continue searching the right half
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
