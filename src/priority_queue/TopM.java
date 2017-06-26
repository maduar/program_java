package priority_queue;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

/**
 * Created by maduar on 23/06/2017.
 */
public class TopM {
  public static void main(String[] args) {
    int M = Integer.parseInt(args[0]);
    MyTopM<Transaction> pq = new MyTopM<Transaction>(M+1);
    while (StdIn.hasNextLine())
    {  // Create an entry from the next line and put on the PQ.
      pq.insert(new Transaction(StdIn.readLine()));
      if (pq.size() > M)
          pq.delMax();
//        pq.delMin();     // Remove minimum if M+1 entries on the PQ.
    }  // Top M entries are on the PQ.
    Stack<Transaction> stack = new Stack<Transaction>();
    while (!pq.isEmpty()) stack.push(pq.delMax());
    for (Transaction t : stack) StdOut.println(t);
  }
}
