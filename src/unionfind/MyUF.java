package unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 20/06/2017.
 */
public class MyUF {
  public int[] id;
  public int count;



  public MyUF(int N) {
    if (N < 0) throw new IllegalArgumentException();
    count = N;
    id = new int[N];
    for(int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public int find(int p) {
    return id[p];
  }

  public void union(int p, int q) {
    int pID = find(p);
    int qID = find(q);

    if (pID == qID) return;

    for(int i =0; i < id.length; i++) {
      if (find(i) == pID) {
        id[i] = qID;
      }
    }
    count--;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int count() {
    return count;
  }

  public static void main(String[] args) {
    int N = StdIn.readInt();
    MyUF uf = new MyUF(N);
    while(!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();

      if(uf.connected(p, q)) {
        continue;
      }

      uf.union(p, q);
      StdOut.println(p + "-" + q);
    }
    StdOut.println(uf.count() + " components");
  }
}
