package Lab_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;


/**
 * @Author Josh
 * @Made 21/9/2019
 * @ProblemSolved Comparing mergesort with quicksort.
 * @HowToUse run program with same test input for both merge and quick and time them.
 * @BasedOn Algoritms 4th edition and lectures.
 */
public class MergeVq_8 {

    private static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {

        // copy to all of the array to the aux array.
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }

        // merge back into original array.
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                    { arr[k] = aux[j++]; }
            else if (j > hi)                { arr[k] = aux[i++]; }
            else if (less(aux[j], aux[i]))  { arr[k] = aux[j++]; }
            else                            { arr[k] = aux[i++]; }
        }
    }

    /**
     * recursive
     * @param arr
     * @param aux
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) { return; }
        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid); // sort first half of array
        sort(arr, aux, mid + 1, hi); // sort second half of array
        merge(arr, aux, lo, mid, hi);
    }

    /**
     * Creating aux array here, avoid unecessary memory usage
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length]; // create aux array
        sort(arr, aux, 0, arr.length-1);
    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // print array to standard output
    private static void print(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            StdOut.println(arr[i]);
        }
    }


    /**
     * Tests:
     * //
     * 1000 ints, time 0.001
     * 10 000 ints, time 0.012
     * 100 000 ints, time 0.172
     * 1 000 000 ints, time 0.885
     * 5 000 000 ints, time 4.234
     * //
     * @param args
     */
    public static void main(String[] args) {
        String[] arr = StdIn.readAllStrings();
        Stopwatch sw = new Stopwatch();
        MergeVq_8.sort(arr);
        StdOut.print(sw.elapsedTime());
        //print(arr);
    }
}
