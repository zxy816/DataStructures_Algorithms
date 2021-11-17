package com.zxy.hot100;

import java.util.Arrays;

public class Day11 {
    public static void main(String[] args) {
        String[] words = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(words));
    }

    public static int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                mask[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

}
