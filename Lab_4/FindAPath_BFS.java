//package Lab_4;
//
//
//import edu.princeton.cs.algs4.*;
//
///**
// * @Author Josh
// * @Made 2/10/2019
// * @ProblemSolved Finding a path from x to y if there is one.
// * @HowToUse follow the instruction on screen.
// * @BasedOn Algoritms 4th edition and lectures.
// */
//public class FindAPath_BFS {
//
//    private boolean[] marked; //shortest path to this vertex known?
//    private int[] edgeTo; // the vertex it prev came from
//    private final int s; // source (starting pos)
//
//    /**
//     *
//     * @param G
//     * @param s
//     */
//    public FindAPath_BFS(Graph G, int s) {
//        marked = new boolean[G.V()];
//        edgeTo = new int[G.V()];
//        this.s = s;
//        bfs(G, s);
//    }
//
//    /**
//     *
//     * @param G
//     * @param s
//     */
//    private void bfs(Graph G, int s) {
//        Queue<Integer> q = new Queue<Integer>();
//        marked[s] = true; // starting node has been visited
//        q.enqueue(s);
//        while (!q.isEmpty()) {
//            int v = q.dequeue();
//            for (int w : G.adj(v))
//                if (!marked[w]) {
//                    edgeTo[w] = v;
//                    marked[w] = true;
//                    q.enqueue(w);
//                }
//        }
//    }
//
//    /**
//     * Checkes if there is a path to a vertex, if so return true.
//     * @param v
//     * @return
//     */
//    public boolean hasPathTo(int v) { return marked[v]; }
//
//
//    public Iterable<Integer> pathTo(int v) {
//        if (!hasPathTo(v)) { return null; }
//        Stack<Integer> path = new Stack<Integer>();
//        for (int x = v; x != s; x = edgeTo[x])
//            path.push(x);
//        path.push(s);
//        return path;
//    }
//
//    /**
//     * Tested with tinyCG.txt
//     * result:
//     * 0 to 0: 0
//     * 0 to 1: 0-1
//     * 0 to 2: 0-2
//     * 0 to 3: 0-2-3
//     * 0 to 4: 0-2-4
//     * 0 to 5: 0-5
//     * @param args
//     */
//    public static void main(String[] args) {
//
//        // check to make sure input "works"
//        if (args.length == 0) {
//            throw new IllegalArgumentException("test");
//        }
//        In in = new In(args[0]);
//        Graph G = new Graph(in);
//
//        int s = Integer.parseInt(args[1]);
//        FindAPath_BFS bfs = new FindAPath_BFS(G, s);
//
//        for (int v = 0; v < G.V(); v++) {
//            if (bfs.hasPathTo(v)) {
//                StdOut.printf("%d to %d:  ", s, v);
//                for (int x : bfs.pathTo(v)) {
//                    if (x == s) { StdOut.print(x); }
//                    else        StdOut.print("-" + x);
//                }
//                StdOut.println();
//            }
//            else StdOut.printf("%d to %d (-):  not connected\n", s, v);
//        }
//
//
//    }
//
//
//}
