package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by maduar on 22/06/2017.
 */
public class SortCompare {
  public static double time(String alg, Comparable[] a) {
    Stopwatch timer = new Stopwatch();

    if (alg.equals("Insertion")) {
      Insertion.sort(a);
    }

    if (alg.equals("Selection")) {
      Selection.sort(a);
    }

    if (alg.equals("Merge")) {
      Selection.sort(a);
    }

    return timer.elapsedTime();
  }

  public static double timeRandomInput(String alg, int N, int T) {
    double total = 0.0;
    Double[] a = new Double[N];

    for(int t = 0; t < T; t++) {
      for(int i =0; i < N; i++) {
        a[i] = StdRandom.uniform();
      }
      total += time(alg, a);
    }

    return total;
  }

  public static void main(String[] args) {
    String alg1 = "Merge";
    String alg2 = "Shell";

    int N = 1000;
    int T = 1000;

    double t1 = timeRandomInput(alg1, N, T);
    double t2 = timeRandomInput(alg2, N, T);


    StdOut.println("t1 = " +  t1);
    StdOut.println("t2 = " +  t2);
    StdOut.println();
  }
}
