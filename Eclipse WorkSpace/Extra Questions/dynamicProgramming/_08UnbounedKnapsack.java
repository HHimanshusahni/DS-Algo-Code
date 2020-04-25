package dynamicProgramming;
import java.io.*;
import java.util.Arrays;
//https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
//https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items/0
public class _08UnbounedKnapsack {
	//Bottom up Approach
	public static int maximumProfit(int weight[],int value[],int capacity){
		int dp[][] = new int[weight.length +1][capacity + 1];
		//There is always sum = 0 , for {} 
		for(int i = 0 ;i < dp.length;i++)
			dp[i][0] = 0;
		for(int j = 0 ;j < dp[0].length;j++)
			dp[0][j] = 0;
		for(int i = 1 ; i < dp.length;i++){
			for( int j = 1; j < dp[0].length ;j++){
				if( weight[i-1] <= j )
					dp[i][j] = Math.max(value[i-1]+ dp[i][j- weight[i-1]] , //we include & we include in future
										dp[i-1][j]);  // we exclue
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[weight.length][capacity];
	}
	public static int maximumProfit_Recursive(int weight[],int value[],int capacity){
		return maximumProfit_Recursive(weight,value, capacity, weight.length);
	}
	private static int maximumProfit_Recursive(int weight[], int value[],int capacity,int n){
		//Base Case 
		if(n == 0 ||capacity == 0)//There are no elements in the array or capacity is 0
			return 0;
		if(weight[n-1] <= capacity)
			return Math.max( value[n-1]+ maximumProfit_Recursive(
										weight, value, capacity - weight[n-1], n),//we include & can include in future also                                                                                                                                                            
										maximumProfit_Recursive(
										weight, value, capacity, n-1));// we don't include
		else
			return maximumProfit_Recursive(
				  weight, value, capacity, n-1);//we don't include
	}
	public static int maximumProfit_Memoize(int weight[],int value[],int capacity){
		//dp array is created for the values w/c are changing in recursive  calls
		int dp[][] = new int[weight.length+1][capacity+1];
		for(int i = 0 ;i<dp.length;i++)
			Arrays.fill(dp[i],-1);
		return maximumProfit_Memoize(weight,value, capacity, weight.length,dp);
	}
	public static int maximumProfit_Memoize(int weight[], int value[],int capacity,int n,int dp[][]){
		//Base Case 
		if(n == 0 ||capacity == 0)//There are no elements in the array or capacity is 0
			return 0;
		//Check whether element is already calculate or not
		if(dp[n][capacity] != -1)
			return dp[n][capacity];
		if(weight[n-1] <= capacity)
			return dp[n][capacity] = Math.max( value[n-1]+ maximumProfit_Memoize(
										weight, value, capacity - weight[n-1], n,dp),//we include & can include in future also                                                                                                                                                            
										maximumProfit_Memoize(
										weight, value, capacity, n-1,dp));// we don't include
		else
			return dp[n][capacity]= maximumProfit_Memoize(
				  weight, value, capacity, n-1,dp);//we don't include
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for(int t = 0 ;t < testCases;t++){
			String strArr[] = br.readLine().split(" ");
			int n = Integer.parseInt(strArr[0]);
			int capacity = Integer.parseInt(strArr[1]);
			int weight[] = new int[n] , value[] = new int[n];
			strArr = br.readLine().split(" ");
			for(int i = 0 ;i < n; i++)
				value[i] = Integer.parseInt(strArr[i]);
			 strArr= br.readLine().split(" ");
			for(int i = 0 ;i < n; i++)
				weight[i] = Integer.parseInt(strArr[i]);
			
			
			System.out.println(maximumProfit_Memoize(weight,value,capacity));
		}
		

	}

}
