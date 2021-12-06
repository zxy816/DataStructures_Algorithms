package com.zxy.offer;

import java.util.UUID;

public class Offer3 {
    public static void main(String[] args) {
//        System.out.println(fib(5));
        System.out.println(numWays(7));
    }

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
     * 1000000007
     */
    public static int numWays(int n) {
        int Mod = 1000000007;
        if (n <= 1) {
            return 1;
        }
        int p = 1, q = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = (p + q)% Mod;
            p = q;
            q = sum;
        }
        return q;
    }

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 输入：n = 5
     * 输出：5
     */
    public static int fib(int n) {
        int Mod = 1000000007;
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = (p + q) % Mod;
        }
        return r;
    }
}
