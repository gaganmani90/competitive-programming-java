package problemSolving.leetcode.contests;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode.com/contest/weekly-contest-198/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
 */
public class SubTreeSameLabel {
    static HashMap<Integer, Character> labelsNode = new HashMap<>();
    static Node[] graph;


    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        init(labels, n);
        graph = createGraph(edges, n);
        int[] output = new int[n];

        dfs(graph[0], new boolean[n]);

        for (int i = 0; i < n; i++) {
            output[i] = graph[i].getLabelSum();
        }


        return output;
    }

    /**
     * @param edges
     * @param n
     * @return
     */
    private static Node[] createGraph(int[][] edges, int n) {
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].children.add(graph[to]);
            //graph[to].children.add(graph[from]);
        }
        return graph;
    }

    /**
     * @param labels
     * @param n
     */
    private static void init(String labels, int n) {
        //initialize labels to node value mapping
        int count = 0;
        for (char c : labels.toCharArray()) {
            labelsNode.put(count++, c);
        }

        //initialize graph
        graph = new Node[n]; //graph size
        for (int i = 0; i < n; i++) {
            graph[i] = new Node(i);
        }
    }

    private static void dfs(Node node, boolean[] visited) {
        if (visited[node.value]) {
            return;
        } else {
            visited[node.value] = true; //visiting now
            for (Node currNode : node.children) {
                if (visited[currNode.value]) {
                    continue;
                }
                System.out.println("visiting "+currNode.value);
                dfs(currNode, visited); //keep digging
                for (int i = 0; i < 26; i++) {
                    node.charCount[i] += currNode.charCount[i]; //accumulates label count to parent node
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] output = SubTreeSameLabel.countSubTrees(7, new int[][]{
                        {0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}
                }, "abaedcd"
        );
        //output [2,1,1,1,1,1,1]
        Assert.assertEquals(2, output[0]
        );

        System.out.println(Arrays.toString(output));
    }
}

class Node {
    char label;
    int value; //unique to each node
    List<Node> children;
    int[] charCount; //array of 26 characters, accumulates character count of all its children

    public Node(int value) {
        this.label = SubTreeSameLabel.labelsNode.get(value);
        this.value = value;
        children = new ArrayList<>();
        charCount = new int[26];
        charCount[label - 'a'] = 1; //for itself
    }

    /**
     * returns only count of label character
     * @return
     */
    public int getLabelSum() {
        return this.charCount[label - 'a'];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return label == node.label &&
                value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "label=" + label +
                ", value=" + value +
                '}';
    }
}


