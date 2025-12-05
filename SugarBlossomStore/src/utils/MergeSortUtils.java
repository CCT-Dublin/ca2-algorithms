/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
/**
 * Utility class that implements the Merge Sort algorithm.
 *
 * Merge Sort is a stable, divide-and-conquer sorting algorithm
 * with O(n log n) time complexity, making it suitable for
 * ordering large lists of names efficiently.
 *
 * @author mariana
 */
import java.util.List;
import java.util.ArrayList;

public class MergeSortUtils {
    
    //Recursively divides the list into halves and merges them back in sorted order

    public static List<String> mergeSort(List<String> names) {
        
        //A list of size 0 or 1 is already sorted
        if (names.size() <= 1) {
            return names;
        }

        int mid = names.size() / 2;
        
        //Divide list into left and right halves
        List<String> left = mergeSort(new ArrayList<>(names.subList(0, mid)));
        List<String> right = mergeSort(new ArrayList<>(names.subList(mid, names.size())));

        return merge(left, right);
    }
    //Merges two already-sorted lists into a single sorted list
    
    private static List<String> merge(List<String> left, List<String> right) {
        List<String> result = new ArrayList<>();
        
        int i = 0, j = 0;
        
       // Compare elements from left and right lists
        while (i < left.size() && j < right.size()) {
            
      //Add the alphabetically smaller element
            if (left.get(i).compareToIgnoreCase(right.get(j)) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        //Append any remaining elements from either list
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
