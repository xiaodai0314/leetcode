package com.leetcode.date612;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.put;

/**
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class SolutionB {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return list;
    }
    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            list.add(combination);
        } else {
            String digit = next_digits.substring(0,1);
            String letters = phone.get(digit);
            for (int i=0 ; i< letters.length() ; i++) {
                String letter = phone.get(digit).substring(i,i+1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new SolutionB().letterCombinations("234"));
    }
}
