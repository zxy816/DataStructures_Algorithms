package com.zxy.hj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class HJ3 {
    public static void main(String[] args) {
//        Hj29();
//        Hj32();
//        Hj33();
//        Hj36();
//        Hj38();
        Hj41();
    }

    /**
     * 称砝码
     * 3
     * 108 29 185
     * 5 2 1
     */
    private static void Hj41() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] type = new int[n];
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            type[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        HashSet<Integer> set = new HashSet();
        set.add(0);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList(set);
            for (int j = 1; j <= num[i]; j++) {
                for (int k = 0; k < list.size(); k++) {
                    set.add(list.get(k) + type[i] * j);
                }
            }
        }
        System.out.println(set.size());
    }

    /**
     * 求小球落地5次后所经历的路程和第5次反弹的高度
     */
    private static void Hj38() {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        double[] dis = new double[6];
        dis[0] = h;
        double sum = 0;
        for (int i = 1; i < dis.length; i++) {
            dis[i] = dis[i - 1] / 2.0;
        }
        //[1.0, 0.5, (0.5) 0.25, (0.25) 0.125, (0.125) 0.0625, (0.0625) 0.03125]
        for (int i = 0; i < dis.length - 1; i++) {
            if (i == 0) {
                sum += dis[i];
            } else {
                sum += dis[i] * 2;
            }
        }
        System.out.println(sum);
        System.out.println(dis[5]);
    }

    /**
     * 字符串加密
     */
    private static void Hj36() {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine().toLowerCase();
        String word = scanner.nextLine().toLowerCase();
        ArrayList list = new ArrayList();
        for (int i = 0; i < key.length(); i++) {
            if (!list.contains(key.charAt(i))) {
                list.add(key.charAt(i));
            }
        }
        for (int i = 97; i <= 122; i++) {
            char c = (char) i;
            if (!list.contains(c)) {
                list.add(c);
            }
        }
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            result += list.get(word.charAt(i) - 97);
        }
        System.out.println(result);
    }

    /**
     * 整数与IP地址间的转换
     */
    private static void Hj33() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        long sec = scanner.nextLong();
        String[] strs = str.split("\\.");
        String result = "";
        //10->2
        for (int i = 0; i < strs.length; i++) {
            String binary = Integer.toBinaryString(Integer.parseInt(strs[i]));
            result += String.format("%08d", Integer.parseInt(binary));
        }
        //2->10
        System.out.println(Long.valueOf(result, 2));
        String secStr = Long.toBinaryString(sec);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32 - secStr.length(); i++) {
            sb.append(0);
        }
        sb.append(secStr);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            builder.append(Integer.valueOf(sb.substring(i * 8, (i + 1) * 8), 2));
            if (i != 3) {
                builder.append(".");
            }
        }
        System.out.println(builder.toString());
    }

    /**
     * 密码截取  12 HHHH A
     */
    private static void Hj32() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = str.length();
        int res = 0;
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = (str.charAt(i) == str.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]));
                if (dp[i][j]) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        System.out.println(res);
    }

    /**
     * 字符串加解密
     */
    private static void Hj29() {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(encode(str1));
        System.out.println(decode(str2));
    }

    /**
     * 解析
     */
    private static String decode(String str2) {
        char[] ch = str2.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] > 'a' && ch[i] <= 'z') {
                ch[i] = (char) (ch[i] - 'a' + 'A' - 1);
            } else if (ch[i] == 'a') {
                ch[i] = 'Z';
            } else if (ch[i] > 'A' && ch[i] <= 'Z') {
                ch[i] = (char) (ch[i] - 'A' + 'a' - 1);
            } else if (ch[i] == 'A') {
                ch[i] = 'z';
            } else if (ch[i] > '0' && ch[i] <= '9') {
                ch[i] = (char) (ch[i] - 1);
            } else if (ch[i] == '0') {
                ch[i] = '9';
            }
        }
        return String.valueOf(ch);
    }


    /**
     * 加密
     */
    private static String encode(String str1) {
        char[] ch = str1.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'a' && ch[i] < 'z') {
                ch[i] = (char) (ch[i] - 'a' + 'A' + 1);
            } else if (ch[i] == 'z') {
                ch[i] = 'A';
            } else if (ch[i] >= 'A' && ch[i] < 'Z') {
                ch[i] = (char) (ch[i] - 'A' + 'a' + 1);
            } else if (ch[i] == 'Z') {
                ch[i] = 'a';
            } else if (ch[i] >= '0' && ch[i] < '9') {
                ch[i] = (char) (ch[i] + 1);
            } else if (ch[i] == '9') {
                ch[i] = '0';
            }
        }
        return String.valueOf(ch);
    }
}
