package dynamicProgramming;
import java.io.*;
//https://leetcode.com/problems/shortest-common-supersequence/
//https://www.youtube.com/watch?v=VDhRg-ZJTuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30
public class _19PrintShortestCommonSuperSequence {
	//This problem is similar to the printing the LCS problem
	public static String shortestCommonSupersequence(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int dp[][] = getLCSTable(str1,str2,n,m);
		String ans = "";
		int i = n , j = m;
		while(i > 0 && j > 0 ){
			if(str1.charAt(i-1) == str2.charAt(j-1)){
				ans = str1.charAt(i-1)+ans;
				i--;
				j--;
			}else{
				if(dp[i-1][j] > dp[i][j-1]){
					ans = str1.charAt(i-1)+ans;//<-- Code addition in the code of the print LCS
					i--;
				}
				else{
					ans = str2.charAt(j-1)+ans;//<-- Code addition in the code of the print LCS
					j--;
				}
			}
		}
		while(i > 0 ){//<-- Code addition in the code of the LCS
			ans = str1.charAt(i-1)+ans;
			i--;
		}
		while( j > 0 ){//<-- Code addition in the code of the LCS
			ans = str2.charAt(j-1)+ans;
			j--;
		}
		
		return ans;
	}
	public static int[ ][ ] getLCSTable(String str1 ,String str2,int n , int m ){
		
		int dp[][] = new int [n+1][m+1];
		//We can intialize the first row and first column with 0 but by default the value are 0
		for (int i = 1  ;i <  n + 1  ;i++){
			for(int j = 1 ;j < m + 1 ;j++){
				if(str1.charAt(i-1) == str2.charAt(j - 1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp;
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		String scs = shortestCommonSupersequence(str1, str2);
		System.out.println(scs);

	}
	

}
