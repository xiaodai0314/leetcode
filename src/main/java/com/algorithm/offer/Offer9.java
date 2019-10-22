package com.algorithm.offer;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class Offer9 {
    private static Stack<Integer> in = new Stack<>();
    private static Stack<Integer> out = new Stack<>();

    /**
     * 放入
     */
    public void push(int val) {
        in.push(val);
    }

    /**
     * 取出
     */
    public int pop() throws Exception{
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            throw new Exception("");
        }
        return out.pop();
    }
}
