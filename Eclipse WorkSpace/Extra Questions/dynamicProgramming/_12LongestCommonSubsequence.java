package dynamicProgramming;
import java.io.*;
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
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < testCases;t++){
			String strArr[] = br.readLine().split(" ");
			int n = Integer.parseInt(strArr[0]);
			int m = Integer.parseInt(strArr[1]);
			String X = br.readLine();
			String Y = br.readLine(); 
			System.out.println(LCS(X,Y,n,m));
		}
	
	}

}
