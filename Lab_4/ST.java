package Lab_4;



import java.util.Iterator;
import java.util.TreeMap;

/**
 * A lighter version of ST used for SymbolGraph. based on algorithms 4th edition
 * @param <Key>
 * @param <Value>
 */
public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private TreeMap<Key, Value> st; // treemap is good for sorting and storing key.value pairs

    /**
     * Initializes an empty symbol table
     */
    public ST() { st = new TreeMap<Key, Value>(); }

    /**
     * Returns the value associated with the given key in this symbol table.
     * @param key
     * @return
     */
    public Value get(Key key) {
        return st.get(key);
    }

    /**
     * insert specified key-value pair into ST.
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        st.put(key, val);
    }

    /**
     * Returns true if ST contains given key.
     * @param key
     * @return
     */
    public boolean contains(Key key) {
        return st.containsKey(key);
    }

    /**
     * Returns number of key-value pairs in ST
     * @return
     */
    public int size() { return st.size(); }

    /**
     * returns all keys in ST
     * @return
     */
    public Iterable<Key> keys() { return st.keySet(); }

    /**
     *
     * @return
     * @deprecated replaced by keys()
     */
    @Deprecated
    public Iterator<Key> iterator() { return st.keySet().iterator(); }

}
