package com.zxy.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hj6 {
    public static void main(String[] args) {
        try {
            hj71();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void hj71() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String regex = br.readLine().toLowerCase();
        String temp = br.readLine().toLowerCase();
        int m = regex.length();
        int n = temp.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (regex.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else break;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (regex.charAt(j - 1) == '*' && ismatch(temp.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
                } else if (regex.charAt(j - 1) == '?' && ismatch(temp.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (regex.charAt(j - 1) == temp.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        System.out.println(dp[n][m]);
    }

    public static boolean ismatch(char a) {
        return (a >= '0' && a <= '9') || (a >= 'a' && a <= 'z');
    }

    /**
     * 查找两个字符串a,b中的最长公共子串
     */
    private static void hj65() {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        String temp = "";
        if (str1.length() > str2.length()) {
            temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        int index = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    index = i;
                }
            }
        }
        System.out.println(str1.substring(index - max, index));
    }

    private static void hj64() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String key = in.next();
        int pageSize = 4;
        int index = 1;
        int pageIndex = 1;
        if (n <= pageSize) {
            pageSize = n;
        }

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == 'U') {
                if (index == 1) {
                    index = n;
                    pageIndex = pageSize;
                } else {
                    index--;
                    if (pageIndex != 1) {
                        pageIndex--;
                    }
                }
            } else {
                if (index == n) {
                    index = 1;
                    pageIndex = 1;
                } else {
                    index++;
                    if (pageIndex != pageSize) {
                        pageIndex++;
                    }
                }
            }
        }
        int next = pageSize - pageIndex;
        int indexPer = pageSize - next - 1;
        String page = "";
        for (int i = indexPer; i > 0; i--) {
            page += (index - i) + " ";
        }
        page += index + " ";
        for (int i = 1; i <= next; i++) {
            page += (index + i) + " ";
        }
        System.out.println(page);
        System.out.println(index);
    }

    private static void hj63() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
        String result = "";
        double len = 0.0;
        for (int i = 0; i < str.length() - n + 1; i++) {
            String sub = str.substring(i, i + n);
            String res = sub.replaceAll("[^CG]", "");
            double cur = (double) res.length() / n;
            if (cur > len) {
                len = cur;
                result = sub;
            }
        }
        System.out.println(result);
    }

    private static void hj59() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        char flag = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                flag = entry.getKey();
                break;
            }
        }
        if (flag == 0) {
            System.out.println(-1);
        } else {
            System.out.println(flag);
        }
    }
}
