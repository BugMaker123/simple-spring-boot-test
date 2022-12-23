package com.example.simplespringboottest.prac.practice.tree;

public class BinarySearchTree<E extends Comparable<E>> {


    protected static class TreeNode<E extends Comparable<E>> {
        private E element;
        private TreeNode<E> left;
        private TreeNode<E> right;

        public TreeNode() {
        }

        public TreeNode(E element, TreeNode<E> left, TreeNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode<E> root;

    private static int size = 0;

    public BinarySearchTree() {
    }

    public BinarySearchTree(TreeNode<E> root) {
        this.root = root;
    }

    public boolean insertElement(E e) {
        // 1.如果树是空的,直接给根节点赋值
        if (root == null) {
            root = createNode(e);
            return true;
        } else if (root != null) {
            TreeNode parent = root;
            while (parent != null) {
                TreeNode node = createNode(e);
                if (node.element.compareTo(parent.element) > 0) {
                    if (parent.right == null) {
                        parent.right = node;
                        return true;
                    }
                    parent = parent.right;
                } else if (node.element.compareTo(parent.element) < 0) {
                    if (node.element.compareTo(parent.element) > 0) {
                        if (parent.left == null) {
                            parent.left = node;
                            return true;
                        }
                        parent = parent.left;
                    }
                }
            }
        }
        return false;
    }

    private  TreeNode createNode(E e){
        return new TreeNode(e, null, null);
    }
}
