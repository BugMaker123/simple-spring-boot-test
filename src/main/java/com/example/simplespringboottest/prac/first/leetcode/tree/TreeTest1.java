package com.example.simplespringboottest.prac.first.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树 的操作
 * 二叉树的遍历方式分为广度优先与深度优先
 * 广度优先为层序遍历
 * 而深度优先分为先序,后序,中序三种
 */

public class TreeTest1 {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode parent;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    /**
     * 判断左右子树是否平衡
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        // 如果根节点为空,则为平衡二叉树
        if (root == null) {
            return true;
        }
        // 如果不为空,要获取左子树的最大高度与右子树的最大高度
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }
    private static TreeNode initializeTreeData(){
        TreeNode node = new TreeNode(4);
        TreeNode temp1 = new TreeNode(1);
        TreeNode temp2 = new TreeNode(2);
        TreeNode temp3 = new TreeNode(3);
        TreeNode temp5 = new TreeNode(5);
        node.left = temp2;
        node.right = temp5;
        temp2.right = temp3;
        temp2.left = temp1;

        temp2.parent = node;
        temp5.parent = node;
        temp3.parent = temp2;
        temp1.parent = temp2;
        return node;
    }


    public static void main(String[] args) {
        // 手动构建二叉树
        TreeNode node = initializeTreeData();
        // todo 二叉树的遍历方式分为广度优先与深度优先,其中广度优先为层序遍历,深度优先分为 先序,中序,后序三种(又可分为递归与非递归实现方式)
        // 二叉树的遍历方式 先序,中序,后序(递归形式)
        System.out.println("前序遍历");
        firstIterator(node);
        System.out.println();
        System.out.println("中序遍历");
        midIterator(node);
        System.out.println();
        System.out.println("后序遍历");
        endIterator(node);
        // 先序,中序,后序(非递归形式)
        firstIteratorWithoutRecursion(node);
        midIteratorWithoutRecursion(node);
        endIteratorWithoutRecursion(node);
        // 层序遍历
        widthIterator(node);
        // 二叉树的最大深度
        System.out.println(maxDepth(node));
    }

    /**
     * 二叉树最大深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 二叉树的层级遍历
     * 可以利用队列先入先入的属性,
     * 遍历完成第一层,然后拿到第一层的左右节点,此时将左右节点放入队列,然后将第一层元素放出,将第二层加入队列
     * @param node
     */
    private static void widthIterator(TreeNode node) {
        if(node==null){
            return;
        }
        TreeNode cur = node;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 先将根节点加入队列尾部
        queue.offer(cur);
        while(!queue.isEmpty()){
            // 取出队尾的元素
            TreeNode treeNode = queue.poll();
            // 将队尾元素的节点添加到list当中
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        System.out.println();
        System.out.println("=========广度优先搜索======");
        System.out.println(list.toString());
    }


    private static void endIterator(TreeNode node) {
        if (node == null) {
            return;
        }
        endIterator(node.left);
        endIterator(node.right);
        System.out.print(node.val + " ");
    }

    private static void midIterator(TreeNode node) {
        if (node == null) return;
        midIterator(node.left);
        System.out.print(node.val + " ");
        midIterator(node.right);
    }

    private static void firstIterator(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        firstIterator(node.left);
        firstIterator(node.right);
    }

    /**
     * 二叉树的非递归后序遍历,标准顺序为左->右->中
     *
     * @param node
     */
    private static void endIteratorWithoutRecursion(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> nodeStack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode cur = node;

    }

    /**
     * 二叉树的非递归中序遍历
     * 中序遍历的顺序为 左->中->右.
     * 当前只知道树的根节点,所以要先找到这个树最左侧的没有子树的叶子节点->他的父节点
     * @param node
     */
    private static void midIteratorWithoutRecursion(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> nodeStack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode cur = node;
        while(!nodeStack.isEmpty() || cur!=null){
            // 1.一直找到最左子叶子节点,并依次入栈
            while(cur!=null){
                nodeStack.push(cur);
                cur = cur.left;
            }
            // 2.叶子节点出栈
            TreeNode treeNode = nodeStack.pop();
            // 3.放入List
            list.add(treeNode.val);
            // 4.当叶子节点有兄弟节点时，其也要进行中序遍历。
            if(treeNode.right!=null){
                cur = treeNode.right;
            }

        }
        System.out.println();
        System.out.println("===========非递归中序遍历=========");
        System.out.println(list.toString());

    }

    /**
     * 二叉树的非递归前序遍历
     * 按照正常遍历逻辑,应当是 root->left->right
     * 但是在引入栈结构后,顺序应当为root->right->left
     * 利用栈的先入后出的特性
     * 拿到根节点后,将根节点先入栈
     * 再将根节点出栈,并取出栈的右左节点,先右后左的入栈,到下一次遍历栈的时候,栈里只有根节点的左节点与右节点,
     * 由于上一步选择先添加右节点,所以此时左侧先出栈,获取左侧的左右子树(按照先右后左的顺序)入栈,此时栈内有 1.根节点的右侧(栈底),2.根节点左侧的右子树 3.根节点右侧的左子树
     * 继续进行层级遍历,过程中按照顺序将数据加入到list当中
     * 当根节点左侧数据遍历完成后,才会轮到根节点右侧的数据出栈
     *
     * @param node
     */
    private static void firstIteratorWithoutRecursion(TreeNode node) {
        if (node == null) return;
        // 获取根节点
        Stack<TreeNode> nodeStack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        // 将root节点压入栈
        nodeStack.push(node);
        // 第一次是确定根节点入栈成功,开始遍历,并入栈
        while (!nodeStack.isEmpty()) {
            // 获取栈顶元素----第一次为根节点 ,先压入右节点,再压入左节点,栈的特性是先入后出,所以当根节点左侧全部遍历完成时,才开始遍历根节点右侧
            TreeNode pop = nodeStack.pop();
            // 出栈后,按照右中左的方式来入栈
            // 到下一次循环时遍历栈的左右节点下面的左右节点,此时数据已经加入了
            list.add(pop.val);
            if (pop.right != null) {
                nodeStack.push(pop.right);
            }
            if (pop.left != null) {
                nodeStack.push(pop.left);
            }
        }
        System.out.println();
        System.out.println("======非递归先序遍历======");
        System.out.println(list.toString());
    }
}
