package dynamicProgramming;
import java.io.*;
//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem/0
public class _01Knapsack {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int weight[] = new int[n],value[] = new int[n] ;
		int Capacity = Integer.parseInt(br.readLine());
		String strArr[] = br.readLine().split(" ");
		for(int i = 0 ;i<n;i++)
			value[i] = Integer.parseInt( strArr[i]);
		strArr = br.readLine().split(" ");
		for(int i = 0 ;i<n;i++)	
			weight[i] = Integer.parseInt( strArr[i]);
		int maximumProfit  = knapsack_bottomup_2(weight , value, Capacity);
		System.out.print(maximumProfit);
	}
		//The space complexity of the solution can be optimized to O(W)
		//By using matrix of size 2 * length
		public static int knapsack_bottomup(int[] weight, int[] value, int capacity) {
			int n = weight.length;
			int dp[][] = new int[n+1][capacity+1];
			for(int i = 0 ;i < n+1; i++)
				dp[i][0] = 0;
			for(int j = 0 ;j < capacity+1; j++)
				dp[0][j] = 0;
			for(int i = 1;i <  n+1 ; i++){
				for(int j = 1; j < capacity + 1 ;j++){
					
					if(weight [ i - 1 ] <= j){
						dp[i][j] = Math.max( value[i-1]+ dp[i-1][j - weight[i-1]],
											dp[i-1][j]);
					}else{
						dp[i][j] = dp[i - 1][j];
					}
				}
			
			}
			return dp[n][capacity];
			
		}
		

	// 1d array solution //Space Complexity O (W)
	public static int knapsack_bottomup_2(int[] weight, int[] value, int capacity) {
		int dp[] = new int[capacity+1];
		//No need to intialize the row with 0 as already the by defualt values of the dp array is 0
		for(int i = 1;i < weight.length+1 ; i++){
			for(int j = capacity; j >=0 ;j--){
				// reverse array because for filing current value 
				// We need previous left value or current value
				if(weight [ i - 1 ] <= j)
					dp[j] = Math.max( value[i-1]+ dp[j - weight[i-1]], dp[j]);
			}
		}
		return dp[capacity];

	}
}
