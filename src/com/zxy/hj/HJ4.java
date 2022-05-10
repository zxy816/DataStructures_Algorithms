package com.zxy.hj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HJ4 {
    public static void main(String[] args) {
//        Hj43();
//        Hj67();
        Hj45();
    }

    /**
     * 名字的漂亮度-贪心
     */
    private static void Hj45() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scanner.next();
        }
        for (int i = 0; i < str.length; i++) {
            int[] count = new int[26];
            for (int j = 0; j < str[i].length(); j++) {
                count[str[i].charAt(j) - 'a']++;
            }
            Arrays.sort(count);
            int temp = 0;
            for (int j = 0; j < count.length; j++) {
                temp += (26 - j) * count[count.length - 1 - j];
            }
            System.out.println(temp);
        }
    }

    /**
     * 24点游戏算法
     */
    private static void Hj67() {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[4];
        int[] v = new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            v[i] = 1;
            if (dfs24(nums, v, nums[i])) {
                flag = true;
                break;
            }
        }
        System.out.println(flag);
    }

    private static boolean dfs24(int[] nums, int[] v, int temp) {
        for (int i = 0; i < nums.length; i++) {
            if (v[i] == 0) {
                v[i] = 1;
                if (dfs24(nums, v, temp + nums[i])
                        || dfs24(nums, v, temp - nums[i])
                        || dfs24(nums, v, temp * nums[i])
                        || dfs24(nums, v, temp / nums[i])) {
                    return true;
                }
                v[i] = 0;
            }
        }
        if (temp == 24) {
            return true;
        }
        return false;
    }

    /**
     * 迷宫问题
     */
    private static void Hj43() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        ArrayList<Pos> list = new ArrayList<>();
        //广度优先遍历
        dfs(nums, 0, 0, list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("(" + list.get(i).x + "," + list.get(i).y + ")");
        }
    }

    private static boolean dfs(int[][] nums, int x, int y, ArrayList<Pos> path) {
        path.add(new Pos(x, y));
        //标记已走的坐标
        nums[x][y] = 1;
        if (x == nums.length - 1 && y == nums[0].length - 1) {
            return true;
        }
        if (x + 1 < nums.length && nums[x + 1][y] == 0) {
            if (dfs(nums, x + 1, y, path)) {
                return true;
            }
        }
        if (y + 1 < nums[0].length && nums[x][y + 1] == 0) {
            if (dfs(nums, x, y + 1, path)) {
                return true;
            }
        }
        if (x - 1 > -1 && nums[x - 1][y] == 0) {
            if (dfs(nums, x - 1, y, path)) {
                return true;
            }
        }
        if (y - 1 > -1 && nums[x][y - 1] == 0) {
            if (dfs(nums, x, y - 1, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        nums[x][y] = 0;
        return false;
    }

    public static class Pos {
        private int x;
        private int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
