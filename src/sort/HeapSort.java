package sort;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 26/06/2017.
 */
public class HeapSort {
  private HeapSort() { }

  /**
   * Rearranges the array in ascending order, using the natural order.
   * @param pq the array to be sorted
   */
  public static void sort(Comparable[] pq) {
    int n = pq.length;
    for (int k = n/2; k >= 1; k--)
      sink(pq, k, n);
    while (n > 1) {
      exch(pq, 1, n--);
      sink(pq, 1, n);
    }
  }

  /***************************************************************************
   * Helper functions to restore the heap invariant.
   ***************************************************************************/

  private static void sink(Comparable[] pq, int k, int n) {
    while (2*k <= n) {
      int j = 2*k;
      if (j < n && less(pq, j, j+1)) j++;
      if (!less(pq, k, j)) break;
      exch(pq, k, j);
      k = j;
    }
  }

  /***************************************************************************
   * Helper functions for comparisons and swaps.
   * Indices are "off-by-one" to support 1-based indexing.
   ***************************************************************************/
  private static boolean less(Comparable[] pq, int i, int j) {
    return pq[i-1].compareTo(pq[j-1]) < 0;
  }

  private static void exch(Object[] pq, int i, int j) {
    Object swap = pq[i-1];
    pq[i-1] = pq[j-1];
    pq[j-1] = swap;
  }

  // print array to standard output
  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
  }

  public static void main(String[] args) {
    String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"} ;
    sort(a);
//    assert isSorted(a);
    show(a);
  }
}
