package com.zxy.hot100;

public class Day2 {
    public static void main(String[] args) {
        ListNode nodeA = new ListNode(0);
        ListNode nodeA_1 = new ListNode(9);
        ListNode nodeA_2 = new ListNode(1);
        ListNode nodeA_3 = new ListNode(2);
        ListNode nodeA_4 = new ListNode(4);
        nodeA.next = nodeA_1;
        nodeA_1.next = nodeA_2;
        nodeA_2.next = nodeA_3;
        nodeA_3.next = nodeA_4;
        nodeA_4.next = null;

        ListNode nodeB = new ListNode(3);
        nodeB.next = nodeA_3;
        nodeA_3.next = nodeA_4;
        nodeA_4.next = null;
        System.out.println("=========" + getIntersectionNode(nodeA, nodeB));
    }

    /**
     * 相交链表
     * listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nA = headA;
        ListNode nB = headB;
        while (nA != nB) {
            nA = nA == null ? headB : nA.next;
            nB = nB == null ? headA : nB.next;
        }
        return nA;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
