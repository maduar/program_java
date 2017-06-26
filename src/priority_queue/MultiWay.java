package priority_queue;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 26/06/2017.
 */
public class MultiWay {
  public static void merge(In[] streams) {
    int N = streams.length;
    MyIndexMinPQ<String> pq = new MyIndexMinPQ<String >(N);

    for(int i = 0; i < N; i++) {
      if(!streams[i].isEmpty()) {
        pq.insert(i, streams[i].readString());
      }
    }

    while(!pq.isEmpty()) {
      StdOut.println(pq.minKey());
      int i = pq.delMin();
      if(!streams[i].isEmpty()) {
        pq.insert(i, streams[i].readString());
      }
    }
  }

  public static void main(String[] args) {
    int N = args.length;
    In[] streams = new In[N];

    for(int i = 0; i < N; i++) {
      streams[i] = new In(args[i]);
    }

    merge(streams);
  }
}
