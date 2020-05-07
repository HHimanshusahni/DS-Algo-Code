import java.io.*;
import java.util.*;
public class _05LCS{
	//Recursive approach Exponential Time Complexity
	public static int lcs(String s1, String s2) {
		return lcs(s1,s2,s1.length(),s2.length());
	}
	public static int lcs(String s1 ,String s2 ,int n ,int m){
		//Base Case
		if(n == 0 || m == 0) // If any of the strings is empty the lcs is 0 
			return 0 ;
		if(s1.charAt(n-1) == s2.charAt(m - 1)) // If the character Matches then it becomes the part of the LCS
			return 1 + lcs(s1,s2,n - 1,m - 1);
		else
			return Math.max(lcs(s1,s2,n,m - 1), lcs(s1,s2,n - 1,m)); 
	}

	//Memoization Code Time Complexity : O( m x n)	Space : O ( n x m) + O(n)
	public static int lcs_2(String s1, String s2) {
		int n = s1.length(),m = s2.length();
		int dp[][] = new int[n + 1][m + 1 ];
		for(int i = 0 ; i < n + 1 ;i++){
			Arrays.fill(dp[i],0,m+1,-1);
		}
		return lcs_2(s1,s2,n,m,dp);
	}
	public static int lcs_2(String s1 ,String s2 ,int n ,int m,int dp[][]){
		//Base Case
		if(n == 0 || m == 0) 
			return 0 ;
		if(dp[n][m] != -1)
			return dp[n][m];
		if(s1.charAt(n-1) == s2.charAt(m - 1))
			return dp[n][m] = 1 + lcs_2(s1,s2,n - 1,m - 1,dp);
		else
			return dp[n][m] =  Math.max(lcs_2(s1,s2,n,m - 1,dp), lcs_2(s1,s2,n - 1,m,dp));
	}

	//Bottom Up Dynamic Programming Time Complexity : O( m x n)	Space : O ( n x m)
	public static int lcs_3(String s1 , String s2){
		int n = s1.length() , m = s2.length();
		int dp[][] = new int[n+1][m+1];
		for(int i = 0 ;i < n + 1 ;i++)
			dp[i][0] = 0 ; // Not requrired as by defalut values  are 0 
		for(int j = 0 ;j < m + 1;j++)
			dp[0][j] = 0;
		for(int i = 1;i < n + 1;i++){
			for(int j = 1 ;j < m + 1;j++){
				if(s1.charAt ( i -  1) == s2.charAt(j - 1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		return dp[n][m];
	}
	//Bottom Up Dynamic Programming Time Complexity : O( m x n)	Space : O ( n)
	public static int lcs_4(String s1 , String s2){
		int n = s1.length() , m = s2.length();
		int dp[] = new int[m + 1];
		for(int j = 0 ;j < m + 1; j++)
			dp[j] = 0 ;
		int diagonal, temp ;
		for(int i = 1 ;i < n + 1; i++){
			diagonal = 0 ;
			for(int j = 1 ;j < m + 1 ;j++){
				temp = dp[j];
				if(s1.charAt(i - 1) == s2.charAt(j - 1)){
					dp[j] = 1 + diagonal;
				}else{
					dp[j] = Math.max(dp[j-1],dp[j]);
				}
				diagonal = temp;
			}
		}
		return dp[m];
	}

	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String  s1 = br.readLine();
		String s2 = br.readLine();
		System.out.println(lcs_4(s1,s2));

	}
}