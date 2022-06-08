package dataStructure.graph.union_find;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindUtilTest {
    private final int size = 10;
    private int[] parents;

    @BeforeEach
    public void setup() {
        parents = new int[size];
        Arrays.fill(parents, -1);
    }


    @Test
    void findTest() {
        Assert.assertEquals("itself is parent",5, UnionFindUtil.find(parents, 5));
        UnionFindUtil.union(parents, 4, 5);
        Assert.assertEquals("4 became parent",4, UnionFindUtil.find(parents, 5));
        UnionFindUtil.union(parents, 5, 6); //4->5->6
        Assert.assertEquals("4 became parent",4, UnionFindUtil.find(parents, 6));
        UnionFindUtil.union(parents, 3, 4); //3->4->5->6
        Assert.assertEquals("3 became parent",3, UnionFindUtil.find(parents, 6));
    }
}