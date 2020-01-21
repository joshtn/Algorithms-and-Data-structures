package Lab_4;

import edu.princeton.cs.algs4.Bag;


/**
 * represents undirected graph of vertices used in lab4
 * based on algorithms 4th edition
 */
public class Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;



    /**
     * make empty graph with V vertices
     *
     * @param  V num of vertices
     */
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }

    }

    /**
     * Adds undirected edge v-w to graph
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public int V() { return V; }

    public int E() { return E; }

    /**
     * returns edges incident on vertex v
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) { return adj[v]; }


}
