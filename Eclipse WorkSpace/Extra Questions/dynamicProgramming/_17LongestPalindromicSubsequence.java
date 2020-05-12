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
	
	
	//Approach 2 
	/*Match the lps ( i , j ) = characters match => 2 + lps(i+1, j - 1)
	 *						  = characters don't match = Max( lps(i, j-1),lps(i+1,j))
	 *							= 1 if ( i == j) //Base Case
	 * */					  
	//Time Complexity bottom up O(n ^2) Space complexity :O(n^2)
	//https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
	//https://www.youtube.com/watch?v=U4yPae3GEO0

	public static int lps_2(String s ){
		int n = s.length();
		int dp[][] = new int[n][n];
		//One length strings is always palindrome
		for(int i = 1 ;i < n ;i++)
			dp[i][i] = 1;
		for(int length = 2 ;length <= n ;length++){
			for(int i = 0 ;i < n - length + 1 ;i++){
				int j = i + length -1 ;
				if(s.charAt(i) == s.charAt(j))
					dp[i][j] = 2 + dp[i+1][j-1];
				else 
					dp[i][j] = Math.max (dp[i][j-1], dp[i+1][j]);
			}	
		}
		return dp[0][n-1];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < testCase; t++){
			System.out.println(lps_2(br.readLine()));
		}		
	}

}
