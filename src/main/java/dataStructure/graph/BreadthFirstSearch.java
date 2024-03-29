package dataStructure.graph;


import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * Breadth First Traversal (or Search) for a graph is similar to Breadth First Traversal of a tree (See method 2 of this post).
 * The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same node again.
 * To avoid processing a node more than once, we use a boolean visited array. For simplicity, it is assumed that all vertices are reachable from the starting vertex.
 * For example, in the following graph, we start traversal from vertex 2.
 * When we come to vertex 0, we look for all adjacent vertices of it. 2 is also an adjacent vertex of 0.
 * If we don’t mark visited vertices, then 2 will be processed again and it will become a non-terminating process.
 * A Breadth First Traversal of the following graph is 2, 0, 3, 1.
 */
@Slf4j
public class BreadthFirstSearch {


    static Graph createGraph() {
        Graph g = new Graph(4, Graph.GraphType.DIRECTED);
        Node n1 = g.createNode(0);
        Node n2 = g.createNode(1);
        Node n3 = g.createNode(2);
        Node n4 = g.createNode(3);
        g.addEdge(n1, n2);
        g.addEdge(n1, n3);
        g.addEdge(n2, n3);
        g.addEdge(n3, n1);
        g.addEdge(n3, n4);
        g.addEdge(n4, n4);

        return g;

    }

    /**
     * Print breadth first search from given node
     *
     * @param source
     * @return
     */
    static String bfs(Node source, Graph graph) {
        StringBuilder builder = new StringBuilder();

        /**
         * BFS queue
         */
        LinkedList<Node> bfsQueue = new LinkedList<>();

        bfsQueue.add(source); //add first element
        graph.markVisited(source); //visited

        while (bfsQueue.size() != 0) {
            Node node = bfsQueue.poll();
            builder.append(node);

            //get adjacent nodes
            List<Node> adjacent = node.getAdjacent();

            for(Node currNode : adjacent){

                if(!graph.isVisited(currNode)){
                    graph.markVisited(currNode);
                    bfsQueue.add(currNode);
                }
            }
        }

        return builder.toString();

    }

}
