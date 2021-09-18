package com.zxy.effic;

import java.util.Arrays;

public class Section4 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println("------------------------");
        int[] partition = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(partition));
        System.out.println("------------------------");
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
     * <p>
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    /**
     * 输入：nums = [1,5,11,5]
     * 输出：true --- [1, 5, 5] 和 [11]
     * ----------------
     * 输入：nums = [1,2,3,5]
     * 输出：false
     */
    public static boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(nums[i], max);
        }
        int target = sum / 2;
        if (sum % 2 != 0) {
            return false;
        }
        if (max > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; --j) {
                dp[j] = dp[j - nums[i]] | dp[j];
            }
        }
        return dp[target];
    }

    /**
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     */
    public static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount];
        return findWay(coins, amount, memo);
    }

    private static int findWay(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount - coins[i], memo);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }
}
