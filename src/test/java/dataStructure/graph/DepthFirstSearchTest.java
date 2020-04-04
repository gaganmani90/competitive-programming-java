package dataStructure.graph;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepthFirstSearchTest {

    @Test
    public void dfcRecursive() {

        Assert.assertEquals("", "2 0 1 3 ", DepthFirstSearch.dfcRecursive(2, createGraph()));
    }

    private Graph createGraph() {
        Graph g = new Graph(4, Graph.GraphType.DIRECTED);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        return g;
    }
}