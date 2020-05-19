import java.io.*;
public class _06EditDistance{

	//Recursive Approach
	public static int editDistance(String s1, String s2){
		//Base Case 
		if(s1.length() == 0 )
			return s2.length();
		if(s2.length() == 0)
			return s1.length();
		//Recursive Case
		
		//If both the characters match we need not do modification
		if(s1.charAt(0) == s2.charAt(0))
			return editDistance(s1.substring(1),s2.substring(1));

		//Don't match We need to perform one of the operation
 		int option1 = editDistance (s1.substring(1),s2);
		int option2 = editDistance (s1,s2.substring(1));
		int option3 = editDistance (s1.substring(1),s2.substring(1));

		return 1 + Math.min(option1,Math.min(option2,option3));
			
	}
	
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		System.out.println(editDistance(s1,s2));
	}
}