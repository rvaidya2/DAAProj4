import java.util.*;

// Class to represent a graph edge with a source, destination, and weight
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}


// Class to represent a subset for union-find
class Subset {
    int parent, rank;
}

public class kruskal {

//    takes in an adjacency matrix representing a graph and performs Kruskal's algorithm to find the minimum spanning tree.
    public static void kruskals(int [][] graph) {

        int V = graph.length;
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    Edge edge = new Edge();
                    edge.src = i;
                    edge.dest = j;
                    edge.weight = graph[i][j];
                    edges.add(edge);
                }
            }
        }
        Collections.sort(edges);

        Edge[] result = new Edge[V];
        int i = 0, e = 0;
        Subset[] subsets = new Subset[V];
        for (i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0;
        while (e < V - 1 && i < edges.size()) {
            Edge nextEdge = edges.get(i++);
            int x = find3(subsets, nextEdge.src);
            int y = find3(subsets, nextEdge.dest);
            if (x != y) {
                result[e++] = nextEdge;
                union3(subsets, x, y);
            }
        }

        System.out.println("Kruskal's result matrix:");
        for (i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    System.out.print("0 ");
                } else {
                    int found = 0;
                    for (int k = 0; k < V - 1; k++) {
                        if (result[k] != null && ((result[k].src == i && result[k].dest == j)
                                || (result[k].src == j && result[k].dest == i))) {
                            System.out.print(result[k].weight + " ");
                            found = 1;
                            break;
                        }
                    }
                    if (found == 0) {
                        System.out.print("0 ");
                    }
                }
            }
            System.out.println();
        }

        System.out.println("Kruskal's MST:");
//        outputs the resulting minimum spanning tree in two forms: a matrix of weights and a list of edges with their weights.
        for (i = 0; i < V - 1; i++) {
            System.out.println("V" + (result[i].src + 1) + "- V" + (result[i].dest + 1) + "\t: " + result[i].weight);

        }

    }
//    recursive helper method for the union-find algorithm that finds the parent of a subset
    public static int find3(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find3(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

//    helper method for the union-find algorithm that merges two subsets based on their ranks.
    public static void union3(Subset[] subsets, int x, int y) {
        int xroot = find3(subsets, x);
        int yroot = find3(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
}
