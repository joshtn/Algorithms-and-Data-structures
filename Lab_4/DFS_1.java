package Lab_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
/**
 * @Author: Josh
 * @Made: 4/10/2019
 * @ProblemSolved: Using DFS to find a path from x to y.
 * @HowToUse: Starting point is hardcoded as source. Type in the y value.
 * @BasedOn: Algorithms 4th edition and lectures.
 */

public class DFS_1 {
    private boolean[] marked; // has it been visited
    private int[] edgeTo; // the vertex it come from previously
    private final int s; // source, the starting point

    /***
     * Constructor, initilizes data structures/arrays...
     * @param G
     * @param s
     */
    public DFS_1(Graph G, int s) {
    marked  = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    dfs(G, s);
}

    /**
     *
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
    marked[v] = true; // set v to true since we have visited it.
    for (int w : G.adj(v)) { // check nodes adjacent to v.
        if (!marked[w]) { // visit the unvisited node
            edgeTo[w] = v; // record path taken
            dfs(G, w); // recursive
        }
    }
}

public boolean hasPathTo(int v) { return marked[v]; }

    /**
     * gives the path to a given vertex/node.
     * iterating through stack give the correct path order.
     * @param v
     * @return
     */
    public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) { return null; }
    Stack<Integer> path = new Stack<>(); // use a stack to push the path.
    for (int x = v; x!= s; x = edgeTo[x])
        path.push(x);
    path.push(s); // source hamnar högst up för vill ha ut den först
        return path;


  }

    /**
     * Tests:
     *     start  NY
     *   AL
     *   TN
     *   VA
     *   WV
     *   PA
     *   NY
     *
     *      start LA
     *   AL
     *   TN
     *   VA
     *   WV
     *   PA
     *   OH
     *   MI
     *   WI
     *   MN
     *   SD
     *   WY
     *   UT
     *   NV
     *   OR
     *   CA
     *   AZ
     *   NM
     *   TX
     *   OK
     *   MO
     *   AR
     *   MS
     *   LA
     * @param args
     */
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\Josh\\Desktop\\database.txt";

        SymbGra_2 sg = new SymbGra_2(inputFile, " ");
        Graph G = sg.graph();

        String source = "AL"; // väljer x
        StdOut.println("Finding path from " + source + " to the state of ur choice...");

        if (!sg.contains(source)) {
            System.out.println(source + " not in database.");
            return;
        }

        int s = sg.indexOf(source);
        DFS_1 dfs = new DFS_1(G, s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine(); // väljer
            if (sg.contains(sink)) {
                int bob = sg.indexOf(sink); // numeriska värdet av y
                if (dfs.hasPathTo(bob)) {
                    for (int v : dfs.pathTo(bob)) {
                        System.out.println("  " + sg.nameOf(v));
                    }
                }
                else System.out.println("Not connected.");
            }
            else System.out.println("Not in database.");
        }

    }

}



