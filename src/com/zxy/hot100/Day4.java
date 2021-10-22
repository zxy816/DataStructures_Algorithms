package com.zxy.hot100;

public class Day4 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        ListNode cur = reverseList(head);
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    /**
     * 回文链表
     * 输入：head = [1,2,2,1]
     * 输出：true
     * 输入：head = [1,2]
     * 输出：false
     */
    public static boolean isPalindrome(ListNode head) {

        return false;
    }


    /**
     * 反转链表
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     */
    public static ListNode reverseList(ListNode head) {
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = temp;
        }
        return curr;
    }

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
}
