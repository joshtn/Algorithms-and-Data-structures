package Lab_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;


/**
 * @Author: Josh
 * @Made: 5/10/2019
 * @ProblemSolved: Using BFS to find path
 * @HowToUse: Starting point is hardcoded as source. Type in the y value.
 * @BasedOn: Algorithms 4th edition (inspired by symbolgraph) and lectures
 */
public class BFS_2 {
    private boolean[] marked; //shortest path to this vertex known?
    private int[] edgeTo; // the vertex it prev came from
    private final int s; // source (starting pos)

    /**
     *
     * @param G
     * @param s
     */
    public BFS_2(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    /**
     *
     * @param G
     * @param s
     */
    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        marked[s] = true; // starting node has been visited
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v))
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    q.enqueue(w);
                }
        }
    }

    /**
     * Checkes if there is a path to a vertex, if so return true.
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) { return marked[v]; }


    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) { return null; }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }



    /**
     * Tests
     *       start NY
     *   AL
     *   TN
     *   VA
     *   WV
     *   PA
     *   NY
     *
     *      start TN
     *   AL
     *   TN
     * @param args
     */
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\Josh\\Desktop\\database.txt";

        SymbGra_2 sg = new SymbGra_2(inputFile, " ");
        Graph G = sg.graph();

        String source = "AL"; // väljer x
        StdOut.println("Finding path from " + source + " to the state of ur choice...");

        if (!sg.contains(source)) {
            StdOut.println(source + " not in database.");
            return;
        }

        int s = sg.indexOf(source);
        BFS_2 bfs = new BFS_2(G, s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine(); // väljer
            if (sg.contains(sink)) {
                int bob = sg.indexOf(sink); // numeriska värdet av y
                if (bfs.hasPathTo(bob)) {
                    for (int v : bfs.pathTo(bob)) {
                        StdOut.println("  " + sg.nameOf(v));
                    }
                }
                else StdOut.println("Not connected.");
            }
            else StdOut.println("Not in database.");
        }

        }


    }



