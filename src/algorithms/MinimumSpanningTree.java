package algorithms;

import java.util.HashSet;

public class MinimumSpanningTree {
    HashSet<Integer> set;
    int[] parent;
    int[] weights;
    int[][] graph;

    public void primMST(int[][] graph) {
        set = new HashSet<>();
        parent = new int[graph.length];
        weights = new int[graph.length];
        this.graph = graph;
        int V = graph.length;

        // algorithm
        // set all vertices to INF except for the first one
        // get minimum vertex which is not in the set
        // add it to the set
        // for all adjacent vertices until set has size = graph.length
        //// if edge weight is less then its adjacent's current value, update
        //// also set as parent when adjacent value changed

        for (int i = 0; i < V; i++) {
            weights[i] = Integer.MAX_VALUE;
        }
        weights[0] = 0;
        parent[0] = -1;

        while (set.size() < V) {
            int vertex = getMinimumVertex();
            set.add(vertex);

            for (int i = 0; i < V; i++) {
                if (graph[vertex][i] != 0 && !set.contains(i) && graph[vertex][i] < weights[i]) {
                    parent[i] = vertex;
                    weights[i] = graph[vertex][i];
                }
            }
        }
    }

    private void printMST() {
        for (int i = 1; i < parent.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[parent[i]][i]);
        }
    }

    private int getMinimumVertex() {
        int minVertex = 0;
        int minWeight = Integer.MAX_VALUE;
        for (int i = weights.length-1; i > 0; i--) {
            if (!set.contains(i) && weights[i] < minWeight) {
                minWeight = weights[i];
                minVertex = i;
            }
        }

        return minVertex;
    }


    public static void main(String[] args) {

        MinimumSpanningTree t = new MinimumSpanningTree();
        int[][] graph ;

//        graph = new int[][]{
//                {0, 2, 0, 6, 0},
//                {2, 0, 3, 8, 5},
//                {0, 3, 0, 0, 7},
//                {6, 8, 0, 0, 9},
//                {0, 5, 7, 9, 0}
//        };
//
//        // Print the solution
//        t.primMST(graph);
//        t.printMST();
//        System.out.println();

        graph = new int[][]{

              {0, 4, 0, 0, 0, 0, 0, 8, 0},
              {4, 0, 8, 0, 0, 0, 0,11, 0},
              {0, 8, 0, 7, 0, 4, 0, 0, 2},
              {0, 0, 7, 0, 9,14, 0, 0, 0},
              {0, 0, 0, 9, 0,10, 0, 0, 0},
              {0, 0, 4,14,10, 0, 2, 0, 0},
              {0, 0, 0, 0, 0, 2, 0, 1, 6},
              {8,11, 0, 0, 0, 0, 1, 0, 7},
              {0, 0, 2, 0, 0, 0, 6, 7, 0},

        };

        // Print the solution
        t.primMST(graph);
        t.printMST();
    }
}
