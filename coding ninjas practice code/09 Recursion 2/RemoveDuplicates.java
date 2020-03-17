import java.io.*;
public class RemoveDuplicates{
	// approach 		strin|g
	public static String removeConsecutiveDuplicates(String s){
		// base case
		if(s.length() <= 1)
			return s;
		// Recursive case
		String smallAns = removeConsecutiveDuplicates(s.substring(0,s.length()-1));

		// Small Calculation
		char prev = smallAns.charAt(smallAns.length()-1);
		char current = s.charAt(s.length()-1);
		return prev == current ? smallAns :smallAns+current;
	}

	// approach 2 s|tring
	public  static String removeConsecutiveDuplicates_2(String s){
		// base case
		if(s.length()<=1)
			return s;
		//Recursive  case
		String smallAns = removeConsecutiveDuplicates_2(s.substring(1));

		// Small Calculation
		return smallAns.charAt(0) == s.charAt(0) ? smallAns : s.charAt(0)+smallAns; 
	}
	public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(removeConsecutiveDuplicates_2(br.readLine()));
	}
}