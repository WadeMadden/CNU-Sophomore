package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Creates a Graph from a 2d parameter of Strings where the first value of each
 * row is the vertex, and the other values are the edges.
 * 
 * @author Wade Madden
 */
public class Graph {
    private ArrayList<String> vertices = new ArrayList<String>();
    private HashMap<String, ArrayList<String>> adjacency = new HashMap<String, ArrayList<String>>();

    /*
     * Constructor that creates a Graph from a 2d parameter of Strings where the
     * first value of each row is the vertex, and the other values are the
     * edges.
     * 
     * @param graphIn a 2d parameter of Strings
     */
    public Graph(String[][] graphIn) {
        for (int i = 0; i < graphIn.length; i++) {
            ArrayList<String> edges = new ArrayList<String>();
            vertices.add(graphIn[i][0]);
            for (int j = 1; j < graphIn[i].length; j++) {
                edges.add(graphIn[i][j]);
            }
            adjacency.put(graphIn[i][0], edges);
        }
    }

    /*
     * Returns an ArrayList of strings that will represent the vertices in the
     * graph.
     * 
     * @return the ArrayList of vertices
     */
    public ArrayList<String> getVertices() {
        return vertices;
    }

    /*
     * Returns the edge list for the specified vertex
     * 
     * @param v a specific vector from the graph
     * 
     * @return a list of edges for the specified vertex
     */
    public ArrayList<String> getEdgeList(String v) {
        return adjacency.get(v);
    }

    /*
     * Returns the graph as a string representation of a list of vertices, and
     * the edges associated with them
     * 
     * @return a string representation of a list of vertices, and the edges
     * associated with them
     */
    @Override
    public String toString() {
        String mapString = "";
        for (int i = 0; i < vertices.size(); i++) {

            mapString += vertices.get(i) + ": "
                    + adjacency.get(vertices.get(i)) + "\n";
        }
        mapString = mapString.replace("[", "");
        mapString = mapString.replace("]", "");
        return mapString;
    }
}
