package problemSolving.dynamic_programming;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Consider you are the owner of the paper factory and you have inventory of papers
 * You keep paper in foots
 * like your inventory contains
 * 5 foot of paper 1000 sheets
 * 2 foot of paper 2000 sheets
 *
 * so whenever the customer comes he ask you for the some paper sheets like 10 sheets of 5 foot
 * and you check your inventory if you have the ordered paper and quantity and provide customer with the order
 *
 * now here you can also cut the paper to fulfill sutomer order like if customer asks you for
 * 2 sheet of 2 foot and 1 sheet paper of 1 foot and unfornately you only have
 * 1 sheet paper of 5 foot, then in this case you can cut the 5 foot paper in
 * 2 foot sheet and 1 foot sheet and fullfill the order,
 * you have to implement a function which will determine if the customer order can be full filled or not.
 *
 * Java function can be lie below
 * boolean canFullfillOrder(List<List<integer>>custOrders, List<List<Integer>> inventory){
 * }
 *
 *
 * input  can be
 * custOrders : (1,2),(2,5),(3,5)
 * inventory :(1,5),(5,6),(3,8)
 *
 * TODO: complete
 */
public class SheetSupply {
    List<Sheets> inventory;

    public SheetSupply(int[][] inventory) {
        this.inventory = createSheets(inventory);
    }

    private List<Sheets> createSheets(int[][] sheets) {
        List<Sheets> inventory = new ArrayList<>();
        Arrays.stream(sheets).forEach(sheet -> inventory.add(Sheets.builder()
                .length(sheet[0])
                .count(sheet[1])
                .build()));
        Collections.sort(inventory);
        return inventory;
    }

    public boolean canFullfillOrder(int[][] order) {
        List<Sheets> orders = createSheets(order);
        for (Sheets currOrder : orders) {
            for (Sheets currInventory : this.inventory) {

            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] inventory = new int[][]{
                {1, 2},
                {2, 5},
                {3, 5}
        };
        int[][] orders = new int[][]{
                {1, 5},
                {5, 6},
                {3, 8}
        };

        SheetSupply supply = new SheetSupply(inventory);
        System.out.println(supply.inventory);

    }
}

@Getter
@Builder
@ToString
class Sheets implements Comparable<Sheets> {
    int length; //feet
    int count; //number of sheets

    @Override
    public int compareTo(Sheets o) {
        return Integer.valueOf(this.length).compareTo(Integer.valueOf(o.length));
    }

    public int capacity() {
        return length*count;
    }

    /**
     *
     * @param requiredLength
     * @param requiredCount
     * @return
     */
    public boolean consume(int requiredLength, int requiredCount) {
        if (requiredLength > this.length) {
            return false;
        } else if (requiredLength == this.length) {
            if (requiredCount > count) {
                return false;
            }
            count -= requiredCount;
            return true;
        } else { //required length is small TODO: complete this
            int requiredCapacity = requiredCount*requiredLength;
            return false;
        }
    }
}
