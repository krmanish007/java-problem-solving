package datastructure.linear;

public class Stack<E> {
    private Element<E> root;

    public void push(E e) {
        final Element<E> element = new Element<>();
        element.data = e;
        element.next = root;

        root = element;
    }

    public E pop() {
        E data = root.data;
        root = root.next;
        return data;
    }

    public E peek() {
        return root.data;
    }

    public static void main(String[] args) {
        Stack<Integer> queue = new Stack<>();
        queue.push(1);
        queue.push(5);
        queue.push(6);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
    }
}
class Element<E> {
    E data;
    Element<E> next;
}
