package Lab_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

/**
 * @Author: Josh
 * @Made: 6/10/2019
 * @ProblemSolved: Adding weights to edges and finding shortest path from x to y
 * @HowToUse: Starting point is hardcoded as source. Type in the y value.
 * @BasedOn: Algorithms 4th edition and lectures.
 */
public class ShortestPath_3 {
    private double[] distTo;
    private Edge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public ShortestPath_3(EdgeWeightedGraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new Edge[G.V()];

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY; // all nodes to infinity since they havn't been vistited.
        }
        distTo[s] = 0.0; // starting node

        // relax vetices in order of distance from source (s)
        pq = new IndexMinPQ<Double>(G.V());
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (Edge e : G.adj(v))
                relax(e, v);
        }
    }

    /**
     * Relax edge e and update pq if changed
     *  @param e
     * @param v
     */
    private void relax(Edge e, int v) {
        int w = e.other(v);
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) {
                pq.decreaseKey(w, distTo[w]);
            } else {
                pq.insert(w, distTo[w]);
            }
        }
    }

    /**
     * Returns the length of a shortest path between the source vertex s and vertex v.
     * @param v
     * @return
     */
    public double distTo(int v) {
        return distTo[v];
    }

    /**
     * Returns true if there is a path between the source vertex s and vertex v
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<Edge> pathTo(int v) {
        if (!hasPathTo(v)) { return null; }

        Stack<Edge> path = new Stack<>();
        int x = v;
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[x]) {
            path.push(e);
            x = e.other(x);
        }
        return path;
    }

    /**
     * Tests
     * NY
     * AL TN  4.0
     * TN VA  105.0
     * DC VA  27.0
     * DC MD  26.0
     * DE MD  28.0
     * DE NJ  29.0
     * NJ NY  91.0
     * Total weight: 310.0
     *
     * LA
     * AL MS  3.0
     * AR MS  7.0
     * AR LA  5.0
     * Total weight: 15.0
     * @param args
     */
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\Josh\\Desktop\\database.txt";
        SymbGra_2 sg = new SymbGra_2(inputFile, " ");
        String source = "AL"; // väljer x
        StdOut.println("Finding SHORTEST path from " + source + " to the state of ur choice...");
        int s = sg.indexOf(source);
        ShortestPath_3 sp = new ShortestPath_3(sg.ewgGraph(), s);

        double weightCount = 0;
        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine(); // väljer
            if (sg.contains(sink)) {
                int bob = sg.indexOf(sink); // numeriska värdet av y
                if (sp.hasPathTo(bob)) {
                    for (Edge v : sp.pathTo(bob)) {
                        int prev = v.either();
                        int next = v.other(prev);
                        StdOut.println(sg.nameOf(prev) + " "  + sg.nameOf(next) +  "  " +  v.weight());
                        weightCount += v.weight();
                    }
                    StdOut.println("Total weight: " + weightCount);
                    weightCount = 0;
                }
                else StdOut.println("Not connected.");
            }
            else StdOut.println("Not in database.");
        }
    }


}
