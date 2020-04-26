package dynamicProgramming;
import java.io.*;
//https://leetcode.com/problems/coin-change/submissions/
//https://leetcode.com/problems/coin-change/submissions/
//2d array solution
public class _11CoinChange_MinCoins {
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
			System.out.println(minCoins(coins,V));
		}

	}

}
