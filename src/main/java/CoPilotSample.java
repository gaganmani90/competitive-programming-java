import java.util.Arrays;

public class CoPilotSample {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //print numbers from 1 to 100
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
        //print numbers from 1 to 100 in reverse order
        for (int i = 100; i >= 1; i--) {
            System.out.println(i);
        }

        //sort array {3,4,1} in ascending order and print it
        int[] arr = {3,4,1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
