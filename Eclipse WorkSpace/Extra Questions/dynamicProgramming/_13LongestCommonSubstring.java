package dynamicProgramming;
import java.io.*;
import java.util.Arrays;

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
	//1d matrix solution
	static int dp_1d[] = new int[101];
	public static int LCSubstring_2(String x, String y, int n, int m) {
		Arrays.fill(dp_1d, 0,m+1,0);
		int max = 0;
		int previous ,temp; 
		for(int i = 1 ;i < n+1 ;i++){
			previous = 0;
			for(int j = 1 ;j < m+1 ;j++){
				temp = dp_1d[j];
				if(x.charAt(i-1)==y.charAt(j-1)){
					dp_1d[j] = 1 + previous;
				}else
					dp_1d[j] = 0;
				if(dp_1d[j] > max)
					max = dp_1d[j];
				previous = temp;
			}
		}
		return max;
	}
	//Recursion
	public static int LCSubstring_3(String x, String y, int n, int m) {
	    return LCSubstring_3(x,y,n,m,0);	    
	}
	public static int LCSubstring_3(String x, String y, int n ,int m , int count) {
	    if(n == 0 ||m == 0)
	        return count;
	    if(x.charAt(n-1) == y.charAt(m-1))
	        count =  LCSubstring_3(x,y,n - 1,m - 1,count + 1);
	    
	        count = Math.max(count,
	                         Math.max(LCSubstring_3(x,y,n-1,m,0), LCSubstring_3(x,y,n,m-1,0))
	                        );
	        return count;    
	}
	//Memoized
	static int dp_Mem[][][] = new int[101][101][101];
	public static int LCSubstring_4(String x, String y, int n, int m) {
		//since there are three variables which are changing during recursion
		int countLength = Integer.max(n,m)+1;
		for(int i = 0 ;i < n+1;i++)
			for(int  j = 0 ;j < m+1 ;j++)
				Arrays.fill(dp_Mem[i][j],0 ,countLength,-1);
	
		int ans = LCSubstring_Mem(x, y, n, m, 0);
		for(int i = 0 ;i < n+1;i++)
			for(int  j = 0 ;j < m+1 ;j++){
				System.out.println("");
				for(int k = 0 ;k< countLength;k++){
					System.out.print(dp_Mem[i][j][k]+" ");
				}
			}
		return ans;
	}
	public static int LCSubstring_Mem(String x, String y, int n, int m,int count) {
		  if(n == 0 || m == 0)
		        return count;
		  if(dp_Mem[n][m][count] != -1)
			  return dp_Mem[n][m][count];
		  		
		    if(x.charAt(n-1) == y.charAt(m-1))
		        count =  LCSubstring_Mem(x,y,n - 1,m - 1,count + 1);
		    
		        count = Math.max(count,
		                         Math.max(LCSubstring_Mem(x,y,n-1,m,0), LCSubstring_Mem(x,y,n,m-1,0))
		                        );
		        return dp_Mem[n][m][count]= count; 
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
			System.out.println(LCSubstring_4(X,Y,n,m));
		}

	}

	
	
}
