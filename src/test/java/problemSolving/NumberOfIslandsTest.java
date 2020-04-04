package problemSolving;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfIslandsTest {

    @Test
    public void numIslands() {
        Assert.assertEquals(1,NumberOfIslands.numIslands(
                new char[][]{
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                }));

        Assert.assertEquals(3,NumberOfIslands.numIslands(
                new char[][]{
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                }));
    }

}