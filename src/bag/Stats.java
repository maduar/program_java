package bag;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by maduar on 19/06/2017.
 */
public class Stats {
    public static void main(String[] args) {
        MyBag<Double> numbers = new MyBag<Double>();
        while(!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }

        int N = numbers.size();

        double sum = 0.0;
        for(double x: numbers) {
            sum += x;
        }

        double mean = sum / N;

        sum = 0.0;
        for(double x : numbers) {
            sum += (x - mean) * (x - mean);
        }

        double std = Math.sqrt(sum / (N - 1));

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
