package ST;

import bag.MyBag;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by maduar on 27/06/2017.
 */
public class SequentialSearchST<Key, Value>{
  private Node first;

  private class Node{
    Key key;
    Value val;
    Node next;

    public Node(Key key, Value val, Node next) {
      this.key = key;
      this.val = val;
      this.next = next;
    }
  }

  public Value get(Key key) {
    for(Node x = first; x != null; x = x.next) {
      if(key.equals(x.key)) {
        return x.val;
      }
    }
    return null;
  }

  public void put(Key key, Value val) {
    for(Node x = first; x != null; x = x.next) {
      if(key.equals(x.key)) {
        x.val = val;
        return;
      }
    }
    first = new Node(key, val, first);
  }



  public static void main(String[] args) {
    SequentialSearchST<String, String>  ssst = new SequentialSearchST<String, String>();
    ssst.put("k1", "OK");
    System.out.println(ssst.get("k1"));
  }
}
