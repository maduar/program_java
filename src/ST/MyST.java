package ST;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 * Created by maduar on 26/06/2017.
 */
public class MyST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
  private TreeMap<Key, Value> st;

  public MyST() {
    st = new TreeMap<Key, Value>();
  }

  public void put(Key key, Value value) {
    if (key == null) {
      throw new IllegalArgumentException("called put() with null key");
    }
    if (value == null) {
      st.remove(key);
    } else {
      st.put(key, value);
    }
  }

  public  Value get(Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called put() with null key");
    }

    return st.get(key);
  }

  public void delete(Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called put() with null key");
    }

    st.remove(key);
  }

  public boolean coontains(Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called put() with null key");
    }

    return st.containsKey(key);
  }

  public boolean isEmpty() {
    return st.isEmpty();
  }

  public int size() {
    return st.size();
  }

  public Iterable<Key> keys() {
    return st.keySet();
  }

  public Iterator<Key> iterator() {
    return st.keySet().iterator();
  }

  public Key min() {
    if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
    return st.firstKey();
  }

  public Key max() {
    if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
    return st.lastKey();
  }

  public Key ceiling(Key key) {
    if (key == null) throw new IllegalArgumentException("called ceiling() with null key");
    Key k = st.ceilingKey(key);
    if (k == null) throw new NoSuchElementException("all keys are less than " + key);
    return k;
  }

  public Key floor(Key key) {
    if (key == null) throw new IllegalArgumentException("called floor() with null key");
    Key k = st.floorKey(key);
    if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
    return k;
  }

}
