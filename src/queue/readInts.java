package queue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by maduar on 19/06/2017.
 */
public class readInts {

  public static int[] readInts() {

    MyQueue<Integer> q = new MyQueue<Integer>();
    while (!StdIn.isEmpty()) {
      q.enqueue(StdIn.readInt());
    }

    System.out.println(q.toString());

    int N = q.size();
    int[] a = new int[N];

    for (int i = 0; i < N; i++) {
      a[i] = q.dequeue();
    }

    return a;
  }

  public static void main(String[] args) {
    int[] a = readInts();
    for (Integer i : a) {
      System.out.println("i = " + i);
    }
  }
}
