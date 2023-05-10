package com.zxy.leetCode;


import java.util.*;

public class lc006 {
    public static void main(String[] args) {
//        lc151();
//        lc518();
//        System.out.println(lc139());
//        System.out.println(lc859());
//        System.out.println(offer45());
//        lc46();
//        lc47();
//        lc39();
//        lc40();
//        lc78();
//        lc90();
        lc860();
    }

    /**
     * 子集
     */
    private static List<List<Integer>> lc78() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs78(nums, result, list, 0);
        return result;
    }

    private static void dfs78(int[] nums, List<List<Integer>> result, List<Integer> list, int depth) {
        result.add(new ArrayList<>(list));
        for (int i = depth; i < nums.length; i++) {
            if (i > depth && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs78(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 子集 II
     */
    private static List<List<Integer>> lc90() {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs90(nums, result, list, 0);
        return result;
    }

    private static void dfs90(int[] nums, List<List<Integer>> result, List<Integer> list, int depth) {
        result.add(new ArrayList<>(list));
        for (int i = depth; i < nums.length; i++) {
            if (i > depth && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs90(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 柠檬水找零
     */
    private static boolean lc860() {
        int[] bills = new int[]{5, 5, 5, 10, 20};
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                ten++;
                five--;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<List<Integer>> lc40() {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        int len = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>(len);
        dfs40(candidates, result, list, target, 0, len);
        return result;

    }

    private static void dfs40(int[] candidates, List<List<Integer>> result, List<Integer> list, int target, int depth, int len) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = depth; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > depth && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            dfs40(candidates, result, list, target - candidates[i], i + 1, len);
            list.remove(list.size() - 1);
        }
    }

    private static List<List<Integer>> lc39() {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        int len = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>(len);
        dfs39(candidates, result, list, target, 0, len);
        return result;
    }

    private static void dfs39(int[] candidates, List<List<Integer>> result, List<Integer> list, int target, int depth, int len) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = depth; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
            dfs39(candidates, result, list, target - candidates[i], i, len);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 全排列
     */
    private static List<List<Integer>> lc46() {
        int[] nums = new int[]{1, 2, 3};
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>(len);
        boolean[] used = new boolean[len];
        dfs46(nums, result, list, 0, len, used);
        return result;
    }

    private static void dfs46(int[] nums, List<List<Integer>> result, List<Integer> list, int depth, int len, boolean[] used) {
        if (depth == len) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                dfs46(nums, result, list, depth + 1, len, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 全排列 II
     */
    private static List<List<Integer>> lc47() {
        int[] nums = new int[]{1, 1, 3};
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>(len);
        boolean[] used = new boolean[len];
        dfs47(nums, result, list, 0, len, used);
        return result;
    }

    private static void dfs47(int[] nums, List<List<Integer>> result, List<Integer> list, int depth, int len, boolean[] used) {
        if (depth == len) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                used[i] = true;
                dfs46(nums, result, list, depth + 1, len, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     */
    private static String offer45() {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        String[] num = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(num, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num.length; i++) {
            sb.append(num[i]);
        }
        return sb.toString();
    }

    private static boolean lc859() {
        String s = "ab";
        String goal = "ab";
        if (s.length() != goal.length()) {
            return false;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int sIndex = s.charAt(i) - 'a';
            int gIndex = goal.charAt(i) - 'a';
            cnt1[sIndex]++;
            cnt2[gIndex]++;
            if (sIndex != gIndex) sum++;
        }
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
            if (cnt1[i] > 1) {
                flag = true;
            }
        }
        return sum == 2 || (sum == 0 && flag);
    }

    private static boolean lc139() {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                int len = wordDict.get(j).length();
                if (i >= len && dp[i - len] && wordDict.get(j).equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private static void lc518() {
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
                //coin = 1----[1,1,1,1,1,1]
                //coin = 2----[1,1,2,2,3,3]
                //coin = 5----[1,1,2,2,3,4]
            }
        }
        System.out.println(dp[amount]);
    }

    private static void lc151() {
        String s = "a good   example";
        String[] strings = s.split("\\s+");
        List<String> list = Arrays.asList(strings);
        Collections.reverse(list);
        System.out.println(String.join(" ", list).trim());
    }
}
