package com.zxy.offer;

import java.util.ArrayList;
import java.util.List;

public class Offer10 {
    public static void main(String[] args) {

    }

    /**
     * 礼物的最大价值
     */
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 1; i < column; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int j = 1; j < row; j++) {
            grid[j][0] += grid[j - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][column - 1];
    }

    /**
     * 连续子数组的最大和
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        int maxValue = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }

    /**
     * 回文链表
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curNode = head;
        while (curNode != null) {
            list.add(curNode.val);
            curNode = curNode.next;
        }
        int first = 0;
        int back = list.size() - 1;
        while (first < back) {
            if (list.get(first) != list.get(back)) {
                return false;
            }
            first++;
            back--;
        }
        return true;
    }

    /**
     * 奇偶链表
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * 股票的最大利润
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 输入: [7,6,4,3,1]
     * 输出: 0
     */
    public int maxProfit(int[] prices) {
        int minPrices = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int curPrices = prices[i];
            if (curPrices < minPrices) {
                minPrices = curPrices;
            } else if (curPrices - minPrices > maxProfit) {
                maxProfit = curPrices - minPrices;
            }
        }
        return maxProfit;
    }

    /**
     * 移除链表元素
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     * 输入：head = [], val = 1
     * 输出：[]
     * 输入：head = [7,7,7,7], val = 7
     * 输出：[]
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode temp = node;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return node.next;
    }

    /**
     * 反转链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
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
