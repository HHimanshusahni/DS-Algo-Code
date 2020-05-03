package dynamicProgramming;
import java.io.*;
//https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence/0
public class _17LongestPalindromicSubsequence {
/*The Longest Palindromic Subsequeunce of string s =
 * 		LCS( String s , Reverse(String s ))
 * */
	public static int lps(String s){
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		String reverseS = sb.toString();
		return LCS(s,reverseS,s.length(),s.length());
	}
	//Bottom Up LCS 1d dp array approach
	static int dp[] = new int[1001];
	public static int LCS(String X, String Y ,int n , int m ){
		for(int j = 0 ; j < m+1 ;j++)
			dp[j] = 0 ;
		int temp , diagonal;
		for(int i = 1 ; i < n+1 ;i++){
			diagonal = 0 ;
			for(int j = 1; j < m+1 ;j++){
				temp = dp[j];
				if(X.charAt(i-1) == Y.charAt(j-1))
					dp[j] = 1 + diagonal;
				else
					dp[j] = Math.max(dp[j],dp[j-1]);
				diagonal = temp;
			}
		}
		return dp[m];
	} 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < testCase; t++){
			System.out.println(lps(br.readLine()));
		}		
	}

}
