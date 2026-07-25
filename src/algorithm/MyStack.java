package algorithm;

import java.util.LinkedList;
import java.util.Queue;

 public class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();

    }

    public void push(int x) {
        q2.offer(x);                  // 新元素放入 q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());      // q1 的全部移到 q2 后面
        }
        // 交换 q1 和 q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}