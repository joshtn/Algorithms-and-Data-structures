package Lab_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;


/**
 * @Author Josh
 * @Made 18/9/2019
 * @ProblemSolved Using insertion sort from chapter 2.1 to sort a array of integers, prints each swap.
 * user can choose array size and content.
 * @HowToUse follow the instruction on screen.
 * @BasedOn Algoritms 4th edition and lectures.
 */
public class InsertionSort_1 {

    /**
     * Tests
     * input = {1,2,4,3,5,0}
     * //
     * [1, 2, 3, 4, 5, 0]
     * [1, 2, 3, 4, 0, 5]
     * [1, 2, 3, 0, 4, 5]
     * [1, 2, 0, 3, 4, 5]
     * [1, 0, 2, 3, 4, 5]
     * [0, 1, 2, 3, 4, 5]
     * //
     *
      * @param args
     */
public static void main(String[] args) {

    //int[] arrayToSort = {1,2,4,3,5,0};
    //insertionSort(arrayToSort);


    //StdOut.println("Here is the sorted array: " + Arrays.toString(arrayToSort));
    StdOut.println("Here is the sorted array: " + Arrays.toString(insertionSort( userArray() )));

}

    /**
     * Insertion sort
     * @param arrayToSort the array that is going to be sorted
     * @return the array sorted in acending order.
     */
    public static int[] insertionSort(int[] arrayToSort) {
    int arrLength = arrayToSort.length;
    for (int i = 0; i < arrLength; i++) {
        for (int j = i; j > 0; j--) {
            if (less(arrayToSort[j], arrayToSort[j-1]) ) {
                swap(arrayToSort, j, j-1);
                StdOut.println(Arrays.toString(arrayToSort));
            }
            else { break; }
        }
    }
    return arrayToSort;
}

    /**
     * Compares if a < b
     * @param a is value at j
     * @param b is value at j-1
     * @return true if a < b, otherwise false.
     */
    private static boolean less(int a, int b) {
    return a < b;
}

    /**
     * Switches places of j and j-1.
     * @param arrayToSort
     * @param j
     * @param k is j-1
     */
    private static void swap(int[] arrayToSort, int j, int k) {
        int jHolder = arrayToSort[j];
        arrayToSort[j] = arrayToSort[k];
        arrayToSort[k] = jHolder;
}

    /**
     * Creates a array where the user specifies size and its content.
     * @return the array the user made.
     */
    public static int[] userArray() {
        StdOut.println("Size of input: ");
        int number = StdIn.readInt();
        int[] arrayUser = new int[number];
        StdOut.println("Input integers one at a time: ");
        for (int i = 0; i < number; i++) {
            arrayUser[i] = StdIn.readInt();
        }

    return arrayUser;
    }


}
