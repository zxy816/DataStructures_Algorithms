package com.zxy.offer;

import java.util.HashMap;
import java.util.List;

public class Offer11 {
    public static void main(String[] args) {


    }

    /**
     * 两数相加
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//    }

    /**
     * 链表中倒数第k个节点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 删除链表的节点
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode preNode = head;
        ListNode curNode = head.next;
        while (curNode != null && curNode.val != val) {
            preNode = curNode;
            curNode = curNode.next;
        }
        if (curNode != null) {
            preNode.next = curNode.next;
        }
        return head;
    }

    /**
     * 最长不含重复字符的子字符串
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
     * 输入: "abbabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int index = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                index = Math.max(index, hashMap.get(c));
            }
            hashMap.put(c, i);
            max = Math.max(max, i - index);
        }
        return max;
    }

    /**
     * 把数字翻译成字符串
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < str.length(); i++) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String sub = str.substring(i - 1, i + 1);
            if (sub.compareTo("25") <= 0 && sub.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public class ListNode {
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
