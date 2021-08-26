package com.zxy.algorithms;

import java.util.Arrays;

public class Day20_4 {
    public static void main(String[] args) {
        char[] nums = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(nums);
        System.out.println(Arrays.toString(nums));
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    /**
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     */
    public static void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            reverse(s, l, r);
            l++;
            r--;
        }
    }

    public static void reverse(char[] s, int start, int end) {
        char temp = s[end];
        s[end] = s[start];
        s[start] = temp;
    }

    /**
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     */
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length;
        while (l < r) {
            int start = l;
            while (l < r && s.charAt(l) != ' ') {
                l++;
            }
            int end = l - 1;
            while (start < end) {
                reverse(chars, start, end);
                start++;
                end--;
            }
            l++;
        }
        return new String(chars);
    }


}
