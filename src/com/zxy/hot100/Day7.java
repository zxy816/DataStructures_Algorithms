package com.zxy.hot100;

import java.util.*;

public class Day7 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        System.out.println(Arrays.asList(findDisappearedNumbers(nums)));
    }

    /**
     * 找到所有数组中消失的数字
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        System.out.println(Arrays.toString(nums));
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length + 1; i++) {
            if (hashMap.get(i) == null) {
                list.add(i);
            }
        }
        return list;
    }
}
