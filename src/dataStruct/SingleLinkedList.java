package dataStruct;

public class SingleLinkedList {
    private Node head;  // 头指针，指向头节点

    // 节点类
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // 构造方法：创建带头节点的空链表
    public SingleLinkedList() {
        head = new Node(0);  // 头节点，data 不存有效数据
        head.next = null;    // 头节点后面还没有首元节点
    }

    // ========== 判断是否为空 ==========
    public boolean isEmpty() {
        return head.next == null;  // 头节点后面没有节点，才是空
    }

    // ========== 销毁链表 ==========
    public void destroy() {
        head.next = null;  // 断开首元节点，整条链回收
        head = null;       // 头节点也回收
    }

    // ========== 清空链表（保留头节点）==========
    public void clear() {
        head.next = null;  // 只断开首元节点，头节点保留
    }

    // ========== 头插法：在头节点后面插入 ==========
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head.next;  // 新节点指向原来的首元节点
        head.next = newNode;       // 头节点指向新节点
    }

    // ========== 尾插法：插到链表末尾 ==========
    public void addLast(int value) {
        Node newNode = new Node(value);
        Node p = head;
        while (p.next != null) {  // 找到最后一个节点
            p = p.next;
        }
        p.next = newNode;  // 最后一个节点的 next 指向新节点
    }

    // ========== 指定位置插入 ==========
    // index 从 1 开始（逻辑位序），插在第 index 个位置
    public boolean insert(int index, int value) {
        if (index < 1) {
            System.out.println("位置不合法");
            return false;
        }
        Node p = head;
        int i = 0;
        // 找到第 index-1 个节点
        while (p != null && i < index - 1) {
            p = p.next;
            i++;
        }
        if (p == null) {
            System.out.println("位置不合法");
            return false;
        }
        Node newNode = new Node(value);
        newNode.next = p.next;
        p.next = newNode;
        return true;
    }

    // ========== 按位置删除 ==========
    public int removeAt(int index) {
        if (isEmpty()) {
            throw new RuntimeException("链表为空");
        }
        if (index < 1) {
            throw new RuntimeException("位置不合法");
        }
        Node p = head;
        int i = 0;
        // 找到第 index-1 个节点
        while (p.next != null && i < index - 1) {
            p = p.next;
            i++;
        }
        if (p.next == null) {
            throw new RuntimeException("位置不合法");
        }
        int removed = p.next.data;   // 保存被删除的值
        p.next = p.next.next;        // 跳过被删除的节点
        return removed;
    }

    // ========== 按值删除（删除第一次出现的）==========
    public boolean removeByValue(int value) {
        if (isEmpty()) return false;
        Node p = head;
        while (p.next != null) {
            if (p.next.data == value) {
                p.next = p.next.next;  // 跳过该节点
                return true;
            }
            p = p.next;
        }
        return false;
    }

    // ========== 按位置查找 ==========
    public int get(int index) {
        if (isEmpty()) throw new RuntimeException("链表为空");
        if (index < 1) throw new RuntimeException("位置不合法");
        Node p = head.next;  // 从首元节点开始
        int i = 1;
        while (p != null && i < index) {
            p = p.next;
            i++;
        }
        if (p == null) throw new RuntimeException("位置不合法");
        return p.data;
    }

    // ========== 按值查找 ==========
    public int indexOf(int value) {
        Node p = head.next;  // 从首元节点开始
        int index = 1;
        while (p != null) {
            if (p.data == value) return index;
            p = p.next;
            index++;
        }
        return -1;  // 没找到
    }

    // ========== 获取长度 ==========
    public int size() {
        int count = 0;
        Node p = head.next;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    // ========== 打印链表 ==========
    public void print() {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        Node p = head.next;  // 从头节点的下一个（首元节点）开始
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.println("null");
    }
}