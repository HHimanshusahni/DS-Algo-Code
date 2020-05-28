import java.util.*;
public class _15WaysToMakeCoinChange{
	// T : O(Exponential)
	public static int countWaysToMakeChange(int denominations[], int value){
		return countWaysToMakeChange(denominations,value,denominations.length - 1);
	}
	//Recusive Approach
	public static int countWaysToMakeChange(int denominations[], int value,int i){
		//Base Case
		if(value == 0)
			return 1;
		if(value < 0 || i < 0)
			return 0;

		//We can include the given denomination and we include it as many times we want
		int option1 = countWaysToMakeChange(denominations,value - denominations[i] , i);

		//We don't include the given denomination 
		int option2 = countWaysToMakeChange(denominations,value,i-1);

		return option1 + option2;

	}

	//Memoization  T : O(n x value) S : O(n x value) + stack space
	static int dp[][] = new int[11][1001]; //global dp array
	public static int countWaysToMakeChange_Mem(int denominations[], int value){
		for(int i = 0;i <= denominations.length;i++)
			for(int j = 0 ;j <= value;j++)
				dp[i][j] = -1;
		return countWaysToMakeChange_Mem(denominations,value,denominations.length - 1);
	}
	public static int countWaysToMakeChange_Mem(int denominations[], int value,int i){
		//Base Case
		if(value == 0)
			return 1;
		if(value < 0 || i < 0)
			return 0;
		if(dp[i][value] != -1)
			return dp[i][value];
		//We can include the given denomination and we include it as many times we want
		int option1 = countWaysToMakeChange_Mem(denominations,value - denominations[i] , i);

		//We don't include the given denomination 
		int option2 = countWaysToMakeChange_Mem(denominations,value,i-1);

		return dp[i][value] = option1 + option2;

	}
	//Bottom Up Dp T : O(n x value) S : O(n x value)
	public static int countWaysToMakeChange_BottomUp(int denominations[], int value){
		// (di , v) = (d,i ,v - di) + (d,i -1 , v)
		int n = denominations.length;
		int dp[][] = new int[n + 1][value + 1];
		for(int i = 0 ;i <= n;i++)
			dp[i][0] = 1;
		for(int i = 1;i <= n;i++){
			for(int j = 1;j <= value;j++){
				//If we include the denomination
				int option1  = 0;
				if(j - denominations[i-1] >= 0) //To prevent index out of bound exception
					option1 = dp[i][j - denominations[i-1]];
				//If we don't include the denomination
				int option2 = dp[i - 1][j];
				dp[i][j] = option1 + option2;
			}
		}
		return dp[n][value];
	}
	//Bottom Up 1d dp solution  T : O(n x value) S : O(value)
	public static int countWaysToMakeChange_BottomUpOptimized(int denominations[],int value){
		int n = denominations.length;
		int dp[] = new int[value + 1];
		dp[0] = 1;
		for(int i = 1;i <= n;i++)
			for(int j = 1;j <= value;j++){
				// we include
				int option1 = 0 ;
				if(j - denominations[i-1] >= 0) 
					option1 = dp[j- denominations[i-1]];
				//we don't include
				int option2 = dp[j];
				dp[j] = option1 + option2;
			}
		return dp[value];
	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int denominations[] = new int[n];
		for(int i = 0 ;i < n;i++)
			denominations[i] = s.nextInt();
		int value = s.nextInt();
		System.out.println(countWaysToMakeChange_BottomUpOptimized(denominations,value));

	}
	
}