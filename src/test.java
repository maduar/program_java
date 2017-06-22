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

    System.out.println(cmp(a, b));
  }

}
