package com.zxy.effic;

import java.util.*;

public class Section5 {
    public static void main(String[] args) {
        //有效的括号
        String s = "()[]{}";
        System.out.println(isValid(s));
        //下一个更大元素 I
        int[] num1 = new int[]{4, 1, 2};
        int[] num2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(num1, num2)));
        System.out.println(Arrays.toString(nextGreaterElement1(num1, num2)));
        //132 模式
        int[] num132 = new int[]{-1, 3, 2, 0};
        System.out.println(find132pattern(num132));
    }

    /**
     * 输入：nums = [1,2,3,4]
     * 输出：false
     * 解释：序列中不存在 132 模式的子序列
     * --------------------------------
     * 输入：nums = [-1,3,2,0]
     * 输出：true
     * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0]
     */
    public static boolean find132pattern(int[] nums) {
        Deque stack = new ArrayDeque();
        int k = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {

        }
        return false;
    }

    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peekLast()) {
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    /**
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if (nums1.length < 1) {
            return res;
        }
        for (int i = 0; i < nums1.length; i++) {
            int cur = nums1[i];
            int j = 0;
            while (j < nums2.length && cur != nums2[j]) {
                j++;
            }
            j++;
            while (j < nums2.length && cur > nums2[j]) {
                j++;
            }
            if (j == nums2.length) {
                res[i] = -1;
                continue;
            }
            res[i] = nums2[j];
        }
        return res;
    }

    /**
     * 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
     * 输入：s = "()[]{}"
     * 输出：true
     * 输入：s = "([)]"
     * 输出：false
     */
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char chars = s.charAt(i);
            if (map.containsKey(chars)) {
                if (stack.isEmpty() || stack.peek() != map.get(chars)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(chars);
            }
        }
        return stack.isEmpty();
    }
}
