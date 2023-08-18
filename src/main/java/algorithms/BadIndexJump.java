package algorithms;

public class BadIndexJump {
    // Initialize the current index and the jump index.
    public static void main(String[] args) {
        System.out.println(maxIndex(4, 6)); // Expected output: 9
        System.out.println(maxIndex(40, 10)); // Expected output: 819
        System.out.println(maxIndex(3, 3)); // Expected output: 5
        System.out.println(maxIndex(2, 1)); // Expected output: 2
    }

    public static int maxIndex(int steps, int badIndex) {
        int currentPosition = 0;
        int stepValue = 1;

        while (steps > 0) {
            if (currentPosition + stepValue != badIndex) {
                currentPosition += stepValue;
                steps--;
            }
            stepValue++;
        }

        return currentPosition;
    }
}
