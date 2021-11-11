package com.zxy.hot100;

import java.util.Arrays;

public class Day6 {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(countBits1(5)));
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] count = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            count[i] = countOne(i);
        }
        return count;
    }

    public static int countOne(int n) {
        int ones = 0;
        while (n > 0) {
            n = n & (n - 1);
            ones++;
        }
        return ones;
    }

    /**
     * 比特位计数 1
     *
     * @param n
     * @return
     */
    public static int[] countBits1(int n) {
        int[] count = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            count[i] = Integer.bitCount(i);
        }
        return count;
    }
}
