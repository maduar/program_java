package statck;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 20/06/2017.
 */
public class Test {
  public static void main(String[] args) {
    Mystack<String> mys = new Mystack<String >();
    while(!StdIn.isEmpty()) {
      String t = StdIn.readString();
      mys.push(t);
    }

    for(String s : mys) {
      StdOut.print(s + " ");
    }
  }
}
