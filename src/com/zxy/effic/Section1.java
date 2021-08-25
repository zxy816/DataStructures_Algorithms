package com.zxy.effic;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 */
public class Section1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 8};
        int target = 6;
        //* 解法1
        System.out.println(Arrays.toString(twoSum(nums, target)));
        //解法2
        System.out.println(Arrays.toString(twoSum2(nums, target)));

        //第二题  *解法1
        System.out.println(Arrays.toString(twoSum1_1(nums, target)));
        //解法2
        System.out.println(Arrays.toString(twoSum1_2(nums, target)));
    }

    /**
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
     * 用时：40ms
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }

    /**
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
     * 用时：1ms
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    /**
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2
     * 用时：2s
     */
    public static int[] twoSum1_1(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{0, 0};
    }

    /**
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2
     * 用时：1s
     */
    public static int[] twoSum1_2(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                high--;
            }
        }
        return new int[]{0, 0};
    }
}
