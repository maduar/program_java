package FixedCapcity;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 20/06/2017.
 */
public class Fixed {

  public static void main(String[] args) {
    FixedCapacityStackOfStrings s;
    s = new FixedCapacityStackOfStrings(100);
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (s.equals("-")) {
        s.push(item);
      } else if (!s.isEmpty()) {
        StdOut.print(s.pop() + " ");
      }
    }
    StdOut.print("(" + s.size() + "left on stack");
  }
}
