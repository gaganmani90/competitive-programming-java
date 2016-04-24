package codejam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CountingSheep {
	
	
	public static void main(String[] args) {
		int noOfTests;
		CountingSheep countingSheep = new CountingSheep();
		Scanner scan = new Scanner(System.in);
		noOfTests = scan.nextInt();
		int[] inputs = takeInputs(noOfTests, scan);
		String[] outputs = new String[inputs.length];
		
		for(int i=0; i<outputs.length; i++){
			outputs[i] = countingSheep.lastNamedNumber(inputs[i]);
		}
		printOutput(outputs);
	}
	
	private static int[] takeInputs(int testCases, Scanner scan){
		int[] inputs = new int[testCases];
		for(int i=0; i<testCases; i++){
			inputs[i] = scan.nextInt();
		}
		return inputs;
	}
	private static void printInputs(Object[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	private String lastNamedNumber(long N){
		HashSet<Long> zeroToNine = new HashSet<>();
		if(N == 0){
		return "INSOMNIA";
		}
		else if(N == 1){
			return "10";
		}
		else{
			String lastN = "";
			int i = 1;
			while(true){
				if(isLastumber(N * i, zeroToNine)){
					lastN = Long.toString(N * i);
					break;
				}
				i++;
			}
			return lastN;
		}
	}
	
	private boolean isLastumber(long N, HashSet<Long> zeroToNine){
		while(N > 0){
			zeroToNine.add(N % 10);
			if(zeroToNine.size()==10) return true;
			N = N / 10;
		}
		return false;
	}
	
	private static void printOutput(String[] outputs){
		for(int i=0; i<outputs.length; i++){
			System.out.println("Case #"+(i+1)+": "+outputs[i]);
		}
	}

}
