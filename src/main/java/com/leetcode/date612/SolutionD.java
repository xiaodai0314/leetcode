package com.leetcode.date612;

import java.util.HashMap;
import java.util.Stack;

public class SolutionD {
    private HashMap<Character, Character> mappings;
    public SolutionD() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(this.mappings.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if(topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new SolutionD().isValid("{[()]}"));
    }
}
