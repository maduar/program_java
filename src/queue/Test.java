package queue;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 20/06/2017.
 */
public class Test {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<String>();

    while(!StdIn.isEmpty()) {
      stack.push(StdIn.readString());
    }

    StdOut.println();
    for(String s : stack) {
      StdOut.print(s + " ");
    }

  }
}
