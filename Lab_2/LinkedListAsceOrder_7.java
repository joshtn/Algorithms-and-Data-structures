package Lab_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @Author Josh
 * @Made 21/9/2019
 * @ProblemSolved linked list that sorts elements in ascending order when added.
 * @HowToUse choose the integers to enter by altering main.
 * @BasedOn Algoritms 4th edition and lectures.
 */
public class LinkedListAsceOrder_7 {
    private Node first;
    private int counter;

    private class Node {
        private Node next;
        private int item;
    }

    /**
     * Checks if linked list is empty
     * @return true if the linked list is empty else false
     */
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * Adds the integer passed to the linked list so it is in acending order.
     * @param item the integer to add to the linked list.
     */
    public void insertAcending(int item) {
        if (this.isEmpty()) {
            this.first = new Node();
            this.first.item = item;
            this.first.next = null;
        }
        else {
            Node current = this.first;
            Node currentPrev = null;
            while (item > current.item && current.next != null) {
                currentPrev = current;
                current = current.next;
            }
            if (current == this.first) { // item is the first item in list.
                Node oldFirst = this.first;
                this.first = new Node();
                this.first.item = item;
                this.first.next = oldFirst;
            }
            else if (current.next == null && item > current.item) { // item should get added to the end.
                Node newLastNode = new Node();
                newLastNode.item = item;
                current.next = newLastNode;
            }
            else { // somewhere not at front or back
                Node newNode = new Node();
                newNode.item = item;
                newNode.next = current;
                currentPrev.next = newNode;
            }
        }
        this.counter++;
        this.print();
        StdOut.println();
    }

    /**
     * Will print out the linked list
     */
    private void print() {
        int i = this.counter;
        Node iterator = first;
        while (i != 0) {
            StdOut.print(iterator.item + " -> ");
            iterator = iterator.next;
            i--;
        }

    }

    /**
     * Tests
     * //
     * 2 ->
     * 1 -> 2 ->
     * 1 -> 2 -> 8 ->
     * 1 -> 2 -> 5 -> 8 ->
     * //
     */
    public static void main(String[] args) {
        LinkedListAsceOrder_7 list = new LinkedListAsceOrder_7();

        list.insertAcending(2);
        list.insertAcending(1);
        list.insertAcending(8);
        list.insertAcending(5);
    }
}
