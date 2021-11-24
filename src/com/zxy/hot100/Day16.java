package com.zxy.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day16 {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(generateParenthesis(3)));
    }

    /**
     * 括号生成
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, StringBuilder builder, int left, int right, int max) {
        if (builder.length() == 2 * max) {
            list.add(builder.toString());
            return;
        }
        if (left < max) {
            builder.append("(");
            backtrack(list, builder, left + 1, right, max);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right < left) {
            builder.append(")");
            backtrack(list, builder, left, right + 1, max);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
