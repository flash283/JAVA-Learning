package dataStruct;

public class CircularQueue {
    private int[] data;    // 存储元素的数组
    private int front;     // 队头指针
    private int rear;      // 队尾指针

    // 构造方法
    public CircularQueue(int maxSize) {
        data = new int[maxSize + 1];  // 多留一个位置区分空和满
        front = 0;
        rear = 0;
    }

    // 判空
    public boolean isEmpty() {
        return front == rear;
    }

    // 判满
    public boolean isFull() {
        return (rear + 1) % data.length == front;
    }

    // 入队
    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("队列已满");
            return false;
        }
        data[rear] = value;
        rear = (rear + 1) % data.length;
        return true;
    }

    // 出队
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value = data[front];
        front = (front + 1) % data.length;
        return value;
    }

    // 获取队头元素
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return data[front];
    }

    // 获取元素个数
    public int size() {
        return (rear - front + data.length) % data.length;
    }

    // 打印
    public void print() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        System.out.print("队头 → ");
        int i = front;
        while (i != rear) {
            System.out.print(data[i] + " ");
            i = (i + 1) % data.length;
        }
        System.out.println("→ 队尾");
    }

    // 测试
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(4);  // 实际能存4个

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.print();  // 10 20 30 40

        System.out.println("队满：" + queue.isFull());  // true

        System.out.println("出队：" + queue.dequeue());  // 10
        System.out.println("出队：" + queue.dequeue());  // 20
        queue.print();  // 30 40

        queue.enqueue(50);
        queue.enqueue(60);
        queue.print();  // 30 40 50 60

        System.out.println("元素个数：" + queue.size());  // 4
        System.out.println("队头：" + queue.peek());     // 30
    }
}