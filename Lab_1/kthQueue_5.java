package Lab_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @Author: Josh
 * @Made: 7/9/2019
 * @ProblemSolved: Generalized lifo queue that lets the user remove the k'th element. Index 1 is most recently added element.
 * @HowToUse: Add elements to queue with add(). Then use delKth(index) to delete element with specified index.
 * @BasedOn: Algorithms 4th edition.
 */


public class kthQueue_5<Item> implements Iterable<Item> {

    private Node first;
    private int n;

    private class Node {
        private Node next;
        private Item item;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.n;
    }

    /**
     * adds item to queue.
     * @param item
     */
    public void add(Item item) {
        if (this.isEmpty()) {
            this.first = new Node();
            this.first.item = item;
        } else {
            Node oldFirst = this.first;
            this.first = new Node();
            this.first.item = item;
            this.first.next = oldFirst;
        }
        this.n++;
    }

    /**
     * deletes the first item in the queue.
     * @return
     */
    public Item del() {
        if (this.isEmpty()) {
            return null;
        }
        Item item = this.first.item;
        this.first = first.next;
        this.n--;

        return item;
    }

    /**
     * Deletes the element with the given index.
     * @param index
     * @return
     */
    public boolean delKth(Integer index) {
        if (index < 1) {
            return false;
        }
        if (index == 1) {
            this.del();

            return true;
        }
        Node prev = null;
        Node current = this.first;

        for (int i = 1; i < index; i++) {
            if (current.next == null) {
                return false;
            }
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        current = null;
        this.n--;

        return true;

    }

    /**
     * iterator
     */
    private class kthIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext() { return current != null; }

        public Item next() {
            Item item = current.item;
            current = current.next;


            return item;
        }
    }

    /**
     * queue elements gets returned as string.
     * @return
     */
    @Override
    public String toString(){
        String s = "[" + this.first.item + "],";
        Node temp = this.first.next;
        while (temp != null) {
            s += "[" + temp.item + "],";
            temp = temp.next;
        }
        return s.substring(0, s.length() - 1);
    }

    public Iterator<Item> iterator() { return new kthIterator(); }

    /**
     * Tests
     *
     * Inserting ints 1,2,3,4,5,5. Then taking away one 5 with the normal delete function. After that deleting elements
     * at index 2 then index 3 which are 2,4.
     *
     * @Result: left with odd integers
     * ITERATOR ANV INTE??? äre ok.
     * @param args
     */
    public static void main(String[] args) {

        kthQueue_5<Integer> queue = new kthQueue_5<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        StdOut.println(queue.toString());
        queue.add(5);
        StdOut.println(queue.toString());
        queue.del();
        StdOut.println(queue.toString());
        queue.delKth(2);
        StdOut.println(queue.toString());
        queue.delKth(3);
        StdOut.println(queue.toString());

    }
}