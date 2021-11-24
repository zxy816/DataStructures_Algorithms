package com.zxy.hot100;

/**
 * 盛最多水的容器
 */
public class Day14 {
    public static void main(String[] args) {
        int[] height = new int[]{1,1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int flag = 0;
        while (l < r) {
            int maxArea = Math.min(height[l], height[r]) * (r - l);
            flag = Math.max(maxArea, flag);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return flag;
    }
}
