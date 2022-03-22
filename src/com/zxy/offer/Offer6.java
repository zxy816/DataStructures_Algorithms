package com.zxy.offer;

import java.util.*;

public class Offer6 {
    public static void main(String[] args) {
//        strCount();
        strSplit();
    }

    /**
     * 字符串分组分割
     * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。
     * 对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；
     * 反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；大小写字母的数量相等时，不做转换
     * 输入：3
     * --- 12abc-abCABc-4aB@
     * 输出：12abc-abc-ABC-4aB-@
     */
    public static void strSplit() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int k = scanner.nextInt();
            String str = scanner.next();
            int index = str.indexOf("-");
            char[] chars = str.toCharArray();
            List<String> list = new ArrayList<>();
            list.add(str.substring(0, index));
            int up = 0, low = 0, length = 0;
            StringBuilder builder = new StringBuilder();
            for (int i = index; i < chars.length; i++) {
                char c = chars[i];
                if ('A' <= c && c <= 'Z') {
                    up += 1;
                    builder.append(c);
                    length += 1;
                } else if ('a' <= c && c <= 'z') {
                    low += 1;
                    builder.append(c);
                    length += 1;
                } else if (c != '-') {
                    builder.append(c);
                    length += 1;
                }
                if (length == k || chars.length - 1 == i) {
                    String s = builder.toString();
                    if (up > low) {
                        list.add(s.toUpperCase());
                    } else if (up < low) {
                        list.add(s.toLowerCase());
                    } else {
                        list.add(s);
                    }
                    builder.delete(0, length);
                    up = 0;
                    low = 0;
                    length = 0;
                }
            }
            System.out.println(String.join("-", list));
        }
    }

    /**
     * 字符串统计
     * 给定两个字符集合， 一个是全量字符集， 一个是已占用字符集， 已占用字符集中的字符不能再使用， 要求输出剩余可用字符集
     * 输入：a:3,b:5,c:2@a:1,b:2
     * 输出：a:2,b:3,c:2
     */
    public static void strCount() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] split = str.split("@");
        if (split.length > 1) {
            LinkedHashMap<String, Integer> hashMap = new LinkedHashMap();
            String[] pre = split[0].split(",");
            for (int i = 0; i < pre.length; i++) {
                String[] temp = pre[i].split(":");
                hashMap.put(temp[0], Integer.valueOf(temp[1]));
            }
            String[] end = split[1].split(",");
            for (int i = 0; i < end.length; i++) {
                String[] tmp = end[i].split(":");
                hashMap.put(tmp[0], hashMap.get(tmp[0]) - Integer.parseInt(tmp[1]));
            }
            StringBuilder builder = new StringBuilder();
            for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() > 0) {
                    builder.append(entry.getKey() + ":" + entry.getValue());
                    builder.append(",");
                }
            }
            if (builder.length() > 0) {
                builder.delete(builder.lastIndexOf(","), builder.length());
                System.out.println(builder.toString());
            }
        } else {
            System.out.println(split[0]);
        }
    }
}
