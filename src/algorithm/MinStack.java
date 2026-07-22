package algorithm;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;   // 存数据的栈
    private Stack<Integer> minStack; // 存最小值的栈

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // 如果最小栈为空，或者 val 更小，就压入最小栈
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        // 如果出栈的元素等于最小栈的栈顶，一起出栈
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}