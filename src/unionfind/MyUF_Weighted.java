package unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 20/06/2017.
 */
public class MyUF_Weighted {
  private int[] id;
  private int[] sz;
  private int count;

  public MyUF_Weighted(int N) {
    count = N;
    id = new int[N];
    for(int i =0; i < N; i++) {
      id[i] = i;
    }

    sz = new int[N];
    for(int i =0; i < N; i++) {
      sz[i] = 1;
    }
  }

  public int count() {
    return count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  private  int find(int p) {
    while(p != id[p]) {
      id[p] = id[id[p]];
      p = id[p];
    }
    return p;
  }

  public void union(int p, int q) {
    int i = find(p);
    int j = find(q);
    if (i == j) return;

    if (sz[i] < sz[j]) {
      id[i] = j;
      sz[j] += sz[i];
    } else {
      id[j] = i;
      sz[i] += sz[j];
    }

    count--;
  }

  public static void main(String[] args) {
    int N = StdIn.readInt();
    MyUF_Weighted uf = new MyUF_Weighted(N);
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
