package com.zxy.effic;

public class Section3 {
    public static void main(String[] args) {
        System.out.println("F(3) = " + fib(3) + ",F(4) = " + fib(4) + ",F(5) = " + fib(5) + ",F(6) = " + fib(6));
        System.out.println("---------------");
        System.out.println("C(2) = " + climbStairs(2));
        System.out.println("C(3) = " + climbStairs(3));
        System.out.println("C(4) = " + climbStairs(4));
    }

    /**
     * 斐波那契数
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * -------------------------------------
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     */
    public static int fib(int n) {
        //f(0) + f(1) = 1
        if (n < 2) {
            return n;
        }
        // 0, 1, 1, 2, 3, 5, 8
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
     * --------------------------------------
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     */
    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // 1, 1, 2, 3, 5
        int p = 1, q = 1, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
