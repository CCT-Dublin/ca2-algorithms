/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 * Represents a single node inside the binary search tree used for applicant data.
 * Each node stores an applicant name and references to its left and right children.
 * The structure allows efficient ordered insertion and traversal operations.
 *
 * @author mariana
 */
public class ApplicantNode {
    
     public String name;
    public ApplicantNode left;
    public ApplicantNode right;

    public ApplicantNode(String name) {
        this.name = name;
        this.left = null;
        this.right = null;
    }
}
