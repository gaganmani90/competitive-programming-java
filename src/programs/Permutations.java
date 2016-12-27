package programs;

public class Permutations {

	public static void main(String[] args) {
		System.out.println(numPermutations(123452222));

	}
	
	static int numPermutations(int num)
	{
	  if (num < 10) {
	    return 1;
	  }

	  int lastTwo = num % 100;

	  if (lastTwo <= 26) {
	    return numPermutations(num / 100) + numPermutations(num / 10);
	  } else {
	    return numPermutations(num / 10);
	  }
	}

}
