import java.io.*;
import java.util.*;
public class _10Knapsack01{
	//Recursive Approach // Time Complexity O( 2^n) as Recurrence is T(n) = 2 T(n-1) + 1 & Space Complexit: O(n) for recursive stack
	public static int knapsack(int[] weight,int value[],int maxWeight, int n){
		//Base Case
		if(maxWeight == 0 || n == 0 ) {
			return 0; //As there are no elements max Profit is 0
		}
		//Small Calculation and Recursive Case
		if(weight [n-1] <= maxWeight){
			//Either we can include it in the answer
			int choice1 = value [n-1]+knapsack(weight,value,maxWeight - weight[n-1],n-1);
			//Or we don't  include it in the answer
			int choice2 = knapsack(weight,value,maxWeight,n-1);

			return Math.max(choice1,choice2);
		}else{
			return  knapsack(weight,value,maxWeight,n-1);
		}
	}
	//Memoziation Appraoch Top Down A //Time Complexity : O(n * W) ,also O(w) extra space for recursive stack
	static int dp[][] = new int[101][101]; // <-- extra line in recursive code
	public static int knapsack_Mem(int[] weight,int value[],int maxWeight, int n){
		//Base Case
		if(maxWeight == 0 || n == 0)
			return 0;
		//Check the value is already present in the array
		if(dp[maxWeight][n] != -1)//   <-- extra line in recursive code 
			return dp[maxWeight][n]; //<--extra line in recursive code
		
		if( weight[n -1] <= maxWeight){
			//We include the value in the answer
			int choice1 = value[n-1] + knapsack_Mem(weight,value, maxWeight - weight[n-1],n-1);
			//We don't include it in the answer
			int choice2 = knapsack_Mem(weight,value, maxWeight ,n-1);		
			return dp[maxWeight][n] = Math.max(choice1,choice2);	//<--extra line in recursive code	
		}else
			return  dp[maxWeight][n] = knapsack_Mem(weight,value, maxWeight ,n-1);   //<--extra line in recursive code
		
		
	}

	// Tabulization bottom up dp Time Complexity : O(n x W) , Space Complexity: O( n x W) 
	public static int knapsack_tab(int []weight, int value[] , int maxWeight,int n ){
		for(int i = 0 ;i <= maxWeight ;i++)
			dp[i][0] = 0;
		
		for(int j = 0;j <= n; j++)
			dp[0][j] = 0;
		
		for(int i = 1;i<= maxWeight ;i++){
			for(int j = 1;j <= n; j++){
				if(weight[j-1] <= i){
					dp[i][j] = Math.max( (value[j - 1] + dp[ i - weight[j-1] ][j - 1] ),
										 dp[i][j-1]);	
				}else
					dp[i][j] = dp[i][j-1];

			}
		}
		return dp[maxWeight][n];
	}
	//Space Optimization on the tabulized method Space Complexit O( W)
	//https://www.geeksforgeeks.org/space-optimized-dp-solution-0-1-knapsack-problem/
	public static int knapsack_tab_Optimized(int [] weight ,int value [], int maxWeight , int n ){	
    	
        int dp  [][] = new int [2][maxWeight+1];
    	for(int i = 1; i <= n ;i++){
    		//i is odd
    		if( i % 2 != 0 ){
    			for(int j = 1 ; j <= maxWeight ; j++){
    				if(weight [i -1] <= j){
    					dp[1][j] = Math.max(value [i-1] + dp[0][j - weight [ i -1]] , dp [0][j]);
    				}else
    					dp [1][j] = dp [0][j];
    				
    			}
    		}else{ // i is even
    			for(int j = 1 ; j <= maxWeight ; j++){
    				if(weight [i -1] <= j){
    					dp[0][j] = Math.max(value [i-1] + dp[1][j - weight [ i -1]] , dp [1][j]);
    				}else
    					dp [0][j] = dp [1][j];
    				
    			}
    		}
    	}
    	if(n %2 != 0) // knapsack is having the odd size
    		return dp [1][maxWeight];
    	else
    		return dp [0][maxWeight]; 
    	
    	
	}

// 1d array solution space complexity O(W)
   public static int knapsack(int []weight, int value[] , int maxWeight){
	   int dp[] = new int[maxWeight+1];
	    //No need to intialize the row with 0 as already the by defualt values of the dp array is 0
		for(int i = 1;i < weight.length+1 ; i++){
			for(int j = maxWeight; j >=0 ;j--){ // reverse array because for filing current value 
												// We need previous left value or current value
				if(weight [ i - 1 ] <= j)
					dp[j] = Math.max( value[i-1]+ dp[j - weight[i-1]], dp[j]);
			}
		}
		return dp[maxWeight]; 
    }
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int weight[] = new int[n]; 
		int value[] = new int[n];
		String strArr[] = br.readLine().split(" ");
		for(int i = 0 ;i<n;i++){
			weight[i] = Integer.parseInt(strArr[i]);
		}
		strArr = br.readLine().split(" ");
		for(int i = 0 ;i<n;i++){
			value[i] = Integer.parseInt(strArr[i]);
		}
		int maxWeight = Integer.parseInt(br.readLine());

		for (int[] row : dp) //<--extra line in recursive code
       	 	Arrays.fill(row,-1);//<--extra line in recursive code	
		int maxProfit = knapsack(weight,value, maxWeight, n);
		System.out.println(maxProfit);
	}
}