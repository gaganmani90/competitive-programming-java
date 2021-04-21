package dataStructure.tree;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;

import java.util.ArrayList;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class ListsOfDepth {
    public static ArrayList<ArrayList<BinaryTreeNode>> createLevelLinkedList_dfs(BinaryTreeNode root) {
        ArrayList<ArrayList<BinaryTreeNode>> lists = new ArrayList<>();
        createLevelLinkedListUtil(root, lists, 0);
        return lists;
    }

    private static void createLevelLinkedListUtil(BinaryTreeNode root,
                                                  ArrayList<ArrayList<BinaryTreeNode>> lists,
                                                  int level) {
        if (root == null) {
            return;
        }
        //contains nodes on a given level
        ArrayList<BinaryTreeNode> levelList = null;
        //create new list for level
        if (lists.size() == level) {
            levelList = new ArrayList<>();
            lists.add(levelList);
        } else {
            levelList = lists.get(level); //fetch exsiting levelList
        }
        levelList.add(root);
        createLevelLinkedListUtil(root.right, lists, level + 1);
        createLevelLinkedListUtil(root.left, lists, level + 1);
    }

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.right = new BinaryTreeNode(30);
        node.left = new BinaryTreeNode(20);
        node.left.left = new BinaryTreeNode(40);
        node.left.right = new BinaryTreeNode(50);

        Assert.assertEquals(3, createLevelLinkedList_dfs(node).size());
    }
}
