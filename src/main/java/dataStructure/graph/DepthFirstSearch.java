package dataStructure.graph;

import java.util.Iterator;
import java.util.List;

/**
 * Traverse a given node in DFS fashion
 */
public class DepthFirstSearch {
    /**
     * Traverse dfs in a recursive fashion
     * @param vertex
     * @param graph
     * @return string such as "2 1 0 3"
     */
    public static String dfcRecursive(Node vertex, Graph graph) {
        StringBuilder dfsTraversal = new StringBuilder();
        dfsUtil(vertex, dfsTraversal, graph);
        return dfsTraversal.toString();
    }

    private static void dfsUtil(Node vertex, StringBuilder traversal, Graph graph) {
        traversal.append(vertex+" ");
        graph.markVisited(vertex);
        List<Node> nodes = vertex.getAdjacent(); //get adjuscent nodes
        Iterator<Node> i = nodes.iterator();
        while(i.hasNext()) {
            Node node = i.next();
            if(graph.isVisited(node)) {
                dfsUtil(node, traversal, graph);
            }
        }
    }
}
