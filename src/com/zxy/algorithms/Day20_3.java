package com.zxy.algorithms;

import java.util.Arrays;

public class Day20_3 {
    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 移动零
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */
    public static void moveZeroes(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
            r++;
        }
    }
}
