package datastructure.linear;

public class Queue<E> {

    private int length;
    private Element<E> front;
    private Element<E> last;

    public void enqueue(E data) {
        Element<E> newData = new Element<>();
        newData.data = data;

        if (length++ == 0) {
            front = newData;
            last = newData;
        } else {
            last.next = newData;
        }
        last = newData;
    }

    public E dequeue() {
        if (length-- == 0) {
            throw new RuntimeException("Queue is empty");
        }
        E data = front.data;
        front = front.next;
        return data;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(2);
        queue.enqueue(11);
        System.out.println(queue.dequeue());
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
