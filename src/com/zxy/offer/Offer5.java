package com.zxy.offer;

import java.util.Arrays;
import java.util.Scanner;

public class Offer5 {
    public static void main(String[] args) {
//        findCarPark();
//        minTimes();
//        maxDistance();
        sortNumStr();
    }

    /**
     * 非严格递增连续数字序列
     * 输入一个字符串仅包含大小写字母和数字，输入的字符串最大不超过255个字符(abc2234019A334bc)
     * 输出最长的非严格递增连续数字序列的长度(2234为最长的非严格递增连续数字序列，所以长度为4)
     */
    public static void sortNumStr() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                System.out.println(1);
                continue;
            }
            char[] chars = str.toCharArray();
            int result = 1;
            boolean flag = false;
            int len = 1;
            for (int i = 1; i < str.length(); i++) {
                if ((chars[i - 1] >= '0' && chars[i - 1] <= '9') || (chars[i] >= '0' && chars[i] <= '9')) {
                    flag = true;
                }
                if (chars[i - 1] <= chars[i] && chars[i - 1] >= '0' && chars[i] <= '9') {
                    len++;
                    if (len > result) {
                        result = len;
                    }
                    continue;
                } else {
                    len = 1;
                }
            }
            if (flag) {
                System.out.println(result);
            } else {
                System.out.println(0);
            }
        }
    }


    /**
     * 输入一个数字，对当前数字
     * 加一；
     * 减一；
     * 除以二(如果当前是偶数的话)各算一次操作，
     * 求把它变成 1 的最少操作次数
     */
    public static void minTimes() {
        Scanner scanner = new Scanner(System.in);
        long sum = scanner.nextLong();
        System.out.println(count(sum, 0));
    }

    public static int count(long sum, int times) {
        if (sum <= 1) {
            return times;
        }
        if (sum % 2 == 0) {
            return count(sum / 2, times + 1);
        }
        return Math.min(count(sum + 1, times + 1), count(sum - 1, times + 1));
    }

    /**
     * 停车场有一横排车位，0代表没有停车，1代表有车。至少停了一辆车在车位上，也至少有一个空位没有停车。
     * 为了防剐蹭，需为停车人找到一个车位，使得距停车人的车最近的车辆的距离是最大的，返回此时的最大距离
     * 1,0,0,0,0,1,0,0,1,0,1
     */
    public static void maxDistance() {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        String[] place = line.split(",");
        int count = 0, max = 0, left = 0;
        for (String s : place) {
            if (s.equals("0")) {
                count++;
            } else {
                if (left == 0) {
                    max = count * 2;
                    left = 1;
                } else {
                    max = Math.max(max, count);
                }
                count = 0;
            }
        }
        if (place[place.length - 1].equals("0")) {
            max = Math.max(max, count * 2);
        } else {
            max = Math.max(max, count);
        }
        System.out.println((max + 1) / 2);
    }

    /**
     * 找车位(1,1,0,0,1,1,1,0,1)
     * 特定大小的停车场，数组cars[]表示，其中1表示有车，0表示没车。
     * 车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3）。
     * 统计停车场最少可以停多少辆车，返回具体的数目。
     * 输入描述: 整型字符串数组cars[]，其中1表示有车，0表示没车，数组长度小于1000。
     * 输出描述: 整型数字字符串，表示最少停车数目。
     * 说明:
     * 1个小车占第1个车位
     * 第二个车位空
     * 1个小车占第3个车位
     * 最少有两辆车
     */
    public static void findCarPark() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            if (line.split(",").length >= 1000) {
                continue;
            }
            int result = 0;
            //line.replaceAll(",","") ---- 110011101
            //0+ [11, 111, 1]
            String[] split = line.replaceAll(",", "").split("0+");
            if (split != null && split.length != 0) {
                for (int i = 0; i < split.length; i++) {
                    String temp = split[i];
                    if (temp.length() == 1 || temp.length() == 2 || temp.length() == 3) {
                        result++;
                    } else {
                        //temp.length()>3
                        int length = temp.length();
                        if (length % 3 == 0) {
                            result = result + length / 3;
                        } else {
                            result = result + length / 3 + 1;
                        }
                    }
                }
            }
            System.out.println(result);
        }
        scanner.close();
    }
}
