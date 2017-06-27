package ST;

import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.Queue;

/**
 * Created by maduar on 27/06/2017.
 */
public class MyBinarySearchST<Key extends Comparable<Key>, Value> {
  private Key[] keys;
  private Value[] vals;
  private int N;

  public MyBinarySearchST(int capacity) {
    keys = (Key[]) new Comparable[capacity];
    vals = (Value[]) new Comparable[capacity];
  }

  public int size() {
    return N;
  }

  public Value get(Key key) {
    if(isEmpty()) {
      return null;
    }

    int i = rank(key);
    if(i < N && keys[i].compareTo(key) == 0 ) {
      return vals[i];
    } else {
      return null;
    }
  }

  public int rank(Key key){
    int lo = 0;
    int hi = N - 1;

    while(lo <= hi) {
      int mid = lo + (lo + hi) / 2;
      int cmp = key.compareTo(keys[mid]);
      if (cmp < 0) {
        return rank(key, lo, mid);
      } else if (cmp > 0) {
        return rank(key, mid + 1, hi);
      } else {
        return mid;
      }
    }
    return lo;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public  void put(Key key, Value val) {

  }

  public int rank(Key key, int lo, int hi) {
    if(hi < lo) return lo;

    int mid = lo + (lo + hi) / 2;
    int cmp = key.compareTo(keys[mid]);

    if(cmp < 0) {
      return  rank(key, lo, mid);
    } else if (cmp > 0) {
      return rank(key, mid + 1, hi);
    } else {
      return mid;
    }
  }

  public Key min() {
    return keys[0];
  }

  public Key max() {
    return keys[N -1];
  }

  public Key select(int k) {
    return keys[k];
  }

  public Key ceiling(Key key) {
    int i = rank(key);
    return keys[i];
  }

  public Key floor(Key key) {
    return key;
  }

  public Key delete(Key key) {
    return key;
  }

  public boolean contains(Key key) {
    if (isEmpty()) throw new NoSuchElementException();
    return this.get(key) != null;
  }

  public Iterable<Key> Keys(Key lo, Key hi) {
    Queue<Key> q = new Queue<Key>();
    for(int i = rank(lo); i < rank(hi); i++) {
      q.enqueue(keys[i]);
    }

    if(contains(hi)) {
      q.enqueue(keys[rank(hi)]);
    }
    return q;
  }

  public static void main(String[] args) {
    MyBinarySearchST<String, String> mmst = new MyBinarySearchST<String, String>(10);
    mmst.put("1", "g");
    mmst.put("2", "haha");
    System.out.println(mmst.get("1"));
  }
}
