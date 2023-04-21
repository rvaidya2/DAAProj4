import java.util.*;

public class Prim {

    public static void prim(int[][] A,int n) {


        int[] parent = new int[n];
        int[] key = new int[n];
        boolean[] mstSet = new boolean[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);
        parent[0] = -1;
        key[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < n; v++) {
                if (A[u][v] != 0 && !mstSet[v] && A[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = A[u][v];

                }
            }
        }

        int[][] B = new int[n][n]; // initialize new matrix for MST
        for (int i = 0; i < n; i++) {
            Arrays.fill(B[i], 0); // set all entries to zero
        }

        for (int i = 1; i < n; i++) {
            B[i][parent[i]] = A[i][parent[i]]; // add edge to MST
            B[parent[i]][i] = A[parent[i]][i]; // make the matrix symmetric
        }

        System.out.println("Prim's Matrix:");
        printMatrix(B); // print the MST matrix

        // Step 4: Print all the edges in the generated minimum spanning tree
        System.out.println("Minimum Spanning Tree:");
        for (int i = 1; i < n; i++) {
            System.out.println("V" + (parent[i] + 1) + " - " + "V" + (i + 1) + "\t:" + A[i][parent[i]]);
        }
    }



    // Helper method to find the vertex with the minimum key value
    public static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < key.length; i++) {
            if (!mstSet[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Helper method to print a 2D array
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] +"\t");
            }
            System.out.println();
        }
    }


}
