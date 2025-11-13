// ...existing code...
import java.util.LinkedList;

class MyQueue<T> {
    private LinkedList<T> queue;

    public MyQueue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(T item) {
        queue.addLast(item);
    }

    // 如果隊列為空，回傳 null（安全於單元測試）
    public T dequeue() {
        return queue.pollFirst();
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // 返回隊列中的元素數量
    public int size() {
        return queue.size();
    }
}

public class QueueExample {
    public static void main(String[] args) {
        MyQueue<Integer> intQueue = new MyQueue<>();
        // 簡單測試範例
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        System.out.println("size=" + intQueue.size()); // 預期 2
        System.out.println("dequeue=" + intQueue.dequeue()); // 預期 1
        System.out.println("isEmpty=" + intQueue.isEmpty()); // 預期 false
    }
}

//我的Junit測試會測這個Object，這邊以下請不要修改
//---------------------------------------------------------------------------------
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
//---------------------------------------------------------------------------------