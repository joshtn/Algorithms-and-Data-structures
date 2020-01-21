package Lab_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @Author Josh
 * @Made 18/9/2019
 * @ProblemSolved Using insertion sort from chapter 2.1 to sort a array of integers,
 * prints each swap, in descending order.
 * * >>Using same code as Q3 BUT added method for counting inversions (inversions). .<< **
 * user can choose array size and content.
 * @HowToUse follow the instruction on screen.
 * @BasedOn Algoritms 4th edition and lectures.
 */
public class InsertionSortInversions_4 {
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
     * After sorting the array in descending order:
     * //
     * [5, 4, 3, 2, 1, 0]
     * //
     * Swaps made: 6
     * //
     * Here are the inversions:
     * [0,1], [5,0]
     * [1,2], [5,0]
     * [2,4], [3,3]
     * [2,4], [5,0]
     * [3,3], [5,0]
     * [4,5], [5,0]
     * //
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] arrayToSort = {1,2,4,3,5,0};
        inversions(arrayToSort);
        //insertionSort(arrayToSort);


        //StdOut.println("Here is the sorted array: " + Arrays.toString(arrayToSort));
        //StdOut.println("Here is the sorted array: " + Arrays.toString(insertionSort( userArray() )));
        StdOut.println("Here is the sorted array in descending order (reverse): " + Arrays.toString(descendingArray(insertionSort( arrayToSort ))));
    }

    /**
     * Insertion sort
     * @param arrayToSort the array that is going to be sorted
     * @return the array sorted in acending order.
     */
    public static int[] insertionSort(int[] arrayToSort) {
        int arrLength = arrayToSort.length;
        int swaps = 0;
        for (int i = 0; i < arrLength; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arrayToSort[j], arrayToSort[j-1]) ) {
                    swap(arrayToSort, j, j-1);
                    StdOut.println(Arrays.toString(arrayToSort));
                    swaps++;
                }
                else { break; }
            }
        }
        StdOut.println("Swaps made: " + swaps);
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

    /**
     * Reverses the array so it is sorted in descedning order.
     * most left element and most right element changes place. increment to the center "both directions"
     * and do the same.
     * @param arr array to reverse
     * @return reversed array
     */
    public static int[] descendingArray(int[] arr){
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length -1 -i];
            arr[arr.length -1 -i] = temp;
        }

        return arr;
    }

    /**
     * Counts inversion of given array and prints out the number.
     * start from begining of array. compare each index value with the rest to the right.
     * @param arr array
     */
    public static void inversions(int[] arr) {
        int inv = 0;
        StdOut.println("Here are the inversions: \n" + "[i,v]  [i,v]");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    StdOut.println("[" + i + "," + arr[i] + "], [" + j + "," + arr[j] + "]");
                    inv++;
                }
            }
        }
        StdOut.println("Total inversions: " + inv);
    }


}

