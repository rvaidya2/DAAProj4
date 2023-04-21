import java.util.Scanner;
import java.util.*;


public class Main {
    // Declaring the size of the randomly generated graph
    public static int n  = (int) (Math.random() * 6) + 5;

    // Declaring a 2D array to represent the adjacency matrix of the graph
   public static int[][] A = new int[n][n];


    public static void main(String[] args) {

//      Step 1: Create an adjacency matrix A for a randomly generated undirected complete graph
        System.out.println("Selected n value: " + n);


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = (int) (Math.random() * 10) + 1;
                A[i][j] = weight;
                A[j][i] = weight; // Make the graph undirected
            }
        }

        // Printing the adjacency matrix of the generated graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] > 9) {
                    System.out.print(" " + A[i][j] + " ");
                } else {
                    System.out.print(" " + A[i][j] + "  ");
                }
            }
            System.out.println();
        }
        // Reading input from the user to select the algorithm to run
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the algorithm");
        String inputString = scanner.nextLine();

        // Running the selected algorithm based on user input
        if(inputString.equals("prim")){
           Prim p = new Prim();
           p.prim(A,n);

        }else if(inputString.equals("kruskal")){
            kruskal k = new kruskal();
            k.kruskals(A);

        }else {
            System.out.println("Error");
            System.exit(0);
        }




    }
}