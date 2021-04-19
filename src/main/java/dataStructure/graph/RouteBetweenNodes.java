package dataStructure.graph;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class RouteBetweenNodes {
    public static boolean search(Graph graph, Node start, Node end) {
        if (start == end) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            Node visitingNode = queue.poll(); //remove first

            for (Node node : visitingNode.getAdjacent()) {
                if (graph.isVisited(node)) continue;
                if (node == end) {
                    return true;
                } else {
                    queue.add(node);
                }
            }
            graph.markVisited(visitingNode);
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5, Graph.GraphType.DIRECTED);
        Node start = new Node(5);
        Node n1 = new Node(6);
        Node n2 = new Node(7);
        Node n3 = new Node(8);
        Node end = new Node(10);

        graph.addEdge(start, n1);
        graph.addEdge(start, n2);
        graph.addEdge(n1, n2);
        graph.addEdge(n2, n3);
        graph.addEdge(n3, end);
        graph.addEdge(n3, n2);

        Assert.assertEquals(5, graph.size());
        Assert.assertTrue("there is a path", search(graph, start, end));
        Assert.assertFalse("no path", search(graph, n3, n1));
    }
}
