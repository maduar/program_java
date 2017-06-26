package ST;

import edu.princeton.cs.algs4.ST;
/**
 * Created by maduar on 26/06/2017.
 */
public class StDemo {
  public static void main(String[] args) {
    MyST<Integer, String> st = new MyST<Integer, String>();
    st.put(100, "abc");
    st.put(200, "cococ");

    for(Integer i : st) {
      System.out.print("i = " + i + "; value = " + st.get(i) + "\n");
    }
  }
}
