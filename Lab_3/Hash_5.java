package Lab_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author Josh
 * @Made 29/9/2019
 * @ProblemSolved Testing how evenly built javas hash function is.
 * @HowToUse run main, change value of how many strings you want to read.
 * @BasedOn Algoritms 4th edition and lectures.
 */
public class Hash_5 {
    /**
     * Frequency Counter
     * @param minLength
     */
    public static void FrequencyCounter(int minLength, int n) {
        int distinct = 0, words = 0;
        int hashes = 0;

        ST_2<Integer, Integer> sTi = new ST_2<>();

        // compute frequency counts
        for (int i = 0; i < n; i++) { // changed to a for loop instead of while, can choose n words to read
            String key = StdIn.readString();
            int key_i = key.hashCode();
            if (key.length() < minLength)  continue;
            words++;

            if (sTi.contains(key_i)) { // if key exists then increment the value "counter"
                sTi.put(key_i, sTi.get(key_i) + 1);
            }
            else { // new key to the symbol table
                sTi.put(key_i, 1);
                distinct ++;
            }
            hashes++;
        }

        // find a key with the highest frequency count
        //String max = "";
        int max = 0;
        sTi.put(max, 0);
        for (int word : sTi.keys()) {
            if (sTi.get(word) > sTi.get(max)) {
                max = word;
            }
        }

        StdOut.println(max + " " + sTi.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words   = " + words);
        StdOut.println("hashes   = " + hashes);
        StdOut.println("THE DISTRIBUTION-------------------- ");
        for (Integer s : sTi.keys())
            StdOut.println("[" + s + "]-" + "[" + sTi.get(s) + "]");
    }

    /**
     * 3543 3
     * distinct = 18
     * words   = 20
     * hashes   = 20
     * THE DISTRIBUTION--------------------
     * [-1891246364]-[1]
     * [-1845344797]-[1]
     * [-973481475]-[1]
     * [0]-[0]
     * [65]-[1]
     * [3159]-[1]
     * [3370]-[1]
     * [3543]-[3]
     * [84524]-[1]
     * [101577]-[1]
     * [114801]-[1]
     * [116103]-[1]
     * [2599110]-[1]
     * [2605758]-[1]
     * [65799374]-[1]
     * [95352046]-[1]
     * [1137494663]-[1]
     * [1355342585]-[1]
     * [1944810738]-[1]
     * running time: 119
     * @param args
     */
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        FrequencyCounter(1, 20);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        StdOut.println("running time: " + totalTime);

    }

}
