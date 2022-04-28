package com.zxy.offer;

import java.util.HashMap;

public class Offer11 {
    public static void main(String[] argoods) {

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
     * 和为s的两个数字
     */
    public int[] twoSum(int[] nums, int target) {

        return nums;
    }

    /**
     * 调整数组顺序使奇数位于偶数前面
     */
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int temp = 0;
        while (i != j) {
            while (i < j && (nums[i] & 1) == 1) {
                i++;
            }
            while (i < j && (nums[i] & 1) == 0) {
                j--;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * 两个链表的第一个公共节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (headA != headB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }


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


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode(-1);
        ListNode listNode = preNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        listNode.next = l1 == null ? l2 : l1;
        return preNode.next;
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
