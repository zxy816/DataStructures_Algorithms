package com.zxy.offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Offer2 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = null;
        System.out.println(Arrays.toString(reversePrint(listNode)));

    }

    /**
     * 剑指 Offer 09. 用两个栈实现队列
     */
    class CQueue {
        Deque<Integer> deque1;
        Deque<Integer> deque2;

        public CQueue() {
            deque1 = new LinkedList<>();
            deque2 = new LinkedList<>();
        }

        /**
         * 队列尾部插入整数
         */
        public void appendTail(int value) {
            deque1.push(value);
        }

        /**
         * 队列头部删除整数
         */
        public int deleteHead() {
            if (deque2.isEmpty()) {
                while (!deque1.isEmpty()) {
                    deque2.push(deque1.pop());
                }
            }
            if (deque2.isEmpty()) {
                return -1;
            } else {
                int deleteItem = deque2.pop();
                return deleteItem;
            }
        }
    }

    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     */
    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        int size = stack.size();
        int[] num = new int[size];
        for (int i = 0; i < size; i++) {
            num[i] = stack.pop();
        }
        return num;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
