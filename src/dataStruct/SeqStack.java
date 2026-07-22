package dataStruct;

public class SeqStack {
    private int[] data;    // 存储元素的数组
    private int top;       // 栈顶指针，指向栈顶元素的位置

    // 构造方法：指定栈的最大容量
    public SeqStack(int maxSize) {
        data = new int[maxSize];
        top = -1;  // 空栈时 top = -1
    }

    // 判空
    public boolean isEmpty() {
        return top == -1;
    }

    // 判满
    public boolean isFull() {
        return top == data.length - 1;
    }

    // 入栈
    public boolean push(int value) {
        if (isFull()) {
            System.out.println("栈已满，无法入栈");
            return false;
        }
        top++;
        data[top] = value;
        return true;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，无法出栈");
        }
        int value = data[top];
        top--;
        return value;
    }

    // 取栈顶元素（不删除）
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return data[top];
    }

    // 获取元素个数
    public int size() {
        return top + 1;
    }

    // 打印（从栈顶到栈底）
    public void print() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        System.out.print("栈顶 → ");
        for (int i = top; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println("→ 栈底");
    }

    // 测试
    public static void main(String[] args) {
        SeqStack stack = new SeqStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.print();  // 栈顶 → 30 20 10 → 栈底

        System.out.println("栈顶元素：" + stack.peek());  // 30
        System.out.println("元素个数：" + stack.size());   // 3

        System.out.println("出栈：" + stack.pop());  // 30
        System.out.println("出栈：" + stack.pop());  // 20
        stack.print();  // 栈顶 → 10 → 栈底

        System.out.println("是否为空：" + stack.isEmpty());  // false
    }
}