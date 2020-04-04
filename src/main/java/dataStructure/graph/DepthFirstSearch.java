package dataStructure.graph;

import java.util.Iterator;
import java.util.List;

/**
 * Traverse a given node in DFS fashion
 */
public class DepthFirstSearch {
    public static String dfcRecursive(int vertex, Graph graph) {
        StringBuilder dfsTraversal = new StringBuilder();
        boolean visited[] = new boolean[graph.numberOfVertices];
        dfsUtil(vertex, visited, dfsTraversal, graph);
        return dfsTraversal.toString();
    }

    private static void dfsUtil(int vertex, boolean[] visited, StringBuilder traversal, Graph graph) {
        traversal.append(vertex+" ");
        visited[vertex] = true; //mark visited
        List<Integer> nodes = graph.getAdjacentNodes(vertex); //get adjuscent nodes
        Iterator<Integer> i = nodes.iterator();
        while(i.hasNext()) {
            int node = i.next();
            if(!visited[node]) {
                dfsUtil(node, visited, traversal, graph);
            }
        }
    }
}
