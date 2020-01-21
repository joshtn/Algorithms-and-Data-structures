package Lab_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @Author: Josh
 * @Made: 5/9/2019
 * @ProblemSolved: Generic iterable FIFO queue.
 * @HowToUse: Input integers with to queue with add(). Use toString() to print out with println. Use delete() to delete the first element in queue.
 * @BasedOn: Algorithms 4th edition.
 */


/**
 * FIFO queue using doubly linked list.
 * @param <Item>
 */
public class fifoQueueDLL_3<Item> implements Iterable<Item> {
    private Node front;
    private Node back;
    private int n;

    private class Node{
        private Node next;
        private Node prev;
        private Item item;
    }

    /**
     * check if queue is empty
     * @return
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * returns size of queue
     * @return
     */
    public int size() {
        return n;
    }


    /**
     * Inserts item to queue
     * @param item
     */
    public void add(Item item) {
        Node oldBack = this.back;
        this.back = new Node();
        this.back.item = item;
        this.back.next = null;
        this.back.prev = oldBack;

        if (this.isEmpty()) {
            this.front = this.back;
        }
        else {
            oldBack.next = this.back;
        }

        this.n++;
    }

    /**
     * Deletes item from queue
     * @return item that is deleted
     */
    public Item delete() {

        Item item = this.front.item;
        this.front = this.front.next;
        this.n--;
        return item;
    }

    /**
     * Iterator
     */
    private class DLLIterator implements Iterator<Item> {
        private Node current = front;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;

            return item;
        }


    }

    public Iterator<Item> iterator() {
        return new DLLIterator();
    }



    /**
     * Method to help print out the queue.
     * @return
     */
    public String toString(){
        Iterator<Item> iterator = iterator();
        String s = "";

        String error = "Queue is empty";
        if (this.size() == 0) { return error; }

        while (iterator.hasNext()){
            s += "[" + iterator.next() + "],";
        }
        return s.substring(0, s.length() - 1);
    }


    /**
     * Tests
     *
     * Lägger in 1,2 sen tar bort 1,2 (i den ordningen). Lägger till 2,7,5 sen tar bort den första som är 2.
     * @Resulat:
     * [1]
     * [1],[2]
     * true
     * true
     * Queue is empty
     * [2]
     * [2],[7]
     * [2],[7],[5]
     * true
     * [7],[5]
     *
     * @param args
     */
    public static void main(String[] args) {

        fifoQueueDLL_3<Integer> queue = new fifoQueueDLL_3<Integer>();

        queue.add(1);
        StdOut.println(queue.toString());
        queue.add(2);
        StdOut.println(queue.toString());
        StdOut.println(queue.delete().equals(1));
        StdOut.println(queue.delete().equals(2));
        StdOut.println(queue.toString());
        queue.add(2);
        StdOut.println(queue.toString());
        queue.add(7);
        StdOut.println(queue.toString());
        queue.add(5);
        StdOut.println(queue.toString());
        StdOut.println(queue.delete().equals(2));
        StdOut.println(queue.toString());


    }
}
