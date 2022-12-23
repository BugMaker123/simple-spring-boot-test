package com.example.simplespringboottest.prac.practice.tree;


public class BST_test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 0; i < 10; i++) {
            tree.insertElement(i);
        }
    }
}
