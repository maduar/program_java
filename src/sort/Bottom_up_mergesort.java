package sort;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 23/06/2017.
 */
public class Bottom_up_mergesort {

  private static Comparable[] aux;

  private static void sort(Comparable[] a) {  // Sort a[lo..hi].
    int N = a.length;
    aux = new Comparable[N];

    for(int sz = 1; sz < N; sz = sz + sz) {
      for(int lo = 0; lo < N -sz; lo += sz + sz) {
        merge1(a, lo, lo + sz - 1, Math.min(lo + sz + sz -1, N -1));
      }
    }
  }

  public static void merge1(Comparable[] a, int lo, int mid, int hi) {
    int newLo = lo, newMid = mid + 1;
    for (int index = lo; index <= hi; index++)  // Copy a[lo..hi] to aux[lo..hi].
    {
      aux[index] = a[index];
    }
    for (int index = lo; index <= hi; index++)  // Merge bacindex to a[lo..hi].
    {
      if (newLo > mid) {
        a[index] = aux[newMid++];
      } else if (newMid > hi) {
        a[index] = aux[newLo++];
      } else if (less(aux[newMid], aux[newLo])) {
        a[index] = aux[newMid++];
      } else {
        a[index] = aux[newLo++];
      }
    }
  }

  private static  void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
  public static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void show (Comparable[] a) {
    for(int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  public static boolean isSorted(Comparable[] a) {
    for(int i = 1; i < a.length; i++) {
      if (less(a[i], a[i -1])) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"} ;
    String[] a = {"E", "E", "G", "M", "R", "A", "C", "E", "R", "T"} ;
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
