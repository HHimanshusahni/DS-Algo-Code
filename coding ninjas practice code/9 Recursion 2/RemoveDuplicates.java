import java.io.*;
public class RemoveDuplicates{
	// approach 		strin|g
	public static String removeConsecutiveDuplicates(String s){
		// base case
		if(s.length() == 1)
			return s;
		// Recursive case
		String smallAns = removeConsecutiveDuplicates(s.substring(0,s.length()-1));

		// Small Calculation
		char prev = smallAns.charAt(smallAns.length()-1);
		char current = s.charAt(s.length()-1);
		return prev == current ? smallAns :smallAns+current;
	}
	public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(removeConsecutiveDuplicates(br.readLine()));
	}
}