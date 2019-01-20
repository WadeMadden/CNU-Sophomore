package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/*
 * Provides functionality to topologically sort a graph. The graph can be sorted
 * by the source removal algorithm or the depth first search algorithm. Was not
 * able to check if dag for dfsTopSort
 * 
 * @author Wade Madden
 */
public class TopSort {
    private ArrayList<String> topSort = new ArrayList<String>();
    private ArrayList<String> verts = new ArrayList<String>();
    private HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
    private Stack<String> popOrder = new Stack<String>();

    /*
     * Topologically sorts a graph using the depth first search algorithm.
     * 
     * @param g the graph to be sorted
     * 
     * @return an ArrayList of strings representing the vertices. The order of
     * the vertices is the order in which they were popped off the stack
     */
    public ArrayList<String> dfsTopSort(Graph g) {
        long begin = System.nanoTime();
        verts = g.getVertices();
        for (int i = 0; i < verts.size(); i++) {
            visited.put(verts.get(i), false);
        }
        dfs(verts.get(0), g);
        while (!popOrder.isEmpty()) {
            topSort.add(popOrder.pop());
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("Depth First Search Topological Sort");
        for (int i = 0; i < topSort.size(); i++) {
            System.out.print(topSort.get(i) + " -> ");
        }
        System.out.println();
        System.out.println("dfsTopSort took " + time + " nano seconds");
        System.out.println();
        return topSort;

    }

    /*
     * The recursive portion of the depth first search algorithm. Called by
     * dfsTopSort
     * 
     * @param vertex the current vertex in the graph traversal
     * 
     * @param g the graph(used so that the edge list can be accessed)
     * 
     * @return an ArrayList of the vertices
     */
    public ArrayList<String> dfs(String vertex, Graph g) {
        if (g.getEdgeList(vertex).isEmpty()) {
            visited.replace(vertex, true);
            popOrder.push(vertex);

        }
        else {
            for (int i = 0; i < g.getEdgeList(vertex).size(); i++) {
                if (!visited.get(vertex)) {
                    visited.replace(vertex, true);

                    dfs(g.getEdgeList(vertex).get(i), g);
                    popOrder.push(vertex);
                }

            }
        }
        for (int i = 0; i < verts.size(); i++) {
            if (!visited.get(verts.get(i)) && vertex == "c1") {
                dfs(verts.get(i), g);
            }
        }
        return null;
    }

    /*
     * Uses the source removal algorithm to sort the graph. Traverses the graph
     * and keeps track of the hierarchy of source vertices. Returns and
     * ArrayList of vertices that have been sorted using this method.
     * 
     * @param g the graph to be sorted
     * 
     * @return an ArrayList of topologically sorted vertices using the source
     * removal algorithm
     */
    public ArrayList<String> sourceTopSort(Graph g) {
        long begin = System.nanoTime();
        ArrayList<String> verts = g.getVertices();
        ArrayList<String> ans = new ArrayList<String>();
        for (int i = 0; i < verts.size(); i++) {
            String vertChecked = verts.get(i);
            boolean ifIncomingEdgeNotDetected = false;
            for (int j = 0; j < verts.size(); j++) {
                if (verts.size() == 1) {
                    ans.add(vertChecked);
                    verts.remove(j);
                }
                if (i == j) {
                    continue;
                }
                else if (g.getEdgeList(verts.get(j)).contains(vertChecked)) {
                    ifIncomingEdgeNotDetected = true;
                }
                if (j == verts.size() - 1 && !ifIncomingEdgeNotDetected) {
                    ans.add(vertChecked);
                    verts.remove(i);
                    i--;
                }
            }
            if (ans.isEmpty()) {
                System.out.println("This is not a DAG");
                return null;
            }
        }
        long end = System.nanoTime();
        long time = end - begin;
        System.out.println("Source Removal Topological Sort");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " -> ");
        }
        System.out.println();
        System.out.println("sourceTopSort took " + time + " nano seconds");
        System.out.println();
        return ans;

    }
}
