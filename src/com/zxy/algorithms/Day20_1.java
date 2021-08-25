package com.zxy.algorithms;

public class Day20_1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 2;
        System.out.println(search(nums, target));
        System.out.println(searchInsert(nums, target));
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * ----------------------------
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     */

    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 用时：1ms
     */
    public static int search(int[] nums, int target) {
        int prov, low = 0, high = nums.length - 1;
        while (low <= high) {
            prov = low + (high - low) / 2;
            if (nums[prov] == target) {
                return prov;
            } else if (target < nums[prov]) {
                high = prov - 1;
            } else {
                low = prov + 1;
            }
        }
        return -1;
    }

    /**
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 用时：1ms
     */
    public static int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
