package algorithm;

import java.util.Stack;
class MyQueue {
    private Stack<Integer> s1;  // 入队栈
    private Stack<Integer> s2;  // 出队栈

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);  // 直接压入 s1
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());  // 把 s1 的全部倒入 s2
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();  // 两个都空才是空
    }
}

