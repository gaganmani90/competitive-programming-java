package dataStructure.graph.union_find;

public class UnionFindUtil {
    /**
     * connects x to y node
     * @param parents: contaians parent node id
     * @param x: from node
     * @param y: to node
     */
    public static void union(int[] parents, int x, int y) {
        int xParent = find(parents, x);
        int yParent = find(parents, y);

        //it means connecting the nodes will NOT form a cycle
        //these are disjointed sets
        if(xParent != yParent) {
            parents[yParent] = xParent; //make X the parent of Y
        }
    }

    /**
     * returns the root parent value of given node
     * @param parents
     * @param i: node to find
     * @return
     */
    public static int find(int[] parents, int i) {
        //Found the root node,
        //"i" is it's own parent
        if(parents[i] == -1) {
            return i;
        }
        return find(parents, parents[i]);
    }
}
