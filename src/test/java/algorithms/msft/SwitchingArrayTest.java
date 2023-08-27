package algorithms.msft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwitchingArrayTest {

        @Test
        void switchingArrayTest1() {
            int[] arr = new int[]{3, 2, 3, 2, 3};
            Assertions.assertEquals(5, SwitchingArray.switchingArray(arr));
        }

    @Test
    void switchingArrayTest11() {
        int[] arr = new int[]{7, 4, -2, 4, -2, -9};
        Assertions.assertEquals(4, SwitchingArray.switchingArray(arr));
    }

        @Test
        void switchingArrayTest2() {
            int[] arr = new int[]{3, 7, 3, 7, 2, 1, 2};
            Assertions.assertEquals(4, SwitchingArray.switchingArray(arr));
        }

        @Test
        void switchingArrayTest3() {
            int[] arr = new int[]{1, 5, 6, 0, 1, 0};
            Assertions.assertEquals(3, SwitchingArray.switchingArray(arr));
        }

        @Test
        void switchingArrayTest4() {
            int[] arr = new int[]{7, -5, -5, -5, 7, -1, 7};
            Assertions.assertEquals(3, SwitchingArray.switchingArray(arr));
        }

    @Test
    void switchingArrayTest14() {
        int[] arr = new int[]{4};
        Assertions.assertEquals(1, SwitchingArray.switchingArray(arr));
    }
}