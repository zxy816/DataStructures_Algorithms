package com.zxy.offer;

import java.util.Stack;

public class Offer7 {
    public static void main(String[] args) {

    }

    class MinStack {
        Stack<Integer> stack;
        int min;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.empty()) {
                min = x;
            }
            if (x<=min){
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (min == stack.pop()){
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min;
        }
    }
}
