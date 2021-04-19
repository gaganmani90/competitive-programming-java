package dataStructure.graph;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepthFirstSearchTest {

    @Test
    public void dfcRecursive() {

        Assert.assertEquals("", "2 0 1 3 ", DepthFirstSearch.dfcRecursive(new Node(2), createGraph()));
    }

    private Graph createGraph() {
        Graph g = new Graph(4, Graph.GraphType.DIRECTED);
        g.addEdge(g.createNode(0), g.createNode(1));
        g.addEdge(g.createNode(0), g.createNode(2));
        g.addEdge(g.createNode(1), g.createNode(2));
        g.addEdge(g.createNode(2), g.createNode(0));
        g.addEdge(g.createNode(2), g.createNode(3));
        g.addEdge(g.createNode(3), g.createNode(3));

        return g;
    }
}