package dataStructure.graph;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BreadthFirstSearchTest {

    @Test
    public void testGraphContainer() {
        Graph graphContainer = new Graph(Graph.GraphType.DIRECTED);
        Node zero = graphContainer.createNode("shivani".hashCode());
        Node one = graphContainer.createNode("gagan".hashCode());
        Node two = graphContainer.createNode("job".hashCode());
        Node three = graphContainer.createNode("will".hashCode());
        Node four = graphContainer.createNode("get".hashCode());
        Node five = graphContainer.createNode("amazon".hashCode());

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
        Assert.assertEquals("2061721690, 98114490, 105405, -1414265340, 3649490, 102230,",
                BreadthFirstSearch.bfs(zero, graphContainer).trim());

    }
}
