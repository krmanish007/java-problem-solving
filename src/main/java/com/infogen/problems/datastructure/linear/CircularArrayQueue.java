package com.infogen.problems.datastructure.linear;

import java.lang.reflect.Array;

public class CircularArrayQueue<E> {
    private E[] list;
    private int MAX_SIZE=4;

    private int HEAD_INDEX = -1;
    private int TAIL_INDEX = -1;

    public CircularArrayQueue(Class<E> clazz) {
        this.list = (E[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public void push(E e) {
        if (HEAD_INDEX == -1) {
            HEAD_INDEX = 0;
        }
        list[++TAIL_INDEX] = e;
    }

    public E pop() {
        // TODO not -1,
        E e = list[HEAD_INDEX];
        HEAD_INDEX++;

        return e;
    }

    public static void main(String[] args) {
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>(Integer.class);
        queue.push(1);
        queue.push(5);
        queue.push(6);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        System.out.println("queue.TAIL_INDEX = " + queue.TAIL_INDEX);
        System.out.println("queue.HEAD_INDEX = " + queue.HEAD_INDEX);
    }
}
