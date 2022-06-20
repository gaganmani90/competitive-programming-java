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
     * Union with rank, where rank decides who's parent is going to be chosen for
     * a union. If two sets are being joined, a set with higher number of node will become
     * parent.
     * @param parents
     * @param rank
     * @param x
     * @param y
     */
    public static void unionWithRank(int[] parents, int[] rank, int x, int y) {
        int xRoot = findWithRank(parents, x);
        int yRoot = findWithRank(parents, y);
        //cycle is not formed, proceed
        if(xRoot != yRoot) {
            if(rank[xRoot] > rank[yRoot]) {
                //X's root will become Y's root
                parents[yRoot] = xRoot;
            } else if (rank[xRoot] < rank[yRoot]) {
                //Y's root will become X's root
                parents[xRoot] = yRoot;
            } else { //same rank, then go with X
                parents[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    public static int findWithRank(int[] parents, int i) {
        //stop the search if root is found
        if(parents[i] == i) {
            return i;
        }
        //keep searching for it's root
        return findWithRank(parents, parents[i]);
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
