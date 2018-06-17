import java.io.Serializable;

public class Storage_Stack implements Serializable {

    private int mSize;
    private StorageItem[] stackArray;
    private int top;

    public Storage_Stack(int n) {
        this.mSize = n;
        stackArray = new StorageItem[mSize];
        top = -1;
    }

    public void addElement(StorageItem element) {
        if(!isFull()){
        stackArray[++top] = element;
        }
    }

    public StorageItem deleteElement() {
        return stackArray[top--];
    }

    public StorageItem readTop() {
        return stackArray[top];

    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == mSize - 1);
    }

    //Не входит в функционал стека, чисто вывод масива
    public void printArray(){
        for(int i = 0; i<=top;i++){
            stackArray[i].printItem();
        }
    }

    //Классика вечна
    public void bubbleSort(){
        StorageItem temp;

        for(int i=0; i < mSize; i++){
            for(int j=1; j < (mSize-i); j++){

                if(stackArray[j-1].add_date.isAfter(stackArray[j].add_date)){

                    temp = stackArray[j-1];
                    stackArray[j-1] = stackArray[j];
                    stackArray[j] = temp;
                }
            }
        }
    }
}
