/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
/**
 * Utility class responsible for reading applicant names from the
 * provided CSV-like text file.
 *
 * The file format follows the structure given for this assignment
 * FirstName,LastName,OtherColumns...
 *
 * This class extracts only the first and last name of each applicant.
 *
 * @author mariana
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtils {
    
    //Reads an input file and extracts full names (First + Last)
    public static List<String> readNamesFromCSV(String filename) {
        List<String> names = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean skipHeader = true; //first line contains title

            while ((line = br.readLine()) != null) {

                //Skip header row (column titles)
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                //Split the line by comma
                String[] parts = line.split(",");

                //Ensure there are at least first and last name columns
                if (parts.length >= 2) {
                    String fullName = parts[0].trim() + " " + parts[1].trim();
                    names.add(fullName); //store clean full name
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return names;
    }
}

