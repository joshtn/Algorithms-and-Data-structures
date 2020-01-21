package Lab_4;

/**
 * weighted edge in an EdgeWeightedGraph. Each edge consists of 2 integers (vertices)
 * and a weight.
 * Based on algorithms 4th edition
 */
public class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private final double weight;

    /**
     *
     * @param v
     * @param w
     * @param weight
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() { return weight; }

    public int either() { return v; }

    /**
     * return the other vertex that is connected to speicifed vertex
     * @param vertex
     * @return
     */
    public int other(int vertex) {
        if (vertex == v) { return w; }
        else
            return v;

    }

    /**
     * comparing edges weights
     * @param that
     * @return
     */
    public int compareTo(Edge that) { return Double.compare(this.weight, that.weight); }

}
