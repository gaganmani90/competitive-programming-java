package dataStructure.graph;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.*;

/**
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * <p>
 * Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return the shortest distance for the ball to stop at the destination. If the ball cannot stop at destination, return -1.
 * <p>
 * The distance is the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included).
 * <p>
 * You may assume that the borders of the maze are all walls (see examples).
 * <p>
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3771/
 */
@Slf4j
public class BallShortDistance {
    public static void main(String[] args) {
        Assert.assertEquals(26, new BallShortDistance().shortestDistance(new int[][]{
                        {0, 0, 0, 0, 1, 0, 0}, {0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0}},
                new int[]{0, 0},
                new int[]{8, 6}
        ));
        Assert.assertEquals(-1, new BallShortDistance().shortestDistance(new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}},
                new int[]{0, 4},
                new int[]{3, 2}
        ));
        Assert.assertEquals(12, new BallShortDistance().shortestDistance(new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}},
                new int[]{0, 4},
                new int[]{4, 4}
        ));
        Assert.assertEquals(-1, new BallShortDistance().shortestDistance(new int[][]{
                        {0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 1},
                        {0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {0, 1, 0, 0, 0}},
                new int[]{4, 3},
                new int[]{0, 1}
        ));
    }

    public enum DIRECTION {
        UP(-1, 0), DOWN(1, 0), RIGHT(0, 1), LEFT(0, -1);
        int row, col;

        DIRECTION(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        Set<Point> visited = new HashSet();
        Point startPoint = new Point(start[0], start[1], 0);
        queue.add(startPoint);
        visited.add(startPoint);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            visited.add(p);
            if (p.x == destination[0] && p.y == destination[1]) {
                return p.step;
            } else {
                //move the ball in every possible direction
                for (DIRECTION dir : DIRECTION.values()) {
                    Point tempDestination = rollUntilHitsTheWall(p, dir, maze);
                    if (!visited.contains(tempDestination)) {
                        queue.add(tempDestination);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * check if the next point in the maze is not a wall
     * @param direction
     * @param x
     * @param y
     * @param maze
     * @return
     */
    private boolean isWallHit(DIRECTION direction, int x, int y, int[][] maze) {
        int nextRow = x + direction.row;
        int nextCol = y + direction.col;
        if (nextRow < maze.length &&
                nextRow >= 0 && nextCol < maze[0].length
                && nextCol >= 0
                && maze[nextRow][nextCol] == 0) {
            return false;
        }
        return true;
    }

    /**
     * keep moving until it hits the wall
     *
     * @param direction
     * @return
     */
    public Point rollUntilHitsTheWall(Point p, BallShortDistance.DIRECTION direction, int[][] maze) {
        int nextX = p.x, nextY = p.y;
        int count = 0;

        //keep moving until it hits the wall
        while (!isWallHit(direction, nextX, nextY, maze)) {
            nextX += direction.row;
            nextY += direction.col;
            count++;
        }
        return new Point(nextX, nextY, p.step+count);
    }
}

class Point implements Comparable<Point>{
    int x, y;
    int step;

    public Point(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }

    @Override
    public boolean equals(Object other) {
        Point p1 = (Point) other;
        if (this.x == p1.x && this.y == p1.y) {
            return true;
        }
        return false;
    }


    @Override
    public int hashCode() {
        return x + y;
    }

    @Override
    public String toString() {
        return x + ":" + y;
    }

    @Override
    public int compareTo(Point o) {
        return this.step - o.step;
    }
}

