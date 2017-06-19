package statck;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by maduar on 19/06/2017.
 */
public class Reverse {
  public static void main(String[] args) {
    Mystack<Integer> stack = new Mystack<Integer>();
    while(!StdIn.isEmpty()) {
      stack.push(StdIn.readInt());
    }

    for(int i : stack) {
      StdOut.println(i);
    }
  }
}
