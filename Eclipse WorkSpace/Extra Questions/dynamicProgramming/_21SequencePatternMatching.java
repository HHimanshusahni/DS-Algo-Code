package dynamicProgramming;
import java.io.*;
//https://practice.geeksforgeeks.org/problems/check-for-subsequence/0
public class _21SequencePatternMatching {
	//O(n * m) time complexity dp bottom up approach using lcs
	//if the length the lcs of the strings is equal to the smaller string then true otherwise false
	//Space complexity O( n * m)
/*	static int dp[][] = new int[10001][10001];
	public static int checkForSubsequence(String A , String B){
		int n = A.length(), m = B.length();
		for(int i = 0 ;i < n+1 ;i++)
			dp[i][0] = 0 ;
		for(int j = 0 ; j < m+1 ;j++)
			dp[0][j] = 0 ;
		for(int i = 1 ; i < n+1 ;i++){
			for(int j = 1; j < m+1 ;j++){
				if(A.charAt(i-1) == B.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		if(n == dp[n][m])
			return 1 ;
		else
			return 0;
	}*/
	//The above  approach is given memory out of memory error
	
	
	
	/*//1d dp approch O (n) space complexity , Time Complexity O(n^2)
	static int dp[] = new int[10001];
	public static int checkForSubsequence_2(String A , String B){
		int n = A.length();
		int m = B.length();
	
		for(int j = 0 ;j  < m + 1 ;j++)
			dp[j] = 0 ;
		int diagonalElement = 0 , temp = 0 ;
		for(int i = 1 ;i < n+1 ;i++){
		    diagonalElement = 0 ;
			for(int j = 1 ;j < m+1 ;j++){
				temp = dp[j];
				if(A.charAt(i-1) == B.charAt(j-1)){
					dp[j] = 1 + diagonalElement;
				}else{
					dp[j] = Math.max(dp[j],dp[j-1]);
				}
				diagonalElement = temp;
			}
		}
		if(n == dp[m])
			return 1 ;
		else
			return 0;
		
	}
	//The above approach is giving TLE error
*/	
	
	//Appraoch t : O(B.length) S: O(1) 
	public static int checkForSubsequence_3(String A , String B){
		int i = 0 , j = 0 ;
		while(i < A.length() && j < B.length()){
			if(A.charAt(i) == B.charAt(j)){
				i++;
				j++;
			}
			else{
				j++;
			}
		}
		if(i == A.length())
			return 1;
		else
			return 0;
	}
	
	
	
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < testCase ;t++){
			String arr[] = br.readLine().split(" ");
			System.out.println(checkForSubsequence_3(arr[0],arr[1]));
		}
	}
}
