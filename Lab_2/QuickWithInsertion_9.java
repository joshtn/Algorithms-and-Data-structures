package Lab_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @Author Josh
 * @Made 21/9/2019
 * @ProblemSolved Using insertion sort with quicksort and experimenting with cutoff
 * @HowToUse -
 * @BasedOn Algoritms 4th edition and lectures.
 */
public class QuickWithInsertion_9 {

    // cutoff to insertion sort
    private static final int INSERTION_SORT_CUTOFF = 2;

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
       StdRandom.shuffle(a); // shuffle to make sure performance will be good
        sort(a, 0, a.length - 1);

    }

    // quicksort the subarray from a[lo] to a[hi]
    // added insertion sort
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;

        int n = hi - lo + 1;
        if (n <= INSERTION_SORT_CUTOFF) {
            insertionSort(a, lo, hi + 1);
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j-1); // left part
        sort(a, j+1, hi); // right part

    }

    // insertions sort
    public static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }

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

    // checks if v < w ?
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
     * Without insertion sort
     * 1000 ints, time 0.002
     * 10 000 ints, time 0.017
     * 100 000 ints, time 0.095
     * 1 000 000 ints, time 0.818
     * 5 000 000 ints, time 4.699
     * //
     * With insertion sort
     * input used 1 000 000 ints
     *  cutoff 0, time 0.868
     *  cutoff 2, time 0.836
     *  cutoff 5, time 0.871
     *  cutoff 7, time 0.826
     *  cutoff 9, time 0.858
     *  cutoff 10, time 0.815
     *  cutoff 11, time 0.957
     *  cutoff 12, time 0.893
     *  cutoff 15, time 0.837
     *  cutoff 20, time 0.969
     *  cutoff 25, time 0.839
     *  cutoff 30, time 0.862
     *  cutoff 50, time 1.137
     *  cutoff 100, time 1.048
     *  cutoff 250, time 1.623
     * @param args
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Stopwatch sw = new Stopwatch();
        QuickWithInsertion_9.sort(a);
        StdOut.print(sw.elapsedTime());
        //print(a);


    }
}