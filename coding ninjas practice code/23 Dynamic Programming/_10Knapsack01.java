import java.io.*;
import java.util.*;
public class _10Knapsack01{
	//Recursive Approach // Time Complexity O( 2^n) as Recurrence is T(n) = 2 T(n-1) + 1
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
	//Memoziation Appraoch
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
		int maxProfit = knapsack_Mem(weight,value, maxWeight, n);
		System.out.println(maxProfit);
	}
}