package Lab_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @Author: Josh
 * @Made: 6/9/2019
 * @ProblemSolved: Generic iterable circular linked list. Can remove from front and back of queue.
 * @HowToUse: Input integers to queue with add(). Use toString() to print out with println. Use delete() to delete the first element in queue.
 * @BasedOn: Algorithms 4th edition.
 */

/**
 * Circular linked list
 * @param <Item>
 */
public class circularLL_4<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;

    private class Node {
        private Node next;
        private Item item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return this.n;
    }

    /**
     * Add item to the end.
     * @param item
     */
    public void addBack(Item item) {
        if (this.isEmpty()) {
            this.first = new Node();
            this.first.item = item;
            this.last = this.first;
            this.first.next = this.last;
        } else {
            Node oldLast = this.last;
            this.last = new Node();
            this.last.item = item;
            this.last.next = this.first;
            oldLast.next = this.last;
        }
        this.n++;
    }

    /**
     * Add item to the front
     * @param item
     */
    public void addFront(Item item) {
        if (this.isEmpty()) {
            this.first = new Node();
            this.first.item = item;
            this.last = this.first;
            this.first.next = this.last;
        } else {
            Node oldFirst = this.first;
            this.first = new Node();
            this.first.item = item;
            this.first.next = oldFirst;
            this.last.next = this.first;
        }
        this.n++;
    }

    /**
     * Delete item from front.
     * @return
     */
    public Item delFront() {
        if (this.isEmpty()) {
            return null;
        }
        Item item = this.first.item;
        if (this.first.next == this.first) {
            this.first.next = null;
        }
        this.first = first.next;
        this.last.next = this.first;
        if (this.isEmpty()) {
            this.last = null;
        }
        this.n--;

        return item;
    }

    /**
     * Delete item from the back.
     * @return
     */
    public Item delBack() {
        if (this.isEmpty()) {
            return null;
        }
        Item item = this.last.item;
        if (this.first.next == this.first) {
            this.first = null;
        } else {
            Node newLast = this.first;

            while (newLast.next != this.last) { // searching for the new last element.
                newLast = newLast.next;
            }
            this.last = newLast;
            this.last.next = this.first;
        }
        if (this.isEmpty()) {
            this.last = null;
        }
        this.n--;

        return item;
    }

    /**
     * Iterator
     */
    private class circularLLIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext() { return current != null; }


        public Item next() {
            Item item = current.item;
            current = current.next;

            return item;
        }
    }

    public Iterator<Item> iterator() { return new circularLLIterator(); }


    /**
     * Puts items in the queue into a string.
     * @return string with queue items.
     */
    @Override
    public String toString(){
        String s = "[" + this.first.item + "],";
        Node temp = this.first.next;
        while (!temp.equals(this.first)){
            s += "[" + temp.item + "],";
            temp = temp.next;
        }
        return s.substring(0, s.length() - 1);
    }



    /**
     * Tests
     *
     * Front är till vänster och back är till höger.
     * lägger till element både addBack() och addFront(). Sedan tar bort element med delBack() och delFront()
     *
     * @Result:
     * [3], [1], [2], [4], [5]
     * true
     * [1],[2],[4],[5]
     * true
     * [1],[2],[4]
     * true
     * [2],[4]
     * [1],[2],[4]
     * true
     *
     * @param args
     */
    public static void main(String[] args) {
        circularLL_4<Integer> cLL = new circularLL_4<Integer>();

        cLL.addBack(1);
        cLL.addBack(2);
        cLL.addFront(3);
        cLL.addBack(4);
        cLL.addBack(5);
        StdOut.println(cLL.toString());
        StdOut.println(cLL.delFront().equals(3));
        StdOut.println(cLL.toString());
        StdOut.println(cLL.delBack().equals(5));
        StdOut.println(cLL.toString());
        StdOut.println(cLL.delFront().equals(1));
        StdOut.println(cLL.toString());
        cLL.addFront(1);
        StdOut.println(cLL.toString());
        StdOut.println(cLL.size() == 3);
    }
}

