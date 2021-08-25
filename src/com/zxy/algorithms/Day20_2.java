package com.zxy.algorithms;

import java.util.Arrays;

/**
 * 双指针
 */
public class Day20_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(sortedSquares(nums)));
        int k = 3;
        System.out.println(Arrays.toString(rotate(nums, k)));
    }

    /**
     * 有序数组的平方
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100
     */
    public static int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0, j = nums.length - 1, k = nums.length - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                arr[k] = nums[i] * nums[i];
                i++;
            } else {
                arr[k] = nums[j] * nums[j];
                j--;
            }
            k--;
        }
        return arr;
    }

    /**
     * 旋转数组
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     */
    public static int[] rotate(int[] nums, int k) {
        // nums.length > k else 0
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return nums;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
