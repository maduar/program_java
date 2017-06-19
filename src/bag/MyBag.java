package bag;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by maduar on 19/06/2017.
 */
public class MyBag<Item> implements Iterable<Item>{

    public Node<Item> first;
    public int n;

    public class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    private class ListIterator<Item> implements Iterator<Item> {
        public Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        MyBag<String> bag = new MyBag<String>();
        String aa = "11.00";
        bag.add(aa);

        StdOut.println("size of bag = " + bag.size());
        for (String s : bag) {
            StdOut.println(s);
        }
    }
}
