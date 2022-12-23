package com.example.simplespringboottest.prac.practice.simple_tree;

import lombok.Data;

import java.util.List;

/**
 * @ ClassName: TreeNode
 * @Author: legen
 * @Date: 2021/4/16
 */
@Data
public class TreeNode<E> {

    private static int size = 0;

    private TreeNode prev;

    private E e;

    private TreeNode next;

    private TreeNode<E> parentNode;

    private List<TreeNode<E>>list;

    public void add() {
    }
}
