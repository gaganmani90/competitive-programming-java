package dataStructure.graph;

import org.junit.Assert;
import org.junit.Test;

public class BreadthFirstSearchTest {

    @Test
    public void testBfs(){
        Graph g = BreadthFirstSearch.createGraph();
        Assert.assertEquals("2031", BreadthFirstSearch.bfs(2, g));
        Assert.assertEquals("1203", BreadthFirstSearch.bfs(1, g));
    }
}
