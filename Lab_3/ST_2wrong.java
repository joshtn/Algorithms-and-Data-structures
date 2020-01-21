package Lab_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.TreeMap;


/**
 * @Author Josh
 * @Made 28/9/2019
 * @ProblemSolved Using insertion sort from chapter 2.1 to sort a array of integers, prints each swap.
 * user can choose array size and content.
 * @HowToUse follow the instruction on screen.
 * @BasedOn Algoritms 4th edition and lectures.
 */
public class ST_2wrong<Key extends Comparable<Key>, Value> {

    private TreeMap<Key, Value> st;

    /**
     * Initializes an empty symbol table.
     */
    public ST_2wrong() {
        st = new TreeMap<Key, Value>();
    }

    /**
     * returns the value associated with the given key.
     * @param key
     * @return value for that key else null
     */
    public Value get(Key key) {
        if (key == null) { throw new IllegalArgumentException("calls get() with null key"); }

        return st.get(key);
    }

    /**
     * Adds the key-value pair to symbol table.
     * Will update to new value if key already exists.
     * //if value is null, the key will be deleted.
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        if (key == null) { throw new IllegalArgumentException("calls put() with null key"); }
        // if (value == null) { st.remove(key); }
        else { st.put(key, value); }
    }

    /**
     * Deletes key with its value if there exist such a key.
     * @param key
     */
    public void delete(Key key) {
        if (key == null) { throw new IllegalArgumentException("calls delete() with null key"); }

        st.remove(key);
    }

    // contains() not implemented
    // size() not implmeented
    // isempty() not implmented
    // iterable not implemented
    // min() not implemented
    // max() not implemented
    // ceiling() not implemented
    // floor() not implemented

    public static void main(String[] args) {

        ST_2wrong<String, Integer> st = new ST_2wrong<>();
        int n = 10; // how many words to read
            for (int i = 0; i < n; i++) {
                if (StdIn.readString() == null) { break; }
                String key = StdIn.readString();
                st.put(key, i);
                StdOut.println("[" + key + "]" + "[" + i + "]");
            }
            StdOut.println(st.get("This"));

    }


}
