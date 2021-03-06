package dynamicProgramming;
import java.io.*;
import java.util.Arrays;
//https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
//https://practice.geeksforgeeks.org/problems/longest-common-subsequence/0
public class _12LongestCommonSubsequence {
	//Recursive Approach
	public static int LCS(String X, String Y, int n , int m ){
		//Base Case
		if(n == 0 || m == 0)
			return 0;
		//Recursive Case from Choice diagram
		//If the characters of the strings match , then we include in the LCS
		if(X.charAt(n-1)== Y.charAt(m-1))
			return 1 + LCS(X,Y ,n-1,m - 1);
		else //If the characters of the string don't match
			return Math.max(LCS(X,Y,n-1,m),LCS(X,Y,n,m-1));

	}

	//Memoization Approach
	static int dp[][] = new int[101][101];//Intialize size based on the question
	public static int LCS_Mem(String X, String Y, int n , int m){
		for(int i = 0 ;i< n + 1 ;i++){
			Arrays.fill(dp[i], 0,m +1,-1);
		}
		return LCS_2(X,Y,n,m);
	}
	public static int LCS_2(String X, String Y, int n , int m ){
		//Base Case
		if(n == 0 || m == 0)
			return 0;
		//Check the dp matrix
		if(dp[n][m] != -1)
			return dp[n][m];

		//Recursive Case from Choice diagram
		//If the characters of the strings match , then we include in the LCS
		if(X.charAt(n-1)== Y.charAt(m-1))
			return dp[n][m] = 1 + LCS_2(X,Y ,n-1,m - 1);
		else //If the characters of the string don't match
			return dp[n][m] = Math.max(LCS_2(X,Y,n-1,m),LCS_2(X,Y,n,m-1));

	}

	//Bottom approach
	public static int LCS_3(String X,String Y, int n ,int m){
//             Initialization using base case of the recursive code
		for(int i = 0 ;i < n+1 ;i++)
			dp[i][0] = 0;
		for(int j = 0 ;j < m+1 ;j++)
			dp[j][0] = 0;
		for(int i = 1; i < n+1;i++){
			for(int j = 1; j< m+1;j++){
				if(X.charAt(i-1)== Y.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);	
			}
		}
		return dp[n][m];

	}
	//1d array approach
	static int	dp1d[] = new int[100+1];
	public static int LCS_4(String X,String Y, int n ,int m){
		Arrays.fill(dp1d,0,m+1,0);
		int previous ; //represents the i -1 & j-1 th value
		int temp ;
		for(int i = 1 ;i < n+1 ;i++){
			previous = 0; // Important we have to do this for every iteration as the diagonal element is 0 for first element
			for(int j = 1; j< m+1;j++){
				temp = dp1d[j];
				if(X.charAt(i-1)== Y.charAt(j-1))
					dp1d[j] = 1 + previous;
				else
					dp1d[j] = Math.max(dp1d[j],dp1d[j-1]);
				previous = temp;
			}
		}
		return dp1d[m];
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < testCases;t++){
			String strArr[] = br.readLine().split(" ");
			int n = Integer.parseInt(strArr[0]);
			int m = Integer.parseInt(strArr[1]);
			String X = br.readLine();
			String Y = br.readLine(); 
			System.out.println(LCS_4(X,Y,n,m));
		}

	}

}
