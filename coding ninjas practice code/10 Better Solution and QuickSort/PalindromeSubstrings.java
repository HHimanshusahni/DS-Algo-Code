import java.io.*;
public class PalindromeSubstrings{
//Approach1 : Find all the substrings of a given string --> O(n^2) and check wheather given substring is palindrome O(n) ==> O(n^3)
	
	//Approach 2 ==> O(n^2) 
	//https://www.geeksforgeeks.org/count-palindrome-sub-strings-string-set-2/#:~:text=Iterate%20the%20loop%20twice%20for,return%20the%20count%20at%20last
	
	public static int countPalindromeSubstrings(String s){
		int count = 0;
		int left = 0;
		int right = 0;
		//finding odd length palindrome substring
		for(int i = 0;i<s.length();i++){
			count++;//for single length string
			left = i-1;
			right = i+1;

			while (left>=0  && right < s.length() && s.charAt(left) == s.charAt(right)){
					count++;
					left--;
					right++;				
			}
		}
	
		//finding even length palindrome substring
		for(int i = 0;i<s.length()-1;i++){
			left = i-1;
			right = i+2;
			if(s.charAt(i)==s.charAt(i+1)){
				count++;
				while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
				 	count++;
				 	left--;
				 	right++;
				}
			}	
		}


		return count;
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int count = countPalindromeSubstrings(str);
		System.out.println(count);
	}
}