package dataStruct;
public class SqList {
    private int length;
    private int[] arr;

    public SqList() {

    }

    public SqList(int maxsSize) {
        arr = new int[maxsSize];
        length = 0;

    }

    //销毁
    void destoryList() {
        arr = null;
        length = 0;

    }

    //清空
    void clearList() {
        length = 0;
    }

    //长度
    int getLength() {
        return length;
    }

    //是否为空
    int isEmpty() {
        if (length == 0) {
            return 1;
        } else return 0;
    }

    //获取指定位置元素
    int get(int index) {
        if (index < 0 || index >= length + 1) {
            System.out.println("下标越界");
            return 0;
        }
        return arr[index - 1];
    }

    //查找
    int locate(int e) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == e) return 1 + i;
        }
        return 0;
    }

    //插入
    boolean insert(int index, int value) {
        if (index < 1 || index >= length + 1) {
            System.out.println("下标越界");
            return false;
        }
        if (length >= arr.length) {
            System.out.println("表已满");
            return false;
        }
        for (int i = length - 1; i >= index - 1; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index - 1] = value;
        length++;
        return true;
    }

    //删除
    boolean delete(int index) {
        if (index < 1 || index >= length + 1) {
            System.out.println("下标越界");
            return false;
        }
        for (int i = index; i <= length - 1; i++) {
            arr[i - 1] = arr[i];
        }
        length--;
        return true;
    }
}