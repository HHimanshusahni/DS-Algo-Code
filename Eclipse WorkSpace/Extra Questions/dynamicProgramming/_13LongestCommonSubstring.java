package dynamicProgramming;
import java.io.*;

public class _13LongestCommonSubstring {
//We need to print the length of the longest common substring 
//https://practice.geeksforgeeks.org/problems/longest-common-substring/0
	//Bottom appraoch
	static int  dp[][] = new int[101][101];
	public static int LCSubstring(String x, String y, int n, int m) {
		for(int i = 0 ;i < n + 1;i++)
			dp[i][0] = 0 ;
		for(int j = 0 ;j< m +1;j++)
			dp[0][j]= 0;
		int max = 0;
		for(int i = 1 ;i < n+1 ;i++){
			for(int j = 1 ;j < m+1; j++){
				if(x.charAt(i-1)== y.charAt(j-1)){
					dp[i][j] = 1+dp[i-1][j-1];
				}else{
					dp[i][j] = 0;
				}
				if(max < dp[i][j])
					max = dp[i][j];
			}
		}
		return max;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < testCases;t++){
			String strArr[] = br.readLine().split(" ");
			int n = Integer.parseInt(strArr[0]);
			int m = Integer.parseInt(strArr[1]);
			String X = br.readLine();
			String Y = br.readLine(); 
			System.out.println(LCSubstring(X,Y,n,m));
		}

	}

	
	
}
