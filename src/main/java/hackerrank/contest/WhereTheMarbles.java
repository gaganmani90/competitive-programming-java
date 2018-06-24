package hackerrank.contest;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Jill and Bob are playing the following game:

There are  cups on saucers arranged in a straight line. Each saucer is numbered sequentially from  to .
The game starts when Jill watches Bob place a marble inside the cup on saucer number .
Bob then takes  turns. In each turn, he swaps the cups on a pair of saucers numbered  and , where . The diagram below shows an example:
image

After Bob completes all his turns, Jill chooses an integer from  to  denoting the saucer where she think the cup with the marble is located.
Given  and Bob's sequence of moves, print the saucer number denoting the marble's location at the end of the game.

Input Format

The first line contains two space-separated integers describing the respective values of  (the marble's initial location) and  (Bob's number of turns). 
Each line  of the  subsequent lines contains two space-separated integers,  and , describing the saucer numbers for the cups Bob swaps in his  move.

Constraints

Output Format

Print an integer denoting the saucer number of the cup containing the marble at the end of the game.

Sample Input 0

5 3
2 5
7 10
2 9
Sample Output 0

9
Explanation 0

Bob places the marble in the cup on saucer  and performs the following sequence of  moves:

image

Swap the cups in positions  and , so the marble is now in the cup on saucer .

image

Swap the cups in positions  and ; neither of these cups currently contains the marble, so the marble is still in the cup on saucer .

image

Swap the cups in positions  and , so the marble is now in the cup on saucer .

image
Because the marble is in the cup on saucer  at the end of the game, we print  as our answer.
 * @author gagamani
 *
 */
public class WhereTheMarbles {

	private static int[] arr = new int[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		arr[m-1] = 1;
		
		for(int i=0; i<n; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			swap(a-1, b-1);
			//System.out.println(Arrays.toString(arr));
		}
		
		for(int i=0; i<arr.length; i++){
			if(arr[i] == 1){
				System.out.println(i+1);
				break;
			}
		}
	

	}
	private static void swap(int ind1, int ind2){
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}

}
