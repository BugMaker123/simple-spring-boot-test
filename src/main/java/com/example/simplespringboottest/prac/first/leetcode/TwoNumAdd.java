package com.example.simplespringboottest.prac.first.leetcode;

public class TwoNumAdd {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int s1 = getSize(l1);
        int s2 = getSize(l2);
        ListNode temp = null;
        boolean flag = s1-s2>0 ? true:false;
        if (!flag){
            temp = l1;
            l1=l2;
            l2 = temp;
        }
        ListNode pre1 = null;
        ListNode pre2 = null;
        pre1.next = l1;
        pre2.next = l2;
        while(pre1.next!=null){
            if (pre2.next!=null) {
                l1.val = l1.val + l2.val;
            }

        }
        return new ListNode();
    }
    public static void main(String[] args) {

    }

    static int getSize(ListNode listNode){
        int count = 0;
        ListNode pre = null;
        pre.next=listNode;
        while(listNode.next!=null){
            pre = pre.next.next;
            count++;
        }
        return count;
    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
