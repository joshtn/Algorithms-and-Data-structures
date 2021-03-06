package Lab_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: Josh
 * @Made: 5/9/2019
 * @ProblemSolved: Reads input from stdin and outputs the reverse.
 * @HowToUse: Type input, program outputs the reverse.
 * @BasedOn: Algorithms 4th edition.
 */
public class ReverseIterRec_2 {

    /**
     * A stack based on Last In First Out (LIFO) queue.
     * @param <Integer>
     */
     static class StackLL<Integer> {
        private Node first;
        private int numOfItems;

        private class Node {
            Integer item;
            Node next;
        }

        /**
         * checks if stack is empty
         * @return
         */
        public boolean isEmpty() { return first == null; }

        /**
         * checks how many items there are in the stack
         * @return
         */
        public int size() {
            return numOfItems;
        }

        /**
         * Add item to stack
         * @param item
         */
        public void push(Integer item) {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            numOfItems++;
        }

        /**
         * remove item from stack
         * @return
         */
        public Integer pop() {
            Integer itemToPop = first.item;
            first = first.next;
            numOfItems--;
            return itemToPop;
        }
    }

    /**
     * Reads integer from user and pushes it to the stack.
     * Then pops the integers entered from the stack resulting in a reversed output.
     * @param stack
     * @param number
     */
    public static void reverseRec(StackLL<Character> stack, int number) {

        if (number != 0) {
            StdOut.println("enter a char: ");
                char enterCharHandler = StdIn.readChar(); // handles chars generated by enter
                char item = StdIn.readChar();
                stack.push(item);
                number--;
                reverseRec(stack, number);

        }

        if (!(stack.isEmpty())) {
            StdOut.print(stack.pop());
        }
    }

    /**
     * Tests:
     *
     * Input  = 1234
     * Output = 4321
     *
     * Input = nat hsoj
     * Output = josh tan
     *
     * Input = !"#€%&
     * Output = &%€#"!
     * @param args
     */
    public static void main(String[] args) {

        StackLL<Character> stack = new StackLL<Character>();

        StdOut.println("enter number of chars you want to insert: ");
        int number = StdIn.readInt();

        reverseRec(stack, number);


        /*
        // iterative
        for (int i = 0; i < number; i++) {
            StdOut.println("Enter a char: ");
            char enterCharHandler = StdIn.readChar(); // handles chars generated by enter
            char item = StdIn.readChar();
            stack.push(item);
        }

        StdOut.println("Chars in reverse order: ");
        while( !(stack.isEmpty()) ) {
            StdOut.print(stack.pop());
        }
        */



    }





}