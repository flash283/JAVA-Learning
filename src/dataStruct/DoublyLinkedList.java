package dataStruct;

public class DoublyLinkedList {
    private Node head;  // 头节点

    // 双向链表节点类
    public static class Node {
        int data;
        Node prev;  // 指向前一个节点
        Node next;  // 指向后一个节点

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // 构造方法：带头节点的空链表
    public DoublyLinkedList() {
        head = new Node(0);  // 头节点，不存有效数据
        head.next = null;
        head.prev = null;
    }

    // 判空
    public boolean isEmpty() {
        return head.next == null;
    }

    // 头插法
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head.next;   // 新节点的 next 指向原首元节点
        newNode.prev = head;        // 新节点的 prev 指向头节点
        if (head.next != null) {
            head.next.prev = newNode;  // 原首元节点的 prev 指向新节点
        }
        head.next = newNode;        // 头节点的 next 指向新节点
    }

    // 尾插法
    public void addLast(int value) {
        Node newNode = new Node(value);
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
        newNode.prev = p;
    }

    // 指定位置插入（index 从 1 开始）
    public boolean insert(int index, int value) {
        if (index < 1) return false;
        Node p = head;
        int i = 0;
        while (p != null && i < index - 1) {
            p = p.next;
            i++;
        }
        if (p == null) return false;

        Node newNode = new Node(value);
        newNode.next = p.next;
        newNode.prev = p;
        if (p.next != null) {
            p.next.prev = newNode;
        }
        p.next = newNode;
        return true;
    }

    // 按位置删除
    public int removeAt(int index) {
        if (isEmpty()) throw new RuntimeException("链表为空");
        if (index < 1) throw new RuntimeException("位置不合法");

        Node p = head;
        int i = 0;
        while (p.next != null && i < index - 1) {
            p = p.next;
            i++;
        }
        if (p.next == null) throw new RuntimeException("位置不合法");

        int removed = p.next.data;
        p.next = p.next.next;
        if (p.next != null) {
            p.next.prev = p;
        }
        return removed;
    }

    // 打印（正向）
    public void printForward() {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        Node p = head.next;
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.println("null");
    }

    // 打印（反向）
    public void printBackward() {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        // 先找到尾节点
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        // 从后往前遍历
        while (p != head) {
            System.out.print(p.data + " -> ");
            p = p.prev;
        }
        System.out.println("head");
    }

    // 测试
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        System.out.print("正向：");
        list.printForward();   // 1 -> 2 -> 3 -> null
        System.out.print("反向：");
        list.printBackward();  // 3 -> 2 -> 1 -> head

        list.addFirst(0);
        System.out.print("头插后：");
        list.printForward();   // 0 -> 1 -> 2 -> 3 -> null

        list.insert(3, 99);
        System.out.print("插入99到第3位：");
        list.printForward();   // 0 -> 1 -> 99 -> 2 -> 3 -> null

        list.removeAt(2);
        System.out.print("删除第2位：");
        list.printForward();   // 0 -> 99 -> 2 -> 3 -> null
    }
}