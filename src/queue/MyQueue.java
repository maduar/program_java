package queue;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by maduar on 19/06/2017.
 */
public class MyQueue<Item> implements Iterable<Item> {
    public Node<Item> first;
    public Node<Item> last;
    public int n;

    private static class Node<Item> {
        private Node<Item> next;
        private Item item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public MyQueue() {
        first = null;
        last = null;
        n = 0;
    }

    public int size() {
        return n;
    }

    public Item peek() {
        if (!isEmpty()) throw  new NoSuchElementException();
        return first.item;
    }


    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
        n--;
        return item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
