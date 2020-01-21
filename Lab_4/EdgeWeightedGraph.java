package Lab_4;

import edu.princeton.cs.algs4.Bag;

/**
 * represents edge weighted graph with undirected edges.
 * based on algorithms 4th edition
 */
public class EdgeWeightedGraph {

    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    /**
     * initialize empty edge weighted graph with V vertices
     * @param V
     */
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    /**
     * add undirected edge e to edgeWeighted graph
     * @param e
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    /**
     * Returns the number of vetices in e w g
     * @return
     */
    public int V() { return V; }

    /**
     * Retruns the number of vertices in e w g
     * @return
     */
    public int E() { return E; }

    /**
     * returns edges incident on vertex v
     * @param v
     * @return
     */
    public Iterable<Edge> adj(int v ) { return adj[v]; }
}
