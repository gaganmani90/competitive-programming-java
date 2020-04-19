package problemSolving.leetcode.contests;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableFoodOrdersTest {

    @Test
    public void displayTable() {
    }

    @Test
    public void test() {
        List<List<String>> orders = new ArrayList<List<String>>();

        orders.add(Arrays.asList(new String[]{"David","3","Ceviche"}));
        orders.add(Arrays.asList(new String[]{"Corina","10","Beef Burrito"}));
        orders.add(Arrays.asList(new String[]{"David","3","Fried Chicken"}));
        orders.add(Arrays.asList(new String[]{"Carla","5","Water"}));
        orders.add(Arrays.asList(new String[]{"Carla","5","Ceviche"}));
        orders.add(Arrays.asList(new String[]{"Rous","3","Ceviche"}));

        TableFoodOrders foodOrders = new TableFoodOrders();

        System.out.println(foodOrders.displayTable(orders));
        Assert.assertEquals("" +
                        "[[Table, Beef Burrito, Ceviche, Fried Chicken, Water], " +
                        "[3, 0, 2, 1, 0], " +
                        "[5, 0, 1, 0, 1], " +
                        "[10, 1, 0, 0, 0]]",
                foodOrders.displayTable(orders).toString());
    }

    @Test
    public void test1() {
        List<List<String>> orders = new ArrayList<List<String>>();

        orders.add(Arrays.asList(new String[]{"James","12","Fried Chicken"}));
        orders.add(Arrays.asList(new String[]{"Ratesh","12","Fried Chicken"}));
        orders.add(Arrays.asList(new String[]{"Amadeus","12","Fried Chicken"}));
        orders.add(Arrays.asList(new String[]{"Adam","1","Canadian Waffles"}));
        orders.add(Arrays.asList(new String[]{"Brianna","1","Canadian Waffles"}));

        TableFoodOrders foodOrders = new TableFoodOrders();

        Assert.assertEquals("" +
                        "[[Table, Canadian Waffles, Fried Chicken], " +
                        "[1, 2, 0], " +
                        "[12, 0, 3]]",
                foodOrders.displayTable(orders).toString());
    }

    @Test
    public void test2() {
        List<List<String>> orders = new ArrayList<List<String>>();

        orders.add(Arrays.asList(new String[]{"James","12","Fried Chicken"}));
        orders.add(Arrays.asList(new String[]{"Ratesh","10","Fried Chicken"}));
        orders.add(Arrays.asList(new String[]{"Amadeus","12","Fried Chicken"}));
        orders.add(Arrays.asList(new String[]{"Adam","1","Canadian Waffles"}));
        orders.add(Arrays.asList(new String[]{"Brianna","2","Canadian Waffles"}));

        TableFoodOrders foodOrders = new TableFoodOrders();

        Assert.assertEquals("" +
                        "[[Table, Canadian Waffles, Fried Chicken], " +
                        "[1, 1, 0], " +
                        "[2, 1, 0], " +
                        "[10, 0, 1], " +
                        "[12, 0, 2]]",
                foodOrders.displayTable(orders).toString());
    }

    @Test
    /**
     * [["CWdAM","10"," FlzD"],[" T","17","ok"],["hai ","17","BlXft"],["cTIg","15","MAvix"],
     * ["jxK","9"," FlzD"],["vqkCX","14","pLg"],["qwqB","3","yPsk"],["YR","15","zG"],
     * ["ovex","11","pLg"],["zHeWJ","14","TdmVi"],["L ","9","Ey"],["lyS","14","zG"],
     * ["vasR","14","ok"],["NtfZt","14","yPsk"],["IN","5","xau"],["GQ","5","bcr"]]
     */
    public void test4() {
        List<List<String>> orders = new ArrayList<List<String>>();

        orders.add(Arrays.asList(new String[]{"Laura","2","Bean Burrito"}));
        orders.add(Arrays.asList(new String[]{"Jhon","2","Beef Burrito"}));
        orders.add(Arrays.asList(new String[]{"Melissa","2","Soda"}));

        TableFoodOrders foodOrders = new TableFoodOrders();

        System.out.println(foodOrders.displayTable(orders));

        /**
         * Expected
         * [["Table"," FlzD","BlXft","Ey","MAvix","TdmVi","bcr","ok","pLg","xau","yPsk","zG"],
         * ["3","0","0","0","0","0","0","0","0","0","1","0"],["5","0","0","0","0","0","1","0","0","1","0","0"],
         * ["9","1","0","1","0","0","0","0","0","0","0","0"],["10","1","0","0","0","0","0","0","0","0","0","0"],
         * ["11","0","0","0","0","0","0","0","1","0","0","0"],["14","0","0","0","0","1","0","1","1","0","1","1"],
         * ["15","0","0","0","1","0","0","0","0","0","0","1"],["17","0","1","0","0","0","0","1","0","0","0","0"]]
         */

        /**
         * Actual
         *
         * [["Table"," FlzD","BlXft","Ey","MAvix","TdmVi","bcr","ok","pLg","xau","yPsk","zG"],[
         * "17","0","1","0","0","0","0","1","0","0","0","0"],["3","0","0","0","0","0","0","0","0","0","1","0"],
         * ["5","0","0","0","0","0","1","0","0","1","0","0"],["9","1","0","1","0","0","0","0","0","0","0","0"],
         * ["10","1","0","0","0","0","0","0","0","0","0","0"],["11","0","0","0","0","0","0","0","1","0","0","0"],
         * ["14","0","0","0","0","1","0","1","1","0","1","1"],["15","0","0","0","1","0","0","0","0","0","0","1"]]
         */
    }
}