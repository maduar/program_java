import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 22/06/2017.
 */
public class test {

  public static int cmp(Comparable a, Comparable b) {
    return a.compareTo(b);
  }

  public static void main(String[] args) {
    String a = "2015";
    String b = "2016";

    Comparable[] arr = new Comparable[10];
    for(int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }

    for(int i = 0; i < arr.length; i++) {
      System.out.println("i = " + arr[i]);
    }

    System.out.println(cmp(a, b));
  }

}



