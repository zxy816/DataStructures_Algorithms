package com.zxy.leetCode;

import java.util.*;

public class lc005 {
    public static void main(String[] args) {
//        lc55();
//        lc621();
//        lc1047();
//        lc14();
//        lc300();
//        lc56();
//        lc200();
//        lc11();
        lc799();
    }

    private static void lc799() {

    }

    private static void lc11() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(maxArea);
    }

    private static void lc200() {
        String[][] grid = {
                {"1", "1", "0", "0", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "1", "0", "0"},
                {"0", "0", "0", "1", "1"}
        };
        int islandNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == "1") {
                    islandNum++;
                    dfsLand(grid, i, j);
                }
            }
        }
        System.out.println(islandNum);
    }

    private static void dfsLand(String[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) {
            return;
        }
        grid[i][j] = "2";
        dfsLand(grid, i - 1, j);
        dfsLand(grid, i + 1, j);
        dfsLand(grid, i, j - 1);
        dfsLand(grid, i, j + 1);
    }

    static boolean inArea(String[][] grid, int i, int j) {
        return 0 <= i && i < grid.length
                && 0 <= j && j < grid[0].length && grid[i][j] == "1";
    }

    private static void lc56() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (list.size() == 0 || left > list.get(list.size() - 1)[1]) {
                list.add(new int[]{left, right});
            } else {
                list.get(list.size() - 1)[1] = Math.max(right, list.get(list.size() - 1)[1]);
            }
        }

        for (int[] a : list) {
            System.out.print(Arrays.toString(a) + " ");
        }
    }

    private static void lc300() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        if (nums.length == 0) {
            return;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(dp[i], maxAns);
        }
        System.out.println(maxAns);
    }

    private static void lc14() {
        String[] strs = new String[]{"flower", "flow", "flight"};
        if (strs == null || strs.length == 0) {
            System.out.println("");
            return;
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = findPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        System.out.println(prefix);
    }

    private static String findPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    private static void lc1047() {
        String s = "abbaca";
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!deque.isEmpty() && deque.peek() == c) {
                deque.pop();
            } else {
                deque.push(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!deque.isEmpty()) {
            sb.insert(0, deque.pop());
        }
        System.out.println(sb.toString());
    }

    private static void lc621() {
        char[] chars = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int[] arr = new int[26];
        for (char c : chars) {
            arr[c - 'A']++;
        }
        System.out.println(Arrays.toString(arr));
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, arr[i]);
        }
        int ans = (max - 1) * (n + 1);
        for (int i = 0; i < 26; i++) {
            if (arr[i] == max) {
                ans++;
            }
        }
        ans = Math.max(ans, chars.length);
        System.out.println(ans);
    }

    private static void lc55() {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        int maxLocation = 0;
        boolean canJump = false;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxLocation) {
                maxLocation = Math.max(maxLocation, i + nums[i]);
                if (maxLocation >= nums.length - 1) {
                    canJump = true;
                }
            }
        }
        System.out.println(canJump);
    }

}
