package dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3453/
 * <p>
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 * <p>
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 * <p>
 * Return the sum of these numbers.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 */
public class SumOfBinaryNumbers {
    List<String> binaries = new ArrayList<>();

    public int sumRootToLeaf(Node root) {
        update(root, "");
        return getSum();
    }

    private int getSum() {
        int sum = 0;
        for (String curr : binaries) {
            sum += Integer.parseInt(curr, 2);
        }
        return sum;
    }

    private void update(Node root, String binary) {
        if (root == null) {
            return;
        }
        binary += root.data;
        //leaf node
        if (root.right == null && root.left == null) {
            binaries.add(binary);
        } else {
            update(root.right, binary);
            update(root.left, binary);
        }


    }
}



