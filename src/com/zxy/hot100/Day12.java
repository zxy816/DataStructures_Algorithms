package com.zxy.hot100;

public class Day12 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(3);
        l1.next = l1_1;
        l1_1.next = l1_2;
        ListNode l2 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(4);
        l2.next = l2_1;
        l2_1.next = l2_2;
        ListNode resultNode = addTwoNumbers(l1, l2);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode cur = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carry;
            if (result == null){
                result = cur = new ListNode(sum % 10);
            } else {
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return result;
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
