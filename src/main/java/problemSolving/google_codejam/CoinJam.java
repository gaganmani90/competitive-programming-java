package problemSolving.google_codejam;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class CoinJam {

	static ArrayList<BigInteger> primeNos = new ArrayList<>();

	public static void main(String[] args) {

		CoinJam jam = new CoinJam();
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt(); //always be 1
		int N = scan.nextInt();
		int J = scan.nextInt();
		HashMap<BigInteger, BigInteger[]> coinjamDivisor = new HashMap<>();

		for(int i=0; i<J; i++){
			while(true){
				String number = "1"+generateRandomString(N-2)+"1";
				if(isJamCoin(number)){
					coinjamDivisor.put(new BigInteger(number), determineDivisorSet(number));
					break;
				}
			}
		}
		//System.out.println(coinjamDivisor);
		printOutput(coinjamDivisor);
		
		//System.out.println(isJamCoin("100011"));
		//System.out.println(Arrays.toString(determineDivisorSet("100011")));
		//System.out.println("N:"+N+" J: "+J);

	}

	private static void printOutput(HashMap<BigInteger, BigInteger[]> coinjamDivisor){
		System.out.println("Case #1:");
		for(BigInteger key : coinjamDivisor.keySet()){
			System.out.print(key.toString());
			for(BigInteger divisor : coinjamDivisor.get(key)){
				System.out.print(" "+divisor.toString()+" ");
			}
			System.out.println();
		}
	}
	private static boolean isJamCoin(String number){
		//System.out.println("Number: "+number);
		if(!number.startsWith("1") || !number.endsWith("1")){
			return false;
		}
		BigInteger[] baseNumbers = new BigInteger[9];
		for(int i=2; i<=10; i++){
			BigInteger baseNo = new BigInteger(number, i);
			baseNumbers[i-2] = baseNo;
			if(primeNos.contains(baseNo)){
				return false;
			}
			else{
				if(isPrime(baseNo)){
					primeNos.add(baseNo);
					return false;
				}
			}
		}

		return true;
	}

	private static boolean isPrime(BigInteger n) {
		if (n.compareTo(BigInteger.ONE) == -1 || n.compareTo(BigInteger.ONE) == 0) {
			return false;
		}
		if (n.compareTo(new BigInteger("2")) == 0) {
			return true;
		}
		for (int i = 2; i <= n.intValue() + 1; i++) {
			if (n.remainder(new BigInteger(i+""))  == BigInteger.ZERO) {
				return false;
			}
		}
		return true;
	}

	private static BigInteger getNontrivialDivisor(BigInteger n){
		for(BigInteger i=BigInteger.valueOf(2); 
				i.compareTo(n) == -1; i=i.add(BigInteger.ONE)){
			if(n.remainder(i) == BigInteger.ZERO){
				return i;
			}
		}
		return BigInteger.valueOf(-1);
	}

	private static BigInteger[] determineDivisorSet(String jamCoin){
		BigInteger[] baseNumbers = new BigInteger[9];
		for(int i=2; i<=10; i++){
			BigInteger baseNo = new BigInteger(jamCoin, i);
			baseNumbers[i-2] = baseNo;
		}
		BigInteger[] divisors = new BigInteger[9];
		for(int i=0; i < baseNumbers.length; i++){
			divisors[i] = getNontrivialDivisor(baseNumbers[i]);
		}
		return divisors;
	}

	private static String generateRandomString(int length){
		String bits = ""; 
		Random r = new Random(); 
		for(int i=0; i<length; i++){ 
			int x = 0; 
			if(r.nextBoolean()) x=1; 
			bits += x; 
		} 
		return bits;

	}
}
