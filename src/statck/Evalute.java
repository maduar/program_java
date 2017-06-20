package statck;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 19/06/2017.
 */
public class Evalute {
  public static void main(String[] args) {
    Mystack<String> ops = new Mystack<String>();
    Mystack<Double> vals = new Mystack<Double>();
    while(!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("(")) {
        ;
      } else if (s.equals("+")) {
        ops.push(s);
      } else if (s.equals("-")) {
        ops.push(s);
      } else if (s.equals("*")) {
        ops.push(s);
      } else if (s.equals("/")) {
        ops.push(s);
      } else if (s.equals("sqrt")) {
        ops.push(s);
      } else if (s.equals(")")) {
        String op = ops.pop();
        double v = vals.pop();

        if (op.equals("+")) {
          v = vals.pop() + v;
        } else if (op.equals("-")) {
          v = vals.pop() - v;
        }else if (op.equals("*")) {
          v = vals.pop() * v;
        }else if (op.equals("/")) {
          v = vals.pop() / v;
        }else if (op.equals("sqrt")) {
          v = Math.sqrt(v);
        }
        vals.push(v);
      } else {
        vals.push(Double.parseDouble(s));
      }
    }


    StdOut.println(vals.pop());
  }
}
