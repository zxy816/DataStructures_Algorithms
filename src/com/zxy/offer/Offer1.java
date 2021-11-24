package com.zxy.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer1 {
    public static void main(String[] args) {
        int[] num = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(num));
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    /**
     * 剑指 Offer 05. 替换空格
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     */
    public static String replaceSpace(String s) {
//        return s.replaceAll(" ", "%20");
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' '){
                buffer.append("%20");
            } else {
                buffer.append(c);
            }
        }
        return  buffer.toString();
    }

    /**
     * 剑指 Offer 03. 数组中重复的数字
     * 输入： [2, 3, 1, 0, 2, 5, 3]
     * 输出： 2 或 3
     */
    public static int findRepeatNumber(int[] nums) {
        int repeatNum = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                repeatNum = nums[i];
                break;
            }
        }
        return repeatNum;
    }
}
