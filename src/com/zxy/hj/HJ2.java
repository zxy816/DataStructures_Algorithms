package com.zxy.hj;

import java.util.*;
import java.util.regex.Pattern;

public class HJ2 {
    public static void main(String[] args) {
        hj27();
    }

    /**
     * 兄弟单词
     */
    public static void hj27() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int num = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[strs.length - 1]);
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            String flag = strs[num + 1];
            String arr = strs[i];
            if (isBrother(arr, flag)) {
                list.add(arr);
            }
        }
        System.out.println(list.size());
        if (list.size() >= k) {
            Collections.sort(list);
            System.out.println(list.get(k - 1));
        }
    }

    private static boolean isBrother(String arr, String flag) {
        if (arr.length() != flag.length() || arr.equals(flag)) {
            return false;
        }
        char[] arrs = arr.toCharArray();
        char[] flags = flag.toCharArray();
        Arrays.sort(arrs);
        Arrays.sort(flags);
        return String.valueOf(arrs).equals(String.valueOf(flags));
    }

    /**
     * 字符串排序
     */
    public static void hj26() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                builder.append(str.charAt(i));
            }
        }
        char[] chars = builder.toString().toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                Character c1 = Character.toLowerCase(chars[j]);
                Character c2 = Character.toLowerCase(chars[j + 1]);
                if (c1 > c2) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        builder.setLength(0);
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                builder.append(chars[j]);
                j++;
            } else {
                builder.append(str.charAt(i));
            }
        }
        System.out.println(builder.toString());
    }

    /**
     * 合唱队 186 186 150 200 160 130 197 200
     * [1, 1, 1, 2, 2, 1, 3, 4]
     * [3, 3, 2, 3, 2, 1, 1, 1]
     */
    public static void hj24() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    left[i] = Math.max(left[j] + 1, left[i]);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] + right[i] - 1;
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(result[i], max);
        }
        System.out.println(n - max);
    }

    /**
     * 坐标移动
     */
    public static void hj17() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] arr = str.split(";");
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].matches("[ADWS][0-9]*")) {
                String flag = arr[i].substring(0, 1);
                Integer num = Integer.parseInt(arr[i].substring(1));
                if ("A".equals(flag)) {
                    x -= num;
                } else if ("D".equals(flag)) {
                    x += num;
                } else if ("W".equals(flag)) {
                    y += num;
                } else if ("S".equals(flag)) {
                    y -= num;
                }
            }
        }
        System.out.println(x + "," + y);
    }

    public static void hj18() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.length() <= 8 || !match(str) || !checkRepert(str, 0, 3)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    public static boolean match(String str) {
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if (p1.matcher(str).find()) {
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if (p2.matcher(str).find()) {
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if (p3.matcher(str).find()) {
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if (p4.matcher(str).find()) {
            count++;
        }
        if (count >= 3) {
            return true;
        }
        return false;
    }

    public static boolean checkRepert(String str, int start, int end) {
        if (end >= str.length()) {
            return true;
        }
        if (str.substring(end).contains(str.substring(start, end))) {
            return false;
        } else {
            return checkRepert(str, start + 1, end + 1);
        }
    }
}
