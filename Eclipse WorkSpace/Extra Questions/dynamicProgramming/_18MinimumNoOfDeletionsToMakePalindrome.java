package dynamicProgramming;
import java.io.*;
//https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions/0
public class _18MinimumNoOfDeletionsToMakePalindrome {
/*	The deletions are minimum when the string is longest palindromic subsequence
	So inorder to find the minimum deltions = String length -longest palindromic subsequence
	longest palindromic subsequence is the having length equal to lcs of  String s & reverse of it
	*/
	public static int minimumDeletions(String s , int n){
		StringBuilder sb = new StringBuilder(s);
		String reverseOfs  = sb.reverse().toString();
	
		return n - lcs(s,reverseOfs,n,n);
	}
	//Bottom up 1d dp array solution
	static int dp[]  = new int[1001];
	public static int lcs(String X , String Y , int n , int m){
		//Intilization
		for(int j = 0 ;j < m + 1 ;j++)
			dp[j] = 0;
		int diagonal ,temp;
		for(int i = 1 ;i < n + 1 ;i++){
			diagonal = 0 ;
			for(int j = 1 ; j < m+1 ;j++ ){
				temp = dp[j];
				if(X.charAt(i-1) == Y.charAt(j - 1))
					dp[j] = 1 + diagonal;
				else
					dp[j] = Math.max(dp[j],dp[j-1]);
				diagonal = temp;
			}
		}
		return dp[m];
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		int n;
		String s;
		for(int t = 0 ;t < testCase ;t++){
			n = Integer.parseInt(br.readLine());
			s = br.readLine();
			System.out.println(minimumDeletions(s,n));
		}
		
	}
}
