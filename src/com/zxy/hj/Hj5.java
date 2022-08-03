package com.zxy.hj;

import java.util.Scanner;
import java.util.Stack;

public class Hj5 {
    private static ListNode headNode;

    public static void main(String[] args) {
//        Hj48();
//        Hj50();
//        Hj52();
//        Hj55();
        Hj57();
    }

    /**
     * 高精度整数加法
     * 9876543210
     * 1234567890
     */
    private static void Hj57() {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        StringBuilder builder = new StringBuilder();
        int n = str1.length() - 1;
        int m = str2.length() - 1;
        int carry = 0;
        while (n >= 0 || m >= 0) {
            char ch1 = n >= 0 ? str1.charAt(n--) : '0';
            char ch2 = m >= 0 ? str2.charAt(m--) : '0';
            int add = (ch1 - '0') + (ch2 - '0') + carry;
            builder.append(add % 10);
            carry = add / 10;
        }
        if (carry == 1) {
            builder.append(carry);
        }
        System.out.println(builder.reverse().toString());
    }

    private static void Hj55() {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (i == 7 || String.valueOf(i).contains("7") || i % 7 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void Hj52() {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int n = s1.length();
        int m = s2.length();
        int distance = 0;
        if (n * m == 0) {
            distance = n + m;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int dis1 = dp[i][j - 1] + 1;
                int dis2 = dp[i - 1][j] + 1;
                int dis = dp[i - 1][j - 1];
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    dis = dis + 1;
                }
                dp[i][j] = Math.min(dis, Math.min(dis1, dis2));
            }
        }
        distance = dp[n][m];
        System.out.println(distance);
    }

    /**
     * 四则运算
     * 3+2*{1+2*[-4/(8-6)+7]}
     */
    private static void Hj50() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        input = input.replace("{", "(");
        input = input.replace("[", "(");
        input = input.replace("}", ")");
        input = input.replace("]", ")");
        System.out.println(solution(input));
    }

    private static int solution(String input) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = input.toCharArray();
        int n = input.length();
        int number = 0;
        char sign = '+';
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (Character.isDigit(ch)) {
                number = number * 10 + ch - '0';
                //5 3 9 6 6 1 10 2
                System.out.print(number + " ");
            }
            if (ch == '(') {
                int j = i + 1;
                int count = 1;
                while (count > 0) {
                    if (chars[j] == ')') count--;
                    if (chars[j] == '(') count++;
                    j++;
                }
                number = solution(input.substring(i + 1, j - 1));
                i = j - 1;
            }
            if (!Character.isDigit(ch) || i == n - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-1 * number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                sign = ch;
                number = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public Hj5(int val) {
        headNode = new ListNode(val);
    }

    public static ListNode getHeadNode() {
        return headNode;
    }

    /**
     * 从单向链表中删除指定值的节点
     * 5 2 3 2 4 3 5 2 1 4 3
     * 2->5->3->4->1
     */
    private static void Hj48() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int headVal = scanner.nextInt();
        Hj5 hj5 = new Hj5(headVal);
        for (int i = 1; i < n; i++) {
            int val = scanner.nextInt();
            int node = scanner.nextInt();
            hj5.insertNode(val, node);
        }
        int del = scanner.nextInt();
        hj5.deleteNode(del);
        ListNode p = hj5.getHeadNode();
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }

    }

    private static void deleteNode(int del) {
        ListNode temp = new ListNode(0, headNode);
        ListNode p = temp;
        while (p.next != null && p.next.value != del) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        headNode = temp.next;
    }

    private static void insertNode(int val, int node) {
        ListNode temp = headNode;
        while (temp.value != node) {
            temp = temp.next;
        }
        ListNode insertNode = new ListNode(val, temp.next);
        temp.next = insertNode;
    }

    public static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
