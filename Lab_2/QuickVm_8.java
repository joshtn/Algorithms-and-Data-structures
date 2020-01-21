package Lab_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @Author Josh
 * @Made 21/9/2019
 * @ProblemSolved Comparing quicksort and mergesort with large inputs.
 * @HowToUse -
 * @BasedOn Algoritms 4th edition and lectures.
 */
public class QuickVm_8 {

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // shuffle to make sure performance will be good
        sort(a, 0, a.length - 1);

    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1); // left part
        sort(a, j+1, hi); // right part

    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // print array to standard output
    private static void print(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Tests:
     * //
     * 1000 ints, time 0.002
     * 10 000 ints, time 0.017
     * 100 000 ints, time 0.095
     * 1 000 000 ints, time 0.818
     * 5 000 000 ints, time 4.699
     * //
     * @param args
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Stopwatch sw = new Stopwatch();
        QuickVm_8.sort(a);
        StdOut.print(sw.elapsedTime());
        //print(a);


    }
}
