package dataStructure.graph;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BreadthFirstSearchTest {

    @Test
    public void testGraphContainer() {
        GraphContainer graphContainer = new GraphContainer(GraphContainer.GraphType.DIRECTED);
        Node zero = graphContainer.createNode("shivani");
        Node one = graphContainer.createNode("gagan");
        Node two = graphContainer.createNode("job");
        Node three = graphContainer.createNode("will");
        Node four = graphContainer.createNode("get");
        Node five = graphContainer.createNode("amazon");

        /**
         * [main] INFO dataStructure.graph.Node - ADD EDGE: [shivani -> gagan]
         * [main] INFO dataStructure.graph.Node - ADD EDGE: [shivani -> job]
         * [main] INFO dataStructure.graph.Node - ADD EDGE: [gagan -> job]
         * [main] INFO dataStructure.graph.Node - ADD EDGE: [job -> shivani]
         * [main] INFO dataStructure.graph.Node - ADD EDGE: [job -> will]
         * [main] INFO dataStructure.graph.Node - ADD EDGE: [will -> get]
         * [main] INFO dataStructure.graph.Node - ADD EDGE: [shivani -> amazon]
         */
        graphContainer.addEdge(zero, one);
        graphContainer.addEdge(zero, two);
        graphContainer.addEdge(one, two);
        graphContainer.addEdge(two, zero);
        graphContainer.addEdge(two, three);
        graphContainer.addEdge(three, four);
        graphContainer.addEdge(zero, five);

        System.out.println(graphContainer.toString());


        Assert.assertEquals(graphContainer.size(), 6);
        Assert.assertEquals(graphContainer.maxSize(), Integer.MAX_VALUE);
        Assertions.assertThrows(NullPointerException.class, () -> graphContainer.addEdge(one,null),
                "invalid node");
        Assert.assertEquals(graphContainer.size(), 6);
        Assert.assertEquals("shivani, gagan, job, amazon, will, get, ",
                BreadthFirstSearch.bfs(zero, graphContainer));

    }
}
