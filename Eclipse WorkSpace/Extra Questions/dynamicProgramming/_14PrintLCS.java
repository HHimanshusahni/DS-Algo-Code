package dynamicProgramming;
import java.io.*;
import java.util.*;
//https://hack.codingblocks.com/app/practice/1/437/problem
//https://www.geeksforgeeks.org/printing-longest-common-subsequence/
public class _14PrintLCS {
	public static void printLCS(String A, String B){
		int n = A.length();
		int m = B.length();
		int dp[][] = getLCSTable(A,B,n,m);
		String ans = "";
		int i = n , j = m;
		while(i > 0 && j > 0){
			if(A.charAt(i-1) == B.charAt(j-1)){
				ans  = A.charAt(i-1)+ans;
				i--;
				j--;
			}else if(dp[i-1][j] > dp[i][j-1]){
				i--;
			}else{
				j--;
			}
		}
		System.out.println(ans);
	}
	static int dp[][] = new int[1001][1001];
	public static int[][] getLCSTable(String A, String B,int n,int m){
		//Initialization of dp table
		for(int i = 0 ;i< n + 1 ;i++)
			dp[i][0] = 0;
		for(int j = 0 ;j< m + 1 ;j++)
			dp[0][j] = 0 ;
		for(int i = 1 ; i < n + 1 ;i++){
			for(int j = 1 ;j < m + 1 ;j++){
				if(A.charAt(i-1)== B.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
			}
		}
		return dp;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		printLCS(A,B);

	}

}
