package com.zxy.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Hj7 {
    public static void main(String[] args) throws IOException {
//        hj103();
    }

    /**
     * Redraiment的走法
     */
    private static void hj103() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            Integer num = Integer.parseInt(str);
            String height = br.readLine();
            int[] h = new int[num];
            for (int i = 0; i < num; i++) {
                h[i] = Integer.parseInt(height.split(" ")[i]);
            }
            int[] dp = new int[num + 1];
            Arrays.fill(dp, 1);
            int max = 0;
            for (int i = 1; i < num; i++) {
                for (int j = 0; j < i; j++) {
                    if (h[j] < h[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                    max = Math.max(max, dp[i]);
                }
            }
            System.out.println(max);
        }
    }

    /**
     * 火车进站
     */
    private static void hj90() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] strings = str.split("\\.");
            String isIp = "YES";
            if (strings.length == 4) {
                for (String strs : strings) {
                    if (strs.isEmpty() || strs.length() > 3) {
                        isIp = "NO";
                        break;
                    }
                    if (strs.charAt(0) == '0' && strs.length() > 1) {
                        isIp = "NO";
                        break;
                    }
                    for (Character ch : strs.toCharArray()) {
                        if (!Character.isDigit(ch)) {
                            isIp = "NO";
                            break;
                        }
                    }

                    Integer ipNum = Integer.parseInt(strs);
                    if (ipNum < 0 || ipNum > 255) {
                        isIp = "NO";
                        break;
                    }
                }
            } else {
                isIp = "NO";
            }
            System.out.println(isIp);
        }
    }

    /**
     * 在字符串中找出连续最长的数字串
     *
     * @throws IOException
     */
    public static void hj92() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int len = s.length();
            int[] dp = new int[len + 1];
            int max = 0;
            for (int i = 1; i <= len; i++) {
                char c = s.charAt(i - 1);
                if (c >= '0' && c <= '9') {
                    dp[i] = dp[i - 1] + 1;
                    max = Math.max(max, dp[i]);
                }
            }

            for (int i = 1; i <= len; i++) {
                if (dp[i] == max) {
                    System.out.print(s.substring(i - max, i));
                }
            }
            System.out.println("," + max);
        }
    }

    /**
     * 公共子串计算
     *
     * @throws IOException
     */
    public static void hj75() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
