package dynamicProgramming;
import java.io.*;
//https://www.geeksforgeeks.org/longest-repeated-subsequence/
public class _20PrintingLongestReapeatingSubsequence {
	//Different approach on gfg
	//My approach not sure about the correctness but giving giving correct result on the testCases
	//This will print one of the longest repeating  subsequence
	public static String printLongestRepeatingSubsequence(String X ,int n){
		int dp[][] = getTable(X,n);
		String ans = "";
		int i = n  ,j = n;
		while(i > 0 && j > 0){
			if(X.charAt(i-1) == X.charAt(j-1) && i != j){
				ans = X.charAt(i-1)+ans;
				i--;
				j--;
			}else if(dp[i][j-1] > dp[i-1][j])
 
				j--;
			else
				i--;

		}
		return ans;
	}
	//Same code as the  _20LongestRepeatingSubsequence which finds the length
	public static int[][] getTable(String X , int n){
		int dp[][] = new int[n+1][n+1];
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
		return dp;//return the table matrix
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for(int t = 0 ;t < testCase ; t++){
			int n = Integer.parseInt(br.readLine());
			String X = br.readLine();
			System.out.println(printLongestRepeatingSubsequence(X,n));
		}
	}
}
