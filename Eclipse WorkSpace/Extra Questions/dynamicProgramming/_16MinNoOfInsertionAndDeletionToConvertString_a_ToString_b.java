package dynamicProgramming;
import java.io.*;
//https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
//
public class _16MinNoOfInsertionAndDeletionToConvertString_a_ToString_b {
	public static  void minInsertionAndDeletion(String X , String Y, int n,int m ){
		int lcsLength  = getLCSLength(X, Y, n, m);
		int deletions = X.length() - lcsLength;
		int insertions = Y.length() - lcsLength;
		System.out.println(insertions + deletions);
	}
	//Bottom up 1d dp matrix LCS approach
	static int dp[]  = new int[1001];
	public static int getLCSLength(String X, String Y, int n ,int m ){
		for(int j = 0 ; j < m + 1;j++)
			dp[j] = 0 ;
		int diagonal,temp;
		for(int i = 1 ;i < n+1 ;i++){
			diagonal = 0;
			for(int j = 1; j< m+1 ;j++){
				temp = dp[j];
				if(X.charAt(i-1) == Y.charAt(j-1)){
					dp[j] = 1 + diagonal; // match so include it in the answer
				}else{
					dp[j] = Math.max(dp[j], dp[j-1]);
				}
				diagonal = temp;
			}
		}
		return dp[m];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int ti = 0 ;ti < t ;t++){
			String strArr[] = br.readLine().split(" ");
			int n = Integer.parseInt(strArr[0]);
			int m = Integer.parseInt(strArr[1]);
		    strArr = br.readLine().split(" ");
			String X = strArr[0]; 
			String Y = strArr[1];
			minInsertionAndDeletion(X, Y, n, m);
		}

	}
}
