package com.zxy.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Offer8 {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 5, 6, 4};
//        System.out.println(findKthLargest(nums, 2));
        //2.左旋转字符串
//        System.out.println(reverseLeftWords("abcdefg", 2));
        //3.
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        System.out.println(search(nums, 8));
        //4.
//        int[] nums = {0};
//        System.out.println(missingNumber(nums));

        System.out.println(firstUniqChar("leetcode"));
    }

    /**
     * 第一个只出现一次的字符
     * 输入：s = "abaccdeff"
     * 输出：'b'
     * 输入：s = ""
     * 输出：' '
     */
    public static char firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, -1);
            } else {
                hashMap.put(ch, i);
            }
        }
        int index = s.length();
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            int n = entry.getValue();
            if (n != -1 && n< index) {
                index = n;
            }
        }
        return index == s.length() ? ' ' : s.charAt(index);
    }

    /**
     * 旋转数组的最小数字
     * 输入：numbers = [3,4,5,6,7,8,9,1,2]
     * 输出：1
     */
    public int minArray(int[] numbers) {
        int minIndex = 0;
        int maxIndex = numbers.length - 1;
        while (minIndex < maxIndex) {
            int middle = minIndex + (maxIndex - minIndex) / 2;
            if (numbers[middle] < numbers[maxIndex]) {
                maxIndex = middle;
            } else if (numbers[middle] > numbers[maxIndex]) {
                minIndex = middle + 1;
            } else {
                maxIndex -= 1;
            }
        }
        return numbers[minIndex];
    }

    /**
     * 二维数组中的查找
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    /**
     * 0～n-1中缺失的数字
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字
     * 输入: [0,1,3]
     * 输出: 2
     */
    public static int missingNumber(int[] nums) {
        if (nums[0] == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 统计一个数字在排序数组中出现的次数
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     */
    public static int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * 左旋转字符串
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     */
    public static String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            builder.append(s.charAt(i % s.length()));
        }
        return builder.toString();
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
