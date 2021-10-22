package com.zxy.hot100;

import java.util.Arrays;

public class Day3 {
    public static void main(String[] args) {
        int[] a1 = new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 7, 7, 7, 7};
        System.out.println(majorityElement(a1));
        System.out.println(majorityElement1(a1));
    }

    /**
     * 多数元素:指在数组中出现次数 大于 [ n/2 ]的元素
     * 输入：[3,2,3]
     * 输出：3
     * <p>
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     */
    public static int majorityElement(int[] nums) {
        int n = nums.length / 2;
        Arrays.sort(nums);
        return nums[n];
    }

    public static int majorityElement1(int[] nums) {
        int count = 0;
        Integer condition = null;
        for (int num : nums) {
            if (count == 0) {
                condition = num;
            }
            count += (num == condition) ? 1 : -1;
        }
        return condition;
    }
}
