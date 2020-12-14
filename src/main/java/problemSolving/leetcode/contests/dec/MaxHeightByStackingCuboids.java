package problemSolving.leetcode.contests.dec;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
 */
public class MaxHeightByStackingCuboids {

    public int maxHeight(int[][] cuboids) {
        int maxHeight = 0;
        List<Cuboid> cubes = createCubes(cuboids);

        System.out.println(cubes);

        int size = cubes.size();
        int[] dp = new int[size]; //dp array


        for (int j = 0; j < size; j++) {
            dp[j] = cubes.get(j).d3; //largest dimension of jth cube
            for (int i = 0; i < j; ++i) {
                Cuboid iCube = cubes.get(i);
                Cuboid jCube = cubes.get(j);
                if (iCube.compareSize(jCube) >= 1) {
                    dp[j] = Math.max(dp[j], dp[i] + jCube.d3);
                }
            }
            maxHeight = Math.max(maxHeight, dp[j]);
        }
        return maxHeight;
    }


    /**
     * sorts individual cuboid and creates list of cuboids
     *
     * @param cuboids
     * @return
     */
    private List<Cuboid> createCubes(int[][] cuboids) {
        List<Cuboid> cubes = new ArrayList<>();
        //sort each cube's dimension
        for (int[] cube : cuboids) {
            Arrays.sort(cube);
            cubes.add(new Cuboid(cube[0], cube[1], cube[2]));
            Collections.sort(cubes);
        }
        return cubes;
    }


    public static void main(String[] args) {
        MaxHeightByStackingCuboids maxHeightByStackingCuboids = new MaxHeightByStackingCuboids();
        Assert.assertEquals(190, maxHeightByStackingCuboids.maxHeight(new int[][]{
                {50, 45, 20},
                {95, 37, 53},
                {45, 23, 12}
        }));
        Assert.assertEquals(76, maxHeightByStackingCuboids.maxHeight(new int[][]{
                {38,25,45},
                {76,35,3}
        }));
        Assert.assertEquals(102, maxHeightByStackingCuboids.maxHeight(new int[][]{
                {7,11,17},
                {7,17,11},
                {11,7,17},
                {11,17,7},
                {17,7,11},
                {17,11,7}
        }));
    }
}

class Cuboid implements Comparable<Cuboid> {
    int d1, d2, d3;

    public Cuboid(int d1, int d2, int d3) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }
    /**
     * we are not comparing volume or area because at this point,
     * we have not finalized which dimension is what.
     *
     * This is sorting by descending order of dimensions
     * @param cuboid
     * @return
     */
    @Override
    public int compareTo(Cuboid cuboid) {
        if (this.d1 != cuboid.d1) {
            return cuboid.d1 - this.d1;
        } else if (this.d2 != cuboid.d2) {
            return cuboid.d2 - this.d2;
        }
        return cuboid.d3 - this.d3;
    }

    public int compareSize(Cuboid cuboid) {
        if(this.d1 >= cuboid.d1 && this.d2 >= cuboid.d2 && this.d3 >= cuboid.d3) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Cuboid{" +
                "d1=" + d1 +
                ", d2=" + d2 +
                ", d3=" + d3 +
                '}';
    }
}
