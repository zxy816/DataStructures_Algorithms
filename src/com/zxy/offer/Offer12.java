package com.zxy.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Offer12 {
    public static void main(String[] args) {
        oD1();
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
            sum += arrs[len-j-1];
        }
        System.out.println("和：" + sum);
    }
}
