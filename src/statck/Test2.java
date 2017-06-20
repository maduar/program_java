package statck;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 20/06/2017.
 */
public class Test2 {
  public static void main(String[] args) {
    Mystack<Integer> stack = new Mystack<Integer>();
    Mystack<Integer> stack2 = new Mystack<Integer>();
    int N = 50;
    while (N > 0) {
      stack.push(N % 2);
      stack2.push(N);
      N = N / 2;
    }

    for (int d : stack) {
      StdOut.print(d + " ");
    }
    StdOut.println();
    for (int d : stack2) {
      StdOut.print(d + " ");
    }
    StdOut.println();
  }
}
