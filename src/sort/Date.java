package sort;

/**
 * Created by maduar on 21/06/2017.
 */
public class Date implements Comparable<Date>{
  private final int day;
  private final int month;
  private final int year;

  public Date(int d, int m, int y) {
    day = d;
    month = m;
    year = y;
  }

  public int day() {
    return day;
  }

  public int month() {
    return month;
  }

  public int year() {
    return year;
  }

  @Override
  public int compareTo(Date that) {

    if (this.year > that.year) {
      return +1;
    }
    
    if (this.year < that.year) {
      return -1;
    }

    if (this.month > that.month) {
      return +1;
    }

    if (this.month < that.month) {
      return -1;
    }

    if (this.day > that.day) {
      return +1;
    }

    if (this.day < that.day) {
      return -1;
    }

    return 0;
  }

  public String toString() {
    return month + "/" + day + "/" + year;
  }

  public static void main(String[] args) {
    Date d = new Date(12, 6, 2017);
    Date d2 = new Date(22, 7, 2017);

    int temp1 = d.compareTo(d2);
    int temp2 = d2.compareTo(d);

    System.out.println("temp1 => " + temp1);
    System.out.println("temp2 => " + temp2);
  }
}
