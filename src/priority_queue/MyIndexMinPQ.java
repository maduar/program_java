package priority_queue;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by maduar on 26/06/2017.
 */
public class MyIndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {

  private int maxN;        // maximum number of elements on PQ
  private int n;           // number of elements on PQ
  private int[] pq;        // binary heap using 1-based indexing
  private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
  private Key[] keys;      // keys[i] = priority of i

  public MyIndexMinPQ(int maxN) {
    if (maxN < 0) {
      throw new IllegalArgumentException();
    }
    this.maxN = maxN;
    n = 0;
    keys = (Key[]) new Comparable[maxN + 1];
    pq = new int[maxN + 1];
    qp = new int[maxN + 1];
    for (int i = 0; i < maxN; i++) {
      qp[i] = -1;
    }
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public boolean contains(int i) {
    if (i < 0 || i > maxN) {
      throw new IndexOutOfBoundsException();
    }
    return qp[i] != -1;
  }

  public int size() {
    return n;
  }

  public int minIndex() {
    if (n == 0) {
      throw new NoSuchElementException("Priority queue underflow");
    }
    return pq[1];
  }

  public Key minKey() {
    if (n == 0) {
      throw new NoSuchElementException("Priority queue underflow");
    }
    return keys[pq[1]];
  }

  public void insert(int i, Key key) {
    if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
    if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
    n++;
    qp[i] = n;
    pq[n] = i;
    keys[i] = key;
    swim(n);
  }

  public int delMin() {
    if (n == 0) {
      throw new NoSuchElementException("Priority queue underflow");
    }
    int min = pq[1];
    exch(1, n--);
    skin(1);
    qp[min] = -1;
    keys[min] = null;
    pq[n + 1] = -1;
    return min;
  }

  public Key keyof(int i) {
    if (i < 0 || i >= maxN) {
      throw new IndexOutOfBoundsException();
    }

    if (!contains(i)) {
      throw new NoSuchElementException("index is not in the priority queue");
    } else {
      return keys[i];
    }

  }

  public void changeKey(int i, Key key) {
    if (i < 0 || i >= maxN) {
      throw new IndexOutOfBoundsException();
    }

    if (!contains(i)) {
      throw new NoSuchElementException("index is not in the priority queue");
    }

    keys[i] = key;
    swim(qp[i]);
    skin(qp[i]);
  }

  @Deprecated
  public void change(int i, Key key) {
    changeKey(i, key);
  }


  public void decrease(int i, Key key) {
    if (i < 0 || i >= maxN) {
      throw new IndexOutOfBoundsException();
    }

    if (!contains(i)) {
      throw new NoSuchElementException("index is not in the priority queue");
    }
    if (keys[i].compareTo(key) <= 0) {
      throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
    }

    keys[i] = key;
    swim(i);
  }

  public void increase(int i, Key key) {
    if (i < 0 || i >= maxN) {
      throw new IndexOutOfBoundsException();
    }

    if (!contains(i)) {
      throw new NoSuchElementException("index is not in the priority queue");
    }
    if (keys[i].compareTo(key) >= 0) {
      throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
    }

    keys[i] = key;
    skin(i);
  }


  public void delete(int i) {
    if (i < 0 || i >= maxN) {
      throw new IndexOutOfBoundsException();
    }

    if (!contains(i)) {
      throw new NoSuchElementException("index is not in the priority queue");
    }

    int index = qp[i];
    exch(index, n--);
    swim(i);
    skin(i);

    keys[i] = null;
    qp[i] = -1;

  }


  //  help funtion

  public boolean greater(int i, int j) {
    return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
  }

  public void exch(int i, int j) {
    int swap = pq[j];
    pq[i] = pq[j];
    pq[j] = swap;

    qp[pq[i]] = i;
    qp[pq[j]] = j;
  }

  public void swim(int k) {
    while (k < maxN && greater(k / 2, k)) {
      exch(k, k / 2);
      k = k / 2;
    }
  }

  public void skin(int k) {
    while (2 * k <= n) {
      int j = 2 * k;
      if (j <= maxN && greater(j, j + 1)) {
        j++;
      }

      if (!greater(k, j)) {
        break;
      }

      exch(k, j);
      k = j;
    }
  }

  public Iterator<Integer> iterator() {
    return new HeapIterator();
  }

  private class HeapIterator implements Iterator<Integer> {
    public MyIndexMinPQ<Key> copy;

    public HeapIterator() {
      copy = new MyIndexMinPQ<Key>(pq.length - 1);
      for (int i = 0; i <= n; i++) {
        copy.insert(pq[i], keys[pq[i]]);
      }
    }

    public boolean hasNext() {
      return !copy.isEmpty();
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Integer next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return copy.delMin();
    }
  }


  public static void main(String[] args) {
    // insert a bunch of strings
    String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };

    MyIndexMinPQ<String> pq = new MyIndexMinPQ<String>(strings.length);
    for (int i = 0; i < strings.length; i++) {
      pq.insert(i, strings[i]);
    }

    // delete and print each key
    while (!pq.isEmpty()) {
      int i = pq.delMin();
      StdOut.println(i + " " + strings[i]);
    }
    StdOut.println();

    // reinsert the same strings
    for (int i = 0; i < strings.length; i++) {
      pq.insert(i, strings[i]);
    }

    // print each key using the iterator
    for (int i : pq) {
      StdOut.println(i + " " + strings[i]);
    }
    while (!pq.isEmpty()) {
      pq.delMin();
    }

  }

}
