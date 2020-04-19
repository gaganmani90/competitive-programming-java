package problemSolving.leetcode.contests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 */
public class TableFoodOrders {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> displayOrders = new ArrayList<>();
        Map<Integer, Table> tables = new TreeMap<>();
        Set<String> foods = new TreeSet<>();
        for(List<String> order : orders) {
            int currTableNo = Integer.parseInt(order.get(1));
            String currFood = order.get(2);
            if(tables.containsKey(currTableNo)) {
                Table currTable = tables.get(currTableNo);
                currTable.takeOrder(currFood, 1); //add order
            } else {
                tables.put(currTableNo, new Table(currFood, currTableNo));
            }
            //prepare list of food
            foods.add(currFood);
        }

        displayOrders.add(firstRow(foods));
        for(Table table : tables.values()) {
            //add missing food
            table.addMissingFood(foods);
            displayOrders.add(table.getDisplayTable());
        }
        return displayOrders;
    }

    private List<String> firstRow(Set<String> food) {
        List<String> header = new ArrayList<>();
        header.add("Table");
        Iterator<String> iter = food.iterator();
        while(iter.hasNext()) {
            header.add(iter.next());
        }
        return header;
    }
}

class Table implements Comparable<Table> {
    Map<String, Integer> foodItems;
    int tableNumber;

    public Table(String food, int tableNumber) {
        this.tableNumber = tableNumber;
        foodItems = new TreeMap<>();
        foodItems.put(food, 1);
    }
    public void takeOrder(String food, int val) {
        foodItems.merge(food, val, Integer::sum);
    }

    public void addMissingFood(Set<String> food) {
        Iterator<String> currFood = food.iterator();
        while(currFood.hasNext()) {
            foodItems.merge(currFood.next(),0,Integer::sum);
        }
    }

    @Override
    public int compareTo(Table t) {
        return t.tableNumber - this.tableNumber;
    }

    public List<String> getDisplayTable() {
        List<String> display = new ArrayList<>();
        display.add(""+tableNumber);
        for(Integer itemCount : foodItems.values()) {
            display.add(itemCount+"");
        }
        return display;
    }
}
