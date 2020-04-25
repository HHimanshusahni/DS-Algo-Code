package dynamicProgramming;
import java.io.*;
//https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
//https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items/0
/* Rod Cutting problem is nothing but Unbounded knapsack
 * but just asked in different way
 */
public class _09RodCuttingProblem {
	//Bottom up 
	public static int maxProfit(int price[],int rodLength){
		int length[] = new int[price.length];
		for(int i = 0 ;i < price.length; i++)
			 length[i] = i+1;
		int dp[][] = new int[price.length+1][rodLength + 1];
//		Not required as by default values are 0
//		for(int i = 0 ;i< dp.length;i++)
//			dp[i][0] = 0;
//		for(int j = 0 ;j<dp[0].length;j++)
//			d[0][j] = 0;
		//i corresponds to the values considered till Now & j corresponds to rodLength
		for(int i = 1 ;i < dp.length ;i++ ){
			for(int j = 1 ;j< dp[0].length;j++){
				if(length[i-1] <= j)
					dp[i][j] = Math.max(price[i-1]+ dp[i][j- length[i-1]],dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[price.length][rodLength];
	}
	//Bottom up 2 without using extra length array
		public static int maxProfit_2(int price[],int rodLength){
			
			int dp[][] = new int[price.length+1][rodLength + 1];
			for(int i = 1 ;i < dp.length ;i++ ){
				for(int j = 1 ;j< dp[0].length;j++){
					if(i <= j)
						dp[i][j] = Math.max(price[i-1]+ dp[i][j- i],dp[i-1][j]);
					else
						dp[i][j] = dp[i-1][j];
				}
			}
			return dp[price.length][rodLength];
		}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt( br.readLine());
		for(int t = 0 ;t < testCases;t++){
			int n = Integer.parseInt(br.readLine());
			int price [] = new int[n];
			String strArr[] = br.readLine().split(" ");
			for(int i = 0 ;i<n;i++)
				price[i] = Integer.parseInt(strArr[i]);
			System.out.println(	maxProfit_2(price,n));
		
		}
	}
}
