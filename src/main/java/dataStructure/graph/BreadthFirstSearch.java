package dataStructure.graph;


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
public class BreadthFirstSearch {

    static Graph createGraph() {
        Graph g = new Graph(4, Graph.GraphType.DIRECTED);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        return g;

    }

    /**
     * Print breadth first search from given node
     *
     * @param source
     * @return
     */
    static String bfs(int source, Graph graph) {
        StringBuilder builder = new StringBuilder();

        /**
         * Mark all nodes as non visited at the beginning
         */
        boolean visited[] = new boolean[graph.numberOfVertices];

        /**
         * BFS queue
         */
        LinkedList<Integer> bfsQueue = new LinkedList<>();

        bfsQueue.add(source); //add first element
        visited[source] = true; //visited

        while (bfsQueue.size() != 0) {
            int node = bfsQueue.poll();
            builder.append(node);

            //get adjacent nodes
            List<Integer> adjacent = graph.getAdjacentNodes(node);

            for(int currNode : adjacent){

                if(!visited[currNode]){
                    visited[currNode] = true;
                    bfsQueue.add(currNode);
                }
            }
        }

        return builder.toString();

    }
}
