package com.zxy.offer1;

import com.zxy.offer.Offer11;

import java.util.*;

public class HJ1 {
    static ArrayList<Integer> list = new ArrayList();

    public static void main(String[] args) {
//        oD1();
//        oD2();
//        oD3();
//        oD4();
//        oD5();
        oD6();
    }

    public static void oD6() {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int num = sc.nextInt();
        good[] goods = new good[num + 1];
        for (int i = 1; i <= num; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            goods[i] = new good(v, p, q);
        }

        for (int i = 1; i <= num; i++) {
            int n = goods[i].q;
            if (n > 0) {
                if (goods[n].a1 == 0) {
                    goods[n].setA1(i);
                } else {
                    goods[n].setA2(i);
                }
            }
        }

        int[][] dp = new int[num + 1][money + 1];
        for (int i = 1; i <= num; i++) {
            int v1 = 0, v2 = 0, v3 = 0, tempdp1 = 0, tempdp2 = 0, tempdp3 = 0;
            int v = goods[i].v;
            int tempdp = goods[i].p * v; //只有主件
            if (goods[i].a1 != 0) {//主件加附件1
                v1 = goods[goods[i].a1].v + v;
                tempdp1 = tempdp + goods[goods[i].a1].v * goods[goods[i].a1].p;
                System.out.println("==v1===" + i + "," + goods[i].a1 + "," + tempdp1);
            }

            if (goods[i].a2 != 0) {//主件加附件2
                v2 = goods[goods[i].a2].v + v;
                tempdp2 = tempdp + goods[goods[i].a2].v * goods[goods[i].a2].p;
                System.out.println("==v2===" + i + "," + goods[i].a2 + "," + tempdp2);
            }

            if (goods[i].a1 != 0 && goods[i].a2 != 0) {//主件加附件1和附件2
                v3 = goods[goods[i].a1].v + goods[goods[i].a2].v + v;
                tempdp3 = tempdp + goods[goods[i].a1].v * goods[goods[i].a1].p + goods[goods[i].a2].v * goods[goods[i].a2].p;
                System.out.println("==v1====v2===" + i + "," + goods[i].a1 + "," + goods[i].a2 + "," + tempdp3);
            }

            for (int j = 1; j <= money; j++) {
                if (goods[i].q > 0) {   //当物品i是附件时,相当于跳过
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= v && v != 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v] + tempdp);
                    if (j >= v1 && v1 != 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v1] + tempdp1);
                    if (j >= v2 && v2 != 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v2] + tempdp2);
                    if (j >= v3 && v3 != 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v3] + tempdp3);
                }
            }
        }
        System.out.println(dp[num][money]);
    }

    /**
     * 定义物品类
     */
    private static class good {
        public int v;  //物品的价格
        public int p;  //物品的重要度
        public int q;  //物品的主附件ID

        public int a1 = 0;   //附件1ID
        public int a2 = 0;   //附件2ID

        public good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }
    }

    /**
     * 分苹果
     */
    public static void oD5() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp ^= arr[i];
        }
        System.out.println(temp);
        if (temp == 0) {
            Arrays.sort(arr);
            int sum = 0;
            for (int i = 1; i < arr.length; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
        } else {
            System.out.println(-1);
        }
    }


    /**
     * 最大出牌数量
     * 输入 1 4 3 4 5
     * --- r y b b r
     * 输出 3
     */
    public static void oD4() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        builder.append(str);
        int sizeZero = 8 - str.length() % 8;
        while (sizeZero > 0 && sizeZero < 8) {
            builder.append("0");
            sizeZero--;
        }
        String sb = builder.toString();
        while (sb.length() > 0) {
            System.out.println(sb.substring(0, 8));
            sb = sb.substring(8);
        }
    }


    /**
     * 天然货仓
     */
    public static void oD3() {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        String arr = scanner.nextLine();
        String[] arrs = arr.split(",");
        if (M != arrs.length) {
            System.out.println(0);
            return;
        }
        int maxValue = 0;
        int index = 0;
        for (int i = 0; i < arrs.length; i++) {
            if (Integer.parseInt(arrs[i]) < 0) {
                maxValue++;
            } else {
                index = maxValue;
                maxValue = 0;
            }
        }
        if (N > index) {
            System.out.println(0);
        } else {
            System.out.println(index / N);
        }
    }

    /**
     * 转骰子
     */
    public static void oD2() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 6; i++) {
            list.add(i);
        }
        String str = scanner.next();
        System.out.println("输入的字符：" + str);
        for (int i = 0; i < str.length(); i++) {
            swap(str.charAt(i));
        }
        for (int i = 0; i < 6; i++) {
            System.out.print(list.get(i) + "   ");
        }
    }

    public static void swap(char c) {
        switch (c) {
            case 'L': {
                int l = list.get(0);
                int r = list.get(1);
                int u = list.get(4);
                int d = list.get(5);
                list.set(0, u);
                list.set(1, d);
                list.set(4, r);
                list.set(5, l);
                break;
            }
            case 'R': {
                int l = list.get(0);
                int r = list.get(1);
                int u = list.get(4);
                int d = list.get(5);
                list.set(0, d);
                list.set(1, u);
                list.set(4, l);
                list.set(5, r);
                break;
            }
            case 'F': {
                int f = list.get(2);
                int b = list.get(3);
                int u = list.get(4);
                int d = list.get(5);
                list.set(2, u);
                list.set(3, d);
                list.set(4, b);
                list.set(5, f);
                break;
            }
            case 'B': {
                int f = list.get(2);
                int b = list.get(3);
                int u = list.get(4);
                int d = list.get(5);
                list.set(2, d);
                list.set(3, u);
                list.set(4, f);
                list.set(5, b);
                break;
            }
            case 'A': {
                int l = list.get(0);
                int r = list.get(1);
                int f = list.get(2);
                int b = list.get(3);
                list.set(0, b);
                list.set(1, f);
                list.set(2, l);
                list.set(3, r);
                break;
            }
            case 'C': {
                int l = list.get(0);
                int r = list.get(1);
                int f = list.get(2);
                int b = list.get(3);
                list.set(0, f);
                list.set(1, b);
                list.set(2, r);
                list.set(3, l);
                break;
            }
        }
    }

    /**
     * 给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重
     */
    public static void oD1() {
        Scanner scanner = new Scanner(System.in);
        String m = scanner.nextLine();
        String arrStr = scanner.nextLine();
        String n = scanner.nextLine();
        System.out.println("m:" + m + ",数组：" + arrStr + ",n:" + n);
        HashSet<Integer> hashSet = new HashSet<>();
        String[] arr = arrStr.split(" ");
        for (String item : arr) {
            if (!item.equals("")) {
                hashSet.add(Integer.parseInt(item));
            }
        }
        System.out.println("hashSet数量：" + hashSet.size());
        int num = Integer.parseInt(n);
        if (num * 2 > hashSet.size()) {
            System.out.println(-1);
            return;
        }
        if (num == 0 || hashSet.size() == 0) {
            System.out.println(0);
            return;
        }
        Iterator<Integer> iterator = hashSet.iterator();
        int[] arrs = new int[hashSet.size()];
        int i = 0;
        while (iterator.hasNext()) {
            arrs[i++] = iterator.next();
        }
        Arrays.sort(arrs);
        System.out.println(Arrays.toString(arrs));
        int sum = 0;
        for (int j = 0, len = arrs.length; j < num; j++) {
            sum += arrs[j];
            sum += arrs[len - j - 1];
        }
        System.out.println("和：" + sum);
    }
}
