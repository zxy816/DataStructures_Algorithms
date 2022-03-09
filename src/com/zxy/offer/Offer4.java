package com.zxy.offer;

import java.util.*;

public class Offer4 {
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
//        char[] arr = "ABCDEFGHHA".toCharArray();
//        arrangement(arr, 0, arr.length - 1);
//        System.out.println(result.size());

//        Set<String> res = new HashSet<>();
//        String str = "ABCDEFGHHA";
//        combination(res, str, new StringBuilder(), new boolean[str.length()]);
//        res.toArray(new String[res.size()]);
//        System.out.println(res.size());

//        maxPeople();

        divideCandy();
    }



    /**
     * 分糖果
     */
    public static void divideCandy() {
        Scanner scanner = new Scanner(System.in);
        int candyNum = scanner.nextInt();
        int sumKoko = 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < candyNum; i++) {
            int weightCandy = scanner.nextInt();
            sum += weightCandy;
            sumKoko ^= weightCandy;
            min = Math.min(min, weightCandy);
        }
        if (sumKoko != 0) {
            System.out.println("NO");
        } else {
            System.out.println(sum - min);
        }
        scanner.close();
    }

    /**
     * 最多团队
     * 5
     * 3 1 5 7 9
     * 8
     * 第一行数组代表总人数，范围[1,500000]
     * 第二行数组代表每个人的能力，每个元素的取值范围[1, 500000]，数组的大小范围[1,500000]
     * 第三行数值为团队要求的最低能力值，范围[1, 500000]
     */
    public static void maxPeople() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int res = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;
        while (nums[right] > target) {
            res++;
            right--;
        }
        while (left < right) {
            if (nums[left] + nums[right] >= target) {
                res++;
                right--;
            }
            left++;
        }
        System.out.println(res);
        scanner.close();
    }


    private static void combination(Set<String> res, String str, StringBuilder sb, boolean[] marked) {
        if (sb.length() == str.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!marked[i]) {
                marked[i] = true;
                sb.append(str.charAt(i));
                combination(res, str, sb, marked);
                sb.deleteCharAt(sb.length() - 1);
                marked[i] = false;
            }
        }
    }


    public static void arrangement(char[] array, int start, int end) {
        if (array == null || start > end) {
            return;
        }
        if (start == end) {
            String str = String.valueOf(array);
            if (!result.contains(str)) {
                result.add(str);
            }
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(array, start, i);
            arrangement(array, start + 1, end);
            swap(array, start, i);
        }
    }

    public static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
