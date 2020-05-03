package dynamicProgramming;
import java.io.*;
//https://practice.geeksforgeeks.org/problems/shortest-common-supersequence/0
//https://www.geeksforgeeks.org/shortest-common-supersequence/

/*Length of the shortest supersequence  = 
 (Sum of lengths of given two strings) -(Length of LCS of two given strings)
*/public class _15LengthOfShortestCommonSuperSequence {
	public static int lengthOfShortestCommonSuperSequence(String X, String Y){
		int n = X.length();
		int m = Y.length();
		return  m + n - lcs(X,Y,n,m);
	}
	//Bottom LCS approach 1d array
	static int dp[] = new int[101];
	public static int lcs(String X, String Y,int n ,int m){
		for(int j = 0 ;j < m + 1;j++)
			dp[j] = 0;
		int diagonal = 0,temp;
		for(int i = 1 ; i < n + 1 ;i++){
			diagonal = 0;
			for(int j = 1; j < m + 1 ;j++){
				temp = dp[j];
				if(X.charAt(i - 1) == Y.charAt(j - 1))
					dp[j] = 1 + diagonal;
				else
					dp[j] = Math.max(dp[j],dp[j-1]);
				diagonal = temp;
			}
		}
		return dp[m];
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String strArr[] = new String[2];
		for(int t_i = 0 ;t_i < t; t_i++){
			strArr = br.readLine().split(" ");
			String X = strArr[0];
			String Y = strArr[1];
			System.out.println(lengthOfShortestCommonSuperSequence(X,Y));
		}
	}
}
