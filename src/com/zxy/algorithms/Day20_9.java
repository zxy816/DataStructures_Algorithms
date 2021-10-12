package com.zxy.algorithms;

public class Day20_9 {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("能获取的最大利润为：" + maxProfit(arr));
        int[] nums = new int[]{2, 2, 1};
        System.out.println("只出现一次的数字为：" + singleNumber(nums));
    }

    /**
     * 输入: [2,2,1]
     * 输出: 1
     * 输入: [4,1,2,1,2]
     * 输出: 4
     */
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    /**
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
