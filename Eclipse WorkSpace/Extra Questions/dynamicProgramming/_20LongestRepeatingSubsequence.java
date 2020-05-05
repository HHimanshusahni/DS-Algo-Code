package dynamicProgramming;
import java.io.*;
//https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence/0
//https://www.geeksforgeeks.org/longest-repeated-subsequence/
public class _20LongestRepeatingSubsequence {
	//This problem is variation of LCS 
	//Bottom Up DP Approach 2d dp array Space Complexity : O(n^2)
	static int dp[][] = new int[1001][1001];
	public static int longestRepeatingSubsequence(String X ,int n){
		for(int i = 0 ;i < n+1 ;i++)
			dp[i][0] = 0 ;
		for(int j = 0 ;j < n + 1 ;j++)
			dp[0][j] = 0;
		
		for(int i = 1 ;i < n+1 ;i++){
			for(int j = 1 ;j < n+1 ;j++){
				if(X.charAt(i-1) == X.charAt(j-1) && i != j ){ //i != j is the only addition in the lcs code
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
				}
			}
		}
		return dp[n][n];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t = 0 ;t < testCase ; t++){
			int n = Integer.parseInt(br.readLine());
			String X = br.readLine();
			System.out.println(longestRepeatingSubsequence(X,n));
		}
	}
}
