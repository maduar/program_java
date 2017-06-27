package ST;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 26/06/2017.
 */
public class FrequencyCounter {
  public static void main(String[] args) {
    int minlen = Integer.parseInt(args[0]);
    MyST<String, Integer> st = new MyST<String, Integer>();

    while (!StdIn.isEmpty()) {
      String word = StdIn.readString();

      if(word.length() < minlen) {
        continue;
      }

      if (!st.coontains(word)) {
        st.put(word, 1);
      } else {
        st.put(word, st.get(word) + 1);
      }
    }

    String max = " ";
    st.put(max, 0);
    for(String word : st.keys()) {
      if (st.get(word) > st.get(max)) {
        max = word;
      }
    }

    StdOut.print(max + " " + st.get(max));
  }
}
