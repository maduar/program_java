package ST;

import edu.princeton.cs.algs4.BTree;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 29/06/2017.
 */
public class MyRBTree<Key extends Comparable<Key>, Value> {

  private Node root;

  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private class Node {
    Key key;
    Value val;
    Node left, right;
    int N;
    boolean color;

    Node(Key key, Value val, int N, boolean color) {
      this.key = key;
      this.val = val;
      this.N = N;
      this.color = color;
    }
  }

  private Node rotateRight(Node h) {
    Node x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = h.color;
    h.color = RED;
    x.N = h.N;
    h.N = 1 + size(h.left)
        + size(h.right);
    return x;
  }

  private Node rotateLeft(Node h) {
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = h.color;
    h.color = RED;
    x.N = h.N;
    h.N = 1 + size(h.left)
        + size(h.right);
    return x;
  }

  public void put(Key key, Value val) {
    root = put(root, key, val);
    root.color = BLACK;
  }

  private Node put(Node h, Key key, Value val) {
    if (h == null)  // Do standard insert, with red link to parent.
    {
      return new Node(key, val, 1, RED);
    }
    int cmp = key.compareTo(h.key);
    if (cmp < 0) {
      h.left = put(h.left, key, val);
    } else if (cmp > 0) {
      h.right = put(h.right, key, val);
    } else {
      h.val = val;
    }
    if (isRed(h.right) && !isRed(h.left)) {
      h = rotateLeft(h);
    }
    if (isRed(h.left) && isRed(h.left.left)) {
      h = rotateRight(h);
    }
    if (isRed(h.left) && isRed(h.right)) {
      flipColors(h);
    }
    h.N = size(h.left) + size(h.right) + 1;
    return h;
  }

  private void flipColors(Node h) {
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
  }

  private boolean isRed(Node x) {
    if (x == null) {
      return false;
    } else {
      return x.color == RED;
    }
  }

  public int size() {
    return size(root);
  }

  public int size(Node x) {
    if (x == null) {
      return 0;
    } else {
      return x.N;
    }
  }

  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    if (node == null) {
      return null;
    }

    int cmp = key.compareTo(node.key);
    if (cmp > 0) {
      return get(node.right, key);
    } else if (cmp < 0) {
      return get(node.left, key);
    } else {
      return node.val;
    }
  }

  public static void main(String[] args) {
    MyRBTree<String, String> st = new MyRBTree<String, String>();

    st.put("www.cs.princeton.edu", "128.112.136.12");
    st.put("www.cs.princeton.edu", "128.112.136.11");
    st.put("www.princeton.edu", "128.112.128.15");
    st.put("www.yale.edu", "130.132.143.21");
    st.put("www.simpsons.com", "209.052.165.60");
    st.put("www.apple.com", "17.112.152.32");
    st.put("www.amazon.com", "207.171.182.16");
    st.put("www.ebay.com", "66.135.192.87");
    st.put("www.cnn.com", "64.236.16.20");
    st.put("www.google.com", "216.239.41.99");
    st.put("www.nytimes.com", "199.239.136.200");
    st.put("www.microsoft.com", "207.126.99.140");
    st.put("www.dell.com", "143.166.224.230");
    st.put("www.slashdot.org", "66.35.250.151");
    st.put("www.espn.com", "199.181.135.201");
    st.put("www.weather.com", "63.111.66.11");
    st.put("www.yahoo.com", "216.109.118.65");


    StdOut.println("www.cs.princeton.edu :  " + st.get("www.cs.princeton.edu"));
    StdOut.println("www.princeton.edu :  " + st.get("www.princeton.edu"));
    StdOut.println("www.yale.edu :  " + st.get("www.yale.edu"));
    StdOut.println("hardvardsucks.com: " + st.get("www.harvardsucks.com"));
    StdOut.println("simpsons.com:      " + st.get("www.simpsons.com"));
    StdOut.println("apple.com:         " + st.get("www.apple.com"));
    StdOut.println("ebay.com:          " + st.get("www.ebay.com"));
    StdOut.println("dell.com:          " + st.get("www.dell.com"));
    StdOut.println();

    StdOut.println("size:    " + st.size());
//    StdOut.println("height:  " + st.height());
    StdOut.println(st);
    StdOut.println();
  }
}
