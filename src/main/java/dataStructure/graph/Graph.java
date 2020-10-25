package dataStructure.graph;

import com.google.common.base.Preconditions;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Assumption : If there are n number of vertices, graph nodes will start from 0 till n-1.
 */
@Data
@Getter
@ToString
@Slf4j
@Deprecated
public class Graph {

    int numberOfVertices;
    private LinkedList<Integer> adjacent[];
    private GraphType type;

    enum GraphType {
        UNDIRECTED, DIRECTED
    }


    public Graph(int v, GraphType type) {
        this.numberOfVertices = v;
        this.type = type;
        adjacent = new LinkedList[v];
        //initialize adjacent nodes.
        for (int i = 0; i < v; i++) {
            adjacent[i] = new LinkedList<>();
        }

    }

    /**
     * Linking source and destination nodes with edge
     *
     * @param source
     * @param destination
     */
    public void addEdge(int source, int destination) {
        this.adjacent[source].add(destination);
        if (this.type.equals(GraphType.UNDIRECTED)) {
            this.adjacent[destination].add(source);//for undirected graph
        }
    }

    public List<Integer> getAdjacentNodes(int v) {
        return this.adjacent[v];
    }

    public void print() {
        System.out.println(this.toString());
    }
}

/**
 * Node in a graph
 */
@Getter
@Slf4j
class Node {
    private String val;
    private List<Node> adjacent;

    Node(String val) {
        this.val = val;
        adjacent = new LinkedList<>();
    }

    public void addEdge(Node node) {
        this.adjacent.add(node);
        log.info(String.format("ADD EDGE: [%s -> %s]", val, node.getVal()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val.equals(node.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val+", ");
        //adjacent.stream().forEach(node -> sb.append(node.val+","));
        return sb.toString();
    }
}

/**
 * Responsible to maintain  list of graph nodes,
 * creating edges,
 * maintaining visited memory etc.
 */
@ToString
@Slf4j
class GraphContainer {
    enum GraphType {
        UNDIRECTED, DIRECTED
    }
    private GraphType type = GraphType.DIRECTED;
    private HashMap<Node, Boolean> nodes;
    private int size = Integer.MAX_VALUE;

    /**
     * [Optional]Initialize with fixed size
     * @param size
     */
    public GraphContainer(int size, GraphType type) {
        this.size = size;
        this.type = type;
        nodes = new HashMap<>();
    }

    public GraphContainer(GraphType type) {
        this.type = type;
        nodes = new HashMap<>();
    }

    public Node createNode(String val) {
        Node node = new Node(val);
        if(nodes.containsKey(node)) {
            log.error("DUPLICATE-NODE: ignore");
            return null;
        }
        Preconditions.checkArgument(nodes.size() < size, "Graph size exceeded");
        nodes.put(node, false);
        log.info(String.format("CREATE NODE: node created with value %s", val));
        return node;
    }

    public void addEdge(Node n1, Node n2) {
        //check if nodes exist in list, if not add
        checkIfPresentElseAdd(n1);
        checkIfPresentElseAdd(n2);
        n1.addEdge(n2);
        if (type.equals(Graph.GraphType.UNDIRECTED)) {
            n2.addEdge(n1);
        }
    }

    private void checkIfPresentElseAdd(Node n1) {
        Preconditions.checkNotNull(n1);
        if(!nodes.containsKey(n1)) {
            if (nodes.size() < size) {
                log.info("Adding node :" + n1.getVal());
                nodes.put(n1, false);
                return;
            } else {
                log.error("Node size exceeded, cannot add more nodes");
            }
        }
    }

    public int size() {
        return nodes.size();
    }

    public int maxSize() {
        return size;
    }

    /**
     * Mark all nodes unvisited
     */
    public void reset() {
        this.nodes.keySet().forEach(node -> nodes.put(node, false));
    }

    public void markVisited(Node n) {
        Preconditions.checkNotNull(n);
        nodes.put(n, true);
    }

    public boolean isVisited(Node n) {
        Preconditions.checkNotNull(n);
        return nodes.get(n);
    }

}
