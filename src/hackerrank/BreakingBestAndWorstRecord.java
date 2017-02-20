package hackerrank;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Maria plays  games of college basketball in a season. Because she wants to go pro, she tracks her points scored per game sequentially in an array defined as . After each game , she checks to see if score  breaks her record for most or least points scored so far during that season.

Given Maria's array of  for a season of  games, find and print the number of times she breaks her record for most and least points scored during the season.

Note: Assume her records for most and least points at the start of the season are the number of points scored during the first game of the season.

Input Format

The first line contains an integer denoting  (the number of games). 
The second line contains  space-separated integers describing the respective values of .

Constraints

Output Format

Print two space-seperated integers describing the respective numbers of times her best (highest) score increased and her worst (lowest) score decreased.

Sample Input 0

9
10 5 20 20 4 5 2 25 1
Sample Output 0

2 4
Explanation 0

The diagram below depicts the number of times Maria broke her best and worst records throughout the season:

image

She broke her best record twice (after games  and ) and her worst record four times (after games , , , and ), so we print 2 4 as our answer. Note that she did not break her record for best score during game , as her score during that game was not strictly greater than her best record at the time.


 * @author gagamani
 *
 */
public class BreakingBestAndWorstRecord {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i=0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }
        
        printBestAndWorst(score);

	}
	
	private static void printBestAndWorst(int[] score){
		int bestCount  = 0,bestScore = score[0];
		
		int worstCount = 0, worstScore = score[0];
		
		for(int currScore : score){
			if(currScore > bestScore){
				bestScore = currScore;
				bestCount++;
			}
			if(currScore < worstScore){
				worstScore = currScore;
				worstCount++;
			}
		}
		
		System.out.println(bestCount+" "+worstCount);
	}

}
