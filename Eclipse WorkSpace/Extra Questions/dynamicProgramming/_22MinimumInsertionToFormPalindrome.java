package dynamicProgramming;
import java.io.*;
//https://practice.geeksforgeeks.org/problems/form-a-palindrome/0
//https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
public class _22MinimumInsertionToFormPalindrome {
	
	//Approach Variation of the problem Minimum No of deletions to make string palindromic
	//T: O(N^2) , S: O(N)
	static int dp[] = new int[41];
	public static int formPalindrome(String s){
		String sRev = (new StringBuffer(s)).reverse().toString();//For reversing using stringbuffer
		int n = s.length(),m= s.length();
		for(int j = 0 ;j < m;j++)
			dp[j] = 0;
		int diagonal , temp ;
		for(int i = 1 ;i < n+1 ;i++){
			diagonal = 0;
			
			for(int j = 1; j < m+1 ;j++){
				temp = dp[j];
				if(s.charAt(i-1) == sRev.charAt(j-1))
					dp[j] = 1 + diagonal;
				else
					dp[j] = Math.max(dp[j],dp[j-1]);
				diagonal = temp;
			}
		}
		return n - dp[n];
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < test ;t++){
			String s = br.readLine();
			System.out.println(formPalindrome(s));
		}
	}
}
