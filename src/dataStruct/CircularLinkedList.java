package dataStruct;

public class CircularLinkedList {
    private Node head;  // 头节点

    // 节点类
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // 构造方法
    public CircularLinkedList() {
        head = null;
    }

    // 判空
    public boolean isEmpty() {
        return head == null;
    }

    // 头插法
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            newNode.next = head;  // 自己指向自己，形成环
        } else {
            // 找尾节点
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            newNode.next = head;   // 新节点指向原头
            head = newNode;        // 头指针指向新节点
            tail.next = head;      // 尾节点指向新头
        }
    }

    // 尾插法
    public void addLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            newNode.next = head;
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.next = head;
        }
    }

    // 打印
    public void print() {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        Node p = head;
        do {
            System.out.print(p.data + " -> ");
            p = p.next;
        } while (p != head);
        System.out.println("(回到头节点)");
    }

    // 获取头节点
    public Node getHead() {
        return head;
    }

    // ========== 合并两个循环链表（静态方法）==========
    public static Node merge(Node headA, Node headB) {
        if (headA == null) return headB;
        if (headB == null) return headA;

        // 找链表A的尾节点
        Node tailA = headA;
        while (tailA.next != headA) {
            tailA = tailA.next;
        }

        // 找链表B的尾节点
        Node tailB = headB;
        while (tailB.next != headB) {
            tailB = tailB.next;
        }

        // A尾接B头，B尾接A头
        tailA.next = headB;
        tailB.next = headA;

        return headA;
    }

    // ========== 测试 ==========
    public static void main(String[] args) {
        // 创建链表A：1 -> 2 -> 3
        CircularLinkedList listA = new CircularLinkedList();
        listA.addLast(1);
        listA.addLast(2);
        listA.addLast(3);
        System.out.print("链表A：");
        listA.print();

        // 创建链表B：4 -> 5
        CircularLinkedList listB = new CircularLinkedList();
        listB.addLast(4);
        listB.addLast(5);
        System.out.print("链表B：");
        listB.print();

        // 合并
        Node mergedHead = CircularLinkedList.merge(listA.getHead(), listB.getHead());
        System.out.print("合并后：");

        // 打印合并后的链表
        if (mergedHead != null) {
            Node p = mergedHead;
            do {
                System.out.print(p.data + " -> ");
                p = p.next;
            } while (p != mergedHead);
            System.out.println("(回到头节点)");
        }
    }
}