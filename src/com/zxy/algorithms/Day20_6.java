package com.zxy.algorithms;

import java.util.Arrays;
import java.util.HashMap;

public class Day20_6 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println("---------------------------");
        String s1 = "ab", s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }

    /**
     * 无重复字符的最长子串
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
     * ----------------------
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)) + 1, left);
            }
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    /**
     * 字符串的排列
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * -----------------
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     */
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] index1 = new int[26];
        int[] index2 = new int[26];
        for (int i = 0; i < n; i++) {
            ++index1[s1.charAt(i) - 'a'];
            ++index2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(index1, index2)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            ++index2[s2.charAt(i) - 'a'];
            --index2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(index1, index2)) {
                return true;
            }
        }
        return false;
    }
}
