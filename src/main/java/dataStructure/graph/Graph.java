package dataStructure.graph;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Node in a graph
 */
@Getter
@Slf4j
class Node {
    private int val;
    private List<Node> adjacent;

    Node(int val) {
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
        return val == (node.val);
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
public class Graph {
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
    public Graph(int size, GraphType type) {
        this.size = size;
        this.type = type;
        nodes = new HashMap<>();
    }

    public Graph(GraphType type) {
        this.type = type;
        nodes = new HashMap<>();
    }

    public Node createNode(int val) {
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
        if (type.equals(GraphType.UNDIRECTED)) {
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
