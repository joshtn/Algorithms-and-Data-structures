package Lab_4;

import java.util.Iterator;

/**
 * bag of generic items, using singly linked list
 */
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first; // start of bag
    private int n; // num of elements

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * initilizes an empty bag
     */
    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() { return first == null; }

    public int size() { return n; }

    /**
     * add item to bag
     * @param item
     */
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
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
