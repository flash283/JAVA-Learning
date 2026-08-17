package algorithm;


public class MyCircularQueue {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public MyCircularQueue(int k) {
     data=new int[k];
     front=0;
     rear=0;
     size=0;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        data[rear]=value;
        rear=(rear+1)%data.length;
        size++;
        return true;
    }

    public boolean deQueue() {
      if(isEmpty()){
          return false;
      }
      front=(front+1)%data.length;
      size--;
      return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return data[front];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return data[(rear - 1 + data.length) % data.length];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
       return size==data.length;
    }
}
