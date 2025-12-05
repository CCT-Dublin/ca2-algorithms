/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Represents a single node in the binary search tree used to store
 * applicant names from the input file.
 *
 * Each node contains:
 * - The applicant's name
 * - A reference to the left child
 * - A reference to the right child
 *
 * The structure supports ordered insertion and tree traversal
 * (pre-order, in-order, and post-order) operations implemented
 * in the {@link ApplicantTree} class.
 *
 * Nodes are created when inserting applicants into the tree.
 *
 * @author mariana
 */
public class ApplicantNode {

    public String name;
    public ApplicantNode left;
    public ApplicantNode right;

    /**
     * Creates a new node containing the provided applicant name.
     * Both child references are initialized as null.
     *
     * @param name the name of the applicant stored in this node
     */
    public ApplicantNode(String name) {
        this.name = name;
        this.left = null;
        this.right = null;
    }
}
