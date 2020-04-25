package dynamicProgramming;
import java.io.*;
//https://practice.geeksforgeeks.org/problems/coin-change/0
/* This problem is variation of the unbounded knapsack problem 
 * This problem is also similar to the problem count the no of subset equal to given sum
 * */
public class _10CoinChange {
	//Bottom up solution using 2d dp matrix
	public static int noOfWaysOfCoinChange(int coins[],int sum){
		int dp[][] = new int[coins.length + 1][sum + 1];
		//There is always 1 way sum = 0 for coins{}
		for(int i = 0 ;i < dp.length ;i++)
			dp[i][0] = 1;
		//Sum > 0 if even one of element is in the coin array
		for(int j = 1 ;j < dp[0].length;j++)
			dp[0][j] = 0;
		
		for(int i = 1 ; i < dp.length;i++){
			for(int j = 1 ;j < dp[0].length;j++){
				if(coins[i-1] <= j)
					//We have two options either we include or we don't include
					dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j ];
				else
					//We have no option as size is greater than capacity
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[coins.length][sum];
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for(int t = 0 ;t < testCases;t++){
			int M = Integer.parseInt(br.readLine());//M: size of array
			int coins[] = new int[M];
			String strArr[] = br.readLine().split(" ");
			for(int i = 0 ;i < M;i++)
				coins[i] = Integer.parseInt(strArr[i]);
			int N = Integer.parseInt(br.readLine());  // N : sum value or value of the cents
			System.out.println(noOfWaysOfCoinChange(coins, N));
		}
	}
}
