package hackerrank;

public class RemoveDuplicate {

	public static void main(String[] args) {
		removeDuplicate("abbabnnn");

	}
	
	
	private static void removeDuplicate(String str){
		int k = 0; 
		String newStr = "";
		
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i-1) != str.charAt(i)){
				newStr += str.charAt(i-1);
				if(i == str.length() - 1){
					newStr += str.charAt(i);
				}
				//k++;
			}
			else{
				while(str.charAt(i-1) == str.charAt(i)){
					i++;
				}
			}
			
			
		}
		
		if(newStr.length() != str.length()){
			removeDuplicate(newStr);
		}
		else{
			System.out.println(newStr);
		}
	}

}


