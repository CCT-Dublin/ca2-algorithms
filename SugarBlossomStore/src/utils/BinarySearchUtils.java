/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
/**
 * Utility class that provides a binary search implementation for
 * locating an Employee within a sorted list.
 *
 * The list must be sorted alphabetically by employee name for
 * binary search to work correctly.
 * 
 * @author mariana
 */

import java.util.List;
import model.Employee;

public class BinarySearchUtils {
    
    //Performs binary search on a sorted list of employees

    public static int binarySearch(List<Employee> list, String targetName) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            
             //Middle index of the current search range
            int mid = (low + high) / 2;
            
            //Compare the target name with the name stored at mid
            int comparison = list.get(mid).getName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return mid;  //Exact match found
            }
            if (comparison < 0) {
                
             //target name is alphabetically after mid > search right half
                low = mid + 1; 
                
            //target name is alphabetically before mid > search left half
            } else {
                high = mid - 1;
            }
        }

        return -1; //no match found
    }
}
