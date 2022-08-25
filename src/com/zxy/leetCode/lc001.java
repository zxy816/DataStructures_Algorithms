package com.zxy.leetCode;

import java.util.*;

/**
 * 数组和字符串
 */
public class lc001 {

    public static void main(String[] args) {
//        threeSum();
        int[] nums = new int[]{2, 1, 5, 5, 4, 6};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int min = nums[0];
        int mid = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > mid) {
                return true;
            } else if (num > min) {
                mid = num;
            } else {
                min = num;
            }
        }
        return false;
    }

    /**
     * 最长回文子串
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) != s.charAt(r)) {
                    dp[l][r] = false;
                } else {
                    if (r - l <= 2) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                }

                if (dp[l][r] && r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    start = l;
                }
            }
        }
        return s.substring(start, maxLen + start);
    }

    /**
     * 无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                j = Math.max(j, hashMap.get(c) + 1);
            }
            hashMap.put(c, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }


    /**
     * 字母异位词分组
     *
     * @param strs ["eat", "tea", "tan", "ate", "nat", "bat"]
     * @return [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return lists;
        }
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<>();
            String temp = strs[i];
            char[] c = temp.toCharArray();
            Arrays.sort(c);
            String str = String.valueOf(c);
            if (hashMap.containsKey(str)) {
                hashMap.get(str).add(temp);
            } else {
                list.add(temp);
                hashMap.put(str, list);
            }
        }
        return new ArrayList<>(hashMap.values());
    }

    /**
     * 矩阵置零
     *
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * -1,0,1,2,-1,-4 |  -2,0,1,1,2 | 0,0,0,0,0
     */
    public static List<List<Integer>> threeSum() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int target = -nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            List<Integer> list1 = list.get(i);
            System.out.println(Arrays.toString(list1.stream().mapToInt(Integer::valueOf).toArray()));
        }
        return list;
    }
}
