package dataStructure.array.matrix;


import lombok.Data;

import java.util.LinkedList;

/**
 * Given a matrix of N*M order. Find the shortest distance from a source cell to a destination cell,
 * traversing through limited cells only. Also you can move only up, down, left and right. If found output the distance else -1.
 * s represents ‘source’
 * d represents ‘destination’
 * * represents cell you can travel
 * 0 represents cell you can not travel
 * This problem is meant for single source and destination.
 * <p>
 * Examples:
 * <p>
 * Input :
 * {'0', '*', '0', 's'},
 * {'*', '0', '*', '*'},
 * {'0', '*', '*', '*'},
 * {'d', '*', '*', '*'}
 * Output : 6
 * <p>
 * Input :
 * {'0', '*', '0', 's'},
 * {'*', '0', '*', '*'},
 * {'0', '*', '*', '*'},
 * {'d', '0', '0', '0'}
 * Output :  -1
 */
@Data
public class ShortestDistance {

    private String[][] route;
    private boolean[][] isVisited;
    Node source, destination;


    public ShortestDistance(String[][] route) {
        this.route = route;
        this.isVisited = initiateVisited(route);
        initializeSourceDestination();
    }

    class Node {
        int row;
        int col;
        int distance;

        public Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;

        }

        @Override
        public String toString() {
            return route[row][col];
        }
    }

    /**
     * Apply BFS traverse
     * @return
     */
    int getShortestDistance() {

        LinkedList<Node> queue = new LinkedList<>(); //store traversed elements
        queue.add(source);
        this.isVisited[source.row][source.col] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            //if destination is found
            if (this.route[node.row][node.col].equals(route[destination.row][destination.col])) {
                return node.distance;
            }

            //right
            updateQueue(node.row, node.col + 1, node.distance + 1, queue);

            //down
            updateQueue(node.row + 1, node.col, node.distance + 1, queue);

            //up
            updateQueue(node.row - 1, node.col, node.distance + 1, queue);

            //left
            updateQueue(node.row, node.col - 1, node.distance + 1, queue);

        }
        return -1;
    }

    private void updateQueue(int row, int col, int distance, LinkedList<Node> queue) {
        if (!isArrayOutOfBound(row, col) && !isVisited[row][col]) {
            isVisited[row][col] = true;
            queue.push(new Node(row, col, distance));
        }
    }

    private boolean isArrayOutOfBound(int row, int col) {
        if (row < route.length && row >= 0 && col >= 0 && col < route[0].length) {
            return false;
        }
        return true;
    }

    /**
     * Mark all nodes with "0" as visited
     */
    private boolean[][] initiateVisited(String[][] route) {

        boolean[][] isVisited = new boolean[route.length][route[0].length];

        for (int row = 0; row < isVisited.length; row++) {
            for (int col = 0; col < isVisited[row].length; col++) {
                if (route[row][col].equals("0")) {
                    isVisited[row][col] = true;
                } else {
                    isVisited[row][col] = false;
                }
            }
        }
        return isVisited;
    }

    private void initializeSourceDestination() {
        for (int row = 0; row < isVisited.length; row++) {
            for (int col = 0; col < isVisited[row].length; col++) {
                if (route[row][col].equals("s")) {
                    this.source = new Node(row, col, 0);
                }
                if (route[row][col].equals("d")) {
                    this.destination = new Node(row, col, 0);
                }
            }
        }
    }


}
