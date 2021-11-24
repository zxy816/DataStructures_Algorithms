package com.zxy.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day15 {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(Arrays.asList(letterCombinations(digits)));
    }

    /**
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        HashMap<Character, String> hashMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        StringBuffer buffer = new StringBuffer();
        backtrack(list, hashMap, digits, 0, buffer);
        return list;
    }

    public static void backtrack(List<String> list, HashMap<Character, String> hashMap, String digits, int index, StringBuffer buffer) {
        if (index == digits.length()) {
            list.add(buffer.toString());
        } else {
            char digit = digits.charAt(index);
            String str = hashMap.get(digit);
            for (int i = 0; i < str.length(); i++) {
                buffer.append(str.charAt(i));
                backtrack(list, hashMap, digits, index + 1, buffer);
                buffer.deleteCharAt(index);
            }
        }
    }
}
