package dynamicProgramming;
import java.io.*;
import java.util.Arrays;
//https://leetcode.com/problems/coin-change/submissions/
//https://leetcode.com/problems/coin-change/submissions/
//2d array solution
public class _11CoinChange_MinCoins {
	//2d matrix approach Space complexity: O ( n x v) : n = no of coins & v = value
	public static int minCoins(int coins[],int value){
		int dp[][] = new int[coins.length + 1][value + 1];
		//For making the sum of 0 we don't want any coins
		for(int i = 1 ; i < dp.length ;i++)
			dp[i][0] = 0;
		//		for(int j = 1 ; j< dp[0].length;j++)
		//			dp[0][j] = Integer.MAX_VALUE;
		for(int j = 1 ; j < dp[0].length ;j++){
			if(j % coins[0] == 0)
				dp[1][j] = j/coins[0];
			else
				dp[1][j] = Integer.MAX_VALUE;
		}
		for(int i = 2 ; i< dp.length;i++){

			for(int j = 1 ;j < dp[0].length;j++){
				if(coins[i - 1] <= j){
					//We have two choice either  we include or we don't include
					dp[i][j] = Math.min(1+ dp[i][j - coins[i-1]],dp[i - 1][j]);
				}else{
					//we have no choice we can't include
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		int x = dp[coins.length][value];
		if( x != Integer.MAX_VALUE)
			return x  ; 
		else
			return -1 ;
	}
	//1d dp array solution , Space Complexity : O ( value)
	public static int minCoins_2(int coins[],int value){
		int dp[] = new int[value + 1];
		for(int j = 1 ;j < dp.length;j++ )
			if(j%coins[0] == 0)
				dp[j] = j/coins[0];
			else
				dp[j] = Integer.MAX_VALUE - 1;
		for(int i = 2 ; i < coins.length + 1 ;i++){
			for(int j = 1 ;j < dp.length;j++)
				if(coins[i-1] <= j)
					dp[j] = Math.min(1 + dp[j-coins[i-1]],dp[j]);
		}
		if(dp[value] == Integer.MAX_VALUE -1)
			return -1 ;
		return dp[value];
	}
	//Memoization appraoch
	public static int minCoins_3(int coins[],int value){
		int dp[][] = new int[coins.length+1][value+1];
		for(int i = 0 ; i< dp.length;i++)
			Arrays.fill(dp[i], -1);
		int x = minCoins_Memoize(coins, value, coins.length,dp);
		if( x == Integer.MAX_VALUE - 1)
			return -1;
		else
			return x;
	}
	private static int minCoins_Memoize(int coins[],int value,int n,int dp[][]){
		if(value == 0){
			return dp[n][value] = 0;
		}
		if(n == 1  ){
			if(value % coins[0] == 0){
				return dp[n][value] = value/coins[0];
			}
			else{
				return dp[n][value] = Integer.MAX_VALUE -1;
			}
		}
		
			
		//Base Case
		if(dp[n][value] != -1)
			return dp[n][value];
		if(coins[n-1] <= value)
			return dp[n][value] = Math.min(1+minCoins_Memoize(coins,value - coins[n-1],n,dp),
													minCoins_Memoize(coins,value ,n-1,dp));
		else
			return dp[n][value] = minCoins_Memoize(coins,value ,n-1,dp);
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for(int t = 0 ;t< testCases;t++){
			String strArr[] = br.readLine().split(" ");
			int V = Integer.parseInt(strArr[0]);
			int N = Integer.parseInt(strArr[1]);
			int coins[] = new int[N];
			strArr = br.readLine().split(" ");
			for(int i = 0 ;i< N;i++)
				coins[i] = Integer.parseInt(strArr[i]);
			System.out.println(minCoins_3(coins,V));
		}

	}

}
