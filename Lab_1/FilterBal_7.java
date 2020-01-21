package Lab_1;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;


/**
 * @Author: Josh
 * @Made: 8/9/2019
 * @ProblemSolved: Filter for paretheses
 * @HowToUse: type in some string with parentheses. Program will test if it is balanced.
 * @BasedOn: Algorithms 4th edition.
 */

public class FilterBal_7 {


    /**
     * Tests:
     *
     * multiple tests with different inputs.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Input your string now: ");
        StringBuilder sb = new StringBuilder();


        //file while(!StdIn.isEmpty()){
            sb.append(StdIn.readLine());
        //file}

        System.out.println("Input is balanced t/f:  " + checkBalanced(sb.toString()));



        System.out.println("tests: ");

        System.out.println("f: ");
        System.out.println(checkBalanced("[Hello()Wo{rld]"));

        System.out.println("t: ");
        System.out.println(checkBalanced("{()}"));


        System.out.println("t: ");
        System.out.println(checkBalanced("()"));


        System.out.println("f: ");
        System.out.println(checkBalanced("("));

        System.out.println("f:");
        System.out.println(checkBalanced("}"));


    }




    /**
     * Puts input to char array. pushes left pare to stack. When char is right right pare stack != empty.
     * we check if it matches latest element in stack. True pops the element and loop goes on. Not a pair gives false
     *
     * @param input
     * @return
     */
    public static boolean checkBalanced(String input) {

        Stack<Character> stack = new Stack<>();

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') { // put left "parentheses" in stack
                stack.push(chars[i]);
            }
            if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
                if (!stack.isEmpty()) {
                    if (checkPair(chars[i], stack.checkFirst())) { // comparing right "parentheses" with the top of stack.
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Checks if the characters form a pair. Example '(' and ')' is a pair, '(' and '}' is not.
     *
     * @param c1 first char
     * @param c2 second char
     * @return true or false depending on if they are a pair.
     */
    public static boolean checkPair(char c1, char c2) {
        return (c1 == '(' && c2 == ')' || c2 == '(' && c1 == ')' ||
                c1 == '[' && c2 == ']' || c2 == '[' && c1 == ']' ||
                c1 == '{' && c2 == '}' || c2 == '{' && c1 == '}');
    }
}

/**
 * Stack implementation
 * @param <Item>
 */
class Stack<Item> implements Iterable<Item> {
    private Node firstNode;

    private class Node {
        Item item;
        Node nextNode;
    }

    //checks if stack is empty
    public boolean isEmpty() {
        return firstNode == null;
    }

    // adds item to stack
    public void push(Item item) {
        Node oldFirstNode = firstNode;
        firstNode = new Node();
        firstNode.item = item;

        firstNode.nextNode = oldFirstNode;
    }

    // pops item from stack
    public Item pop() {
        Item item = firstNode.item;
        firstNode = firstNode.nextNode;
        return item;
    }

    // looks at the first item on the stack
    public Item checkFirst() {
        return firstNode.item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public String toString() {
        Iterator<Item> itr = iterator();
        StringBuilder sb = new StringBuilder();

        while (itr.hasNext()) {
            sb.append(itr.next());
        }
        return sb.toString();
    }

    /**
     * Iterator
     */
    private class ListIterator implements Iterator<Item> {
        private Node current = firstNode;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.nextNode;
            return item;
        }

    }
}