package Lab_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author: Josh
 * @Made: 8/9/2019
 * @ProblemSolved: Ordered queue LIFO.
 * @HowToUse: Input integers to queue with add(). Use orderQueueArray() to sort the queue in ascending order.
 * @BasedOn: Algorithms 4th edition.
 */

public class OrderedQueue_6<Integer> implements Iterable<Integer> {

    private Node first;
    private int n;

    private class Node {
        private Node next;
        private Integer item;
    }

    //checks if queue is empty
    public boolean isEmpty() {
        return this.first == null;
    }

    // retruns size of the queue
    public int size() {
        return this.n;
    }

    // add item to queue
    public void add(Integer item) {
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

    // delete item form queue
    public Integer del() {
        if (this.isEmpty()) {
            return null;
        }
        Integer item = this.first.item;
        this.first = first.next;
        this.n--;

        return item;
    }

    /**
     * iterator
     */
    private class OrderedIterator implements Iterator<Integer>{
        private Node current = first;

        public boolean hasNext() { return current != null; }

        public Integer next() {
            Integer item = current.item;
            current = current.next;

            return item;
        }
    }

    public Iterator<Integer> iterator() { return new OrderedIterator(); }



    /**
     * Copies the queue to an array then sorts it. After puts the sorted array queue back to a queue.
     * @return string representation of the ordered queue.
     */
    public String orderQueueArray() {
        OrderedQueue_6<java.lang.Integer> queueOrdered = new OrderedQueue_6<>();
        int [] arrayQ = new int [this.size()];
        Node temp = first;


        for (int i = 0; i < arrayQ.length; i++) {
            arrayQ[i] = (int) temp.item;
            temp = temp.next;
        }

        Arrays.sort(arrayQ);

        // going thru from the highest to lowest since i have a lifo queue
        for (int i = arrayQ.length -1; i >= 0; i--) {
            queueOrdered.add(arrayQ[i]);
        }

        return queueOrdered.toString();
    }

    /**
     * Takes the queue into an string and returns it.
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


    /**
     * Tests
     *
     * Adding unordered integers for the program to sort.
     * 2
     * 2,1
     * 2,1,8
     * 2,1,8,5
     *
     * @Result:
     * [2]
     * [1],[2]
     * [1],[2],[8]
     * [1],[2],[5],[8]
     * @param args
     */
    public static void main(String[] args) {
        OrderedQueue_6<java.lang.Integer> queue = new OrderedQueue_6<>();

        queue.add(2);
        StdOut.println(queue.orderQueueArray());
        queue.add(1);
        StdOut.println(queue.orderQueueArray());
        queue.add(8);
        StdOut.println(queue.orderQueueArray());
        queue.add(5);
        StdOut.println(queue.orderQueueArray());


    }
}
