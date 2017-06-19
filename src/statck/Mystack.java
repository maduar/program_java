package statck;

import List.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by maduar on 19/06/2017.
 */
public class Mystack<Item> implements Iterable<Item> {
  public Node<Item> first;
  public int n;

  public static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public Mystack() {
    first = null;
    n = 0;
  }

  public void push(Item item) {
    Node<Item> oldFirst = first;
    first = new Node<Item>();
    first.item = item;
    first.next = oldFirst;
    n++;
  }

  public Item  pop() {
    if (isEmpty()) throw new NoSuchElementException();
    Item item = first.item;
    first = first.next;
    n--;
    return item;
  }

  public Item peek() {
    if (isEmpty()) throw new NoSuchElementException();
    return first.item;
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
    public Node<Item> current;

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
