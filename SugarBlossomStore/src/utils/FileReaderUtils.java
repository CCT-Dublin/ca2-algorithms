/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class responsible for reading applicant names from the
 * CSV-style file provided in the assignment.
 *
 * The expected file structure follows the pattern:
 * FirstName,LastName,OtherColumns...
 *
 * This class extracts only the first and last name of each applicant
 * and returns a list of clean, formatted full names.
 *
 * @author mariana
 */
public class FileReaderUtils {

    /**
     * Reads the specified file and extracts full names (first + last).
     *
     * @param filename the path to the applicant form file
     * @return a list of full names read from the file
     */
    public static List<String> readNamesFromCSV(String filename) {
        List<String> names = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            boolean skipHeader = true; // First line contains column titles

            while ((line = br.readLine()) != null) {

                // Skip the header row
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                // Split the line into fields
                String[] parts = line.split(",");

                // Ensure valid structure (at least first and last name)
                if (parts.length >= 2) {
                    String fullName = parts[0].trim() + " " + parts[1].trim();
                    names.add(fullName);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return names;
    }
}
