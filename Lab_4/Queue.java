package Lab_4;

import java.util.Iterator;

/**
 * fifo queue of generic items using singly linked list
 * based on algorithms 4th edition
 */
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first; // start of q
    private Node<Item> last; // end of q
    private int n; // num of items on q

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    // initializes an empty q
    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() { return first == null; }

    public int size() { return n; }

    /**
     * add item to q
     * @param item
     */
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added

     */
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }

        public Item next() {

            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
