import java.io.Serializable;

public class Storage_Queue implements Serializable {

    private StorageItem[] queue;

    private int maxSize; // максимальное количество элементов в очереди
    private int nElem;  // текущее количество элементов в очереди

    private int front;
    private int rear;

    public Storage_Queue(int maxSize) {
        this.maxSize = maxSize;
        queue = new StorageItem[maxSize];
        rear = -1;
        front = 0;
        nElem = 0;
    }

    public void insert(StorageItem elem) {
        if (!isFull()) {
            if (rear == maxSize - 1) {  // циклический перенос
                rear = -1;
            }

            queue[++rear] = elem;
            nElem++;
        }
    }

    public StorageItem remove() {
        StorageItem temp = queue[front++];

        if (front == maxSize) { // циклический перенос
            front = 0;
        }
        nElem--;
        return temp;

    }

    public StorageItem getFront() {
        return queue[front];
    }

    public StorageItem getRear() {
        return queue[rear];
    }

    public boolean isFull() {
        return (nElem == maxSize - 1);
    }

    public boolean isEmpty() {
        return (nElem == 0);
    }

    public int getSize() {
        return nElem;
    }
}
