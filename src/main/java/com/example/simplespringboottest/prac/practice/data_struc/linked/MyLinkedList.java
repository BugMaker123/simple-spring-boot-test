package com.example.simplespringboottest.prac.practice.data_struc.linked;

import java.util.*;

/**
 * @ ClassName: MyLinkedList
 * @Author: legen
 * @Date: 2021/4/9
 */
public class MyLinkedList<E> extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, java.io.Serializable {
    transient int size = 0;


    transient Node<E> first;

    transient Node<E> last;

    public MyLinkedList() {
    }

    public MyLinkedList(Collection<? extends E> c) {
       this();
       addAll(c);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public void addFirst(E e) {
        linkedFirst(e);
    }

    private void linkedFirst(E e) {
        final Node<E> node = first;
        //指向原来的第一个元素
        final Node<E> newNode = new Node<E>(null,e,node);
        first = newNode;
        // 如果当前要添加的第一个元素为是null
        if (first==null){
            //
            last= newNode;
        }else {
            first.pre=node;
        }
        size++;
    }

    @Override
    public void addLast(E e) {

    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }


    static class Node<E> {
        Node<E> pre;
        E e;
        Node<E> next;

        public Node() {
        }

        public Node(Node pre, E e, Node next) {
            this.pre = pre;
            this.e = e;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
    }
}
