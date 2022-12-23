package com.example.simplespringboottest.prac.first.leetcode;

public class ListNodeTest {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        listNode.next.next.next.next.next.next.next = new ListNode(8);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(3);
        listNode2.next.next.next = new ListNode(4);
        listNode2.next.next.next.next = new ListNode(5);
        listNode2.next.next.next.next.next = new ListNode(6);

        // 遍历链表
        ListNode node = listNode;
        while(node.next!=null){
            System.out.println(node.val);
            node = node.next;
        }
        // 设置头节点
        ListNode head = new ListNode();
        head.next = listNode;
        System.out.println("head:"+head.val);


    }
}
