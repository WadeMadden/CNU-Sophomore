package TopologicalSort;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * This code generates a dag using input from the user. The user inputs a number
 * of vertices and edges. The user is then prompted the enter each edge
 * relationship. Was not able to implement the code for generation of edge
 * relationships. Added a method to represent the dag in the proper format(2d
 * array). Added clearer instructions for the user. This generator requires the
 * vertices to be integers. Calculations are completed according the their
 * values. This class must be run first.
 * 
 * Augmented code from
 * https://www.sanfoundry.com/java-program-implement-adjacency-list/
 */
public class DAGGen {
    private static Map<Integer, List<Integer>> Adjacency_List;

    /*
     * Creates a map of the vertices paired with an empty edge list
     * 
     * @param number_of_vertices the number of vertices to add to the adjacency
     * list
     */
    public DAGGen(int number_of_vertices) {
        Adjacency_List = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= number_of_vertices; i++) {
            Adjacency_List.put(i, new LinkedList<Integer>());
        }
    }

    /*
     * Sets the edges using a source vertex and a destination vertex
     * 
     * @param source the source vertex
     * 
     * @param destination the destination vertex
     */
    public void setEdge(int source, int destination) {
        if (source > Adjacency_List.size()
                || destination > Adjacency_List.size()) {
            System.out.println("the vertex entered in not present ");
            return;
        }
        List<Integer> slist = Adjacency_List.get(source);
        slist.add(destination);
        // uncomment this for undirected graph
        // List<Integer> dlist = Adjacency_List.get(destination);
        // dlist.add(source);
    }

    /*
     * I created this method. Transforms the adjacency list into a 2d array.
     * This will allow the use of the graph class.
     * 
     * @return a 2d array of the adjacency list in the proper format
     */
    public static String[][] adjacencyListAs2dArray() {
        String[][] ans = new String[Adjacency_List.size()][];
        int i = 0;
        Iterator<Integer> iterator = Adjacency_List.keySet().iterator();
        while (iterator.hasNext()) {
            List<Integer> a = Adjacency_List.get(iterator.next());
            ans[i] = new String[a.size() + 1];
            i++;
        }
        Iterator<Integer> keysToAdd = Adjacency_List.keySet().iterator();
        Iterator<Integer> keysForValues = Adjacency_List.keySet().iterator();
        int j = 0;
        while (keysToAdd.hasNext()) {
            ans[j][0] = keysToAdd.next().toString();
            int k = 1;
            List<Integer> vals = Adjacency_List.get(keysForValues.next());
            while (k < ans[j].length) {
                ans[j][k] = vals.get(k - 1).toString();
                k++;
            }
            j++;
        }
        return ans;
    }

    /*
     * Get the edge list for the source vertex.
     * 
     * @param source the source vertex
     * 
     * @return the edge list of the specific vertex
     */
    public List<Integer> getEdge(int source) {
        if (source > Adjacency_List.size()) {
            System.out.println("the vertex entered is not present");
            return null;
        }
        return Adjacency_List.get(source);
    }

    public static void main(String... arg) {
        int source, destination;
        int number_of_edges, number_of_vertices;
        int count = 1;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter the number of vertices in graph");
            number_of_vertices = scan.nextInt();
            System.out.println("Enter the number of edges in graph");
            number_of_edges = scan.nextInt();

            DAGGen adjacencyList = new DAGGen(number_of_vertices);
            System.out.println(
                    "Enter the edges (must be integers and within range of number of vertices) in graph Format : <source index> <destination index>\n"
                            + "Example: If vertices equals 4 and edges equals 5 then enter edges like this.\n "
                            + "---------------------------------------------------------------------------\n"
                            + "1 2\n" + "2 3\n" + "3 4\n" + "1 3\n" + "2 4\n"
                            + "----------------------------------------------------------------------------\n"
                            + "This format places an edge between the corresponding vertices.");
            while (count <= number_of_edges) {
                source = scan.nextInt();
                destination = scan.nextInt();
                adjacencyList.setEdge(source, destination);
                count++;
            }
            Graph g = new Graph(adjacencyListAs2dArray());
            TopSort t = new TopSort();
            t.dfsTopSort(g);
            t.sourceTopSort(g);

        }
        catch (InputMismatchException inputMismatch) {
            System.out.println(
                    "Error in Input Format. \nFormat : <source index> <destination index>");
        }
        scan.close();
    }
}
