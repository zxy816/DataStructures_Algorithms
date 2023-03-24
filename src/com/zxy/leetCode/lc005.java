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
//        lc799();
//        lc316();
//        lc392();
//        lc221();
//        lc62();
//        lc146();
        lc70();
    }

    private static void lc70() {
        int n = 5;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }

    private static void lc146() {
        String[][] board = new String[][]{{"X", "X", "X", "X"}, {"X", "O", "O", "X"}, {"X", "X", "O", "X"}, {"X", "O", "X", "X"}};
        System.out.println(Arrays.deepToString(board));
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == "O") {
                    dfs146(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == "O") {
                    board[i][j] = "X";
                }
                if (board[i][j] == "#") {
                    board[i][j] = "O";
                }
            }
        }
        System.out.println(Arrays.deepToString(board));
    }

    private static void dfs146(String[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == "X" || board[i][j] == "#") {
            return;
        }
        board[i][j] = "#";
        dfs146(board, i - 1, j);
        dfs146(board, i + 1, j);
        dfs146(board, i, j - 1);
        dfs146(board, i, j + 1);
    }

    private static void lc62() {
        int m = 3, n = 7;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }

    private static void lc221() {
        String[][] matrix = new String[][]{{"1", "0", "1", "0", "0"}, {"1", "0", "1", "1", "1"}, {"1", "1", "1", "1", "1"}, {"1", "0", "0", "1", "0"}};
        int maxSide = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == "1") {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        System.out.println(maxSide * maxSide);
    }

    private static void lc392() {
        String s = "abc", t = "ahbgdc";
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        System.out.println(i == s.length());
    }

    private static void lc316() {
        String s = "cbacdcbc";
        boolean[] used = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!used[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        used[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                used[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;

        }
        System.out.println(sb.toString());
    }

    private static void lc799() {
        int poured = 2, query_row = 1, query_glass = 1;
        double[] row = new double[]{poured};
        for (int i = 1; i <= query_row; i++) {
            double[] nextRow = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double v = row[j];
                if (v > 1) {
                    nextRow[j] += (v - 1) / 2;
                    nextRow[j + 1] += (v - 1) / 2;
                }
            }
            row = nextRow;
        }
        System.out.println(Math.min(1, row[query_glass]));
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
