package com.stack;

import java.util.Stack;

public class StackDemo {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int element) {
        mainStack.push(element);

        if(mainStack.empty() || element <= mainStack.peek()) {
            minStack.push(element);
        }
    }

    public Integer pop() {
        if(mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin() throws Exception {
        if(mainStack.isEmpty()) {
            throw new Exception("stack is empty");
        }
        return  minStack.peek();
    }
}
