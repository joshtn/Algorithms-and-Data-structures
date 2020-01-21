package Lab_4;

import edu.princeton.cs.algs4.StdOut;



/**
 * @Author: Josh
 * @Made: 6/10/2019
 * @ProblemSolved: Adding weights to edges and finding shortest path from x to y
 * @HowToUse: Starting point is hardcoded as source. Type in the y value.
 * @BasedOn: Algorithms 4th edition insp PrimMST eger version and lectures
 */
public class MST_4 {


    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public MST_4(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v])     { prim(G, v); }
        }
    }

    private void prim(EdgeWeightedGraph G, int s) {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(G, v);
        }
    }

    private void scan(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) { continue; }
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) { pq.decreaseKey(w, distTo[w]); }
                else                { pq.insert(w, distTo[w]); }
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

    public double weightSum() {
        double weight = 0.0;
        for (Edge e : edges()) {
            weight += e.weight();
        }
        return weight;
    }


    /**
     * Tests
     * Finding MST in given graph...
     * AL FL 1.0
     * AL GA 2.0
     * AL MS 3.0
     * AL TN 4.0
     * AR MS 7.0
     * AR LA 5.0
     * AR MO 6.0
     * AR OK 8.0
     * AR TX 10.0
     * AZ NM 12.0
     * AZ CA 11.0
     * CO NM 19.0
     * AZ NV 13.0
     * AZ UT 14.0
     * CA OR 16.0
     * CO OK 20.0
     * CO KS 17.0
     * CO NE 18.0
     * CO WY 22.0
     * CT NY 24.0
     * CT MA 23.0
     * NJ NY 91.0
     * CT RI 25.0
     * DC VA 27.0
     * DC MD 26.0
     * KY VA 60.0
     * DE MD 28.0
     * DE NJ 29.0
     * DE PA 30.0
     * GA NC 32.0
     * GA SC 33.0
     * IA MO 37.0
     * IA IL 35.0
     * IA MN 36.0
     * IA SD 39.0
     * IA WI 40.0
     * ID NV 42.0
     * ID MT 41.0
     * ID WA 45.0
     * IL IN 47.0
     * IL KY 48.0
     * IN MI 52.0
     * IN OH 53.0
     * KY WV 61.0
     * MA NH 64.0
     * MA VT 67.0
     * ME NH 71.0
     * MN ND 74.0
     * Total weight: 1488.0
     * @param args
     */
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\Josh\\Desktop\\database.txt";
        SymbGra_2 sg = new SymbGra_2(inputFile, " ");
        StdOut.println("Finding MST in given graph...");
        MST_4 mst = new MST_4(sg.ewgGraph());
        for (Edge e : mst.edges()) {
            int prev = e.either();
            int next = e.other(prev);
            StdOut.println(sg.nameOf(prev) + " " + sg.nameOf(next) + " " + e.weight());
        }
        StdOut.println("Total weight: "+ mst.weightSum());

}
}
