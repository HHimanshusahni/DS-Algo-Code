import java.util.*;
public class _15WaysToMakeCoinChange{

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

	//Memoization
	static int dp[][] = new int[11][1001]; //global dp array
	public static int countWaysToMakeChange_Mem(int denominations[], int value){
		for(int i = 0;i <= denominations.length;i++)
			for(int j = 0 ;j <= value;j++)
				dp[i][j] = -1;
		return countWaysToMakeChange_Mem(denominations,value,denominations.length - 1);
	}
	//Recusive Approach
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

	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int denominations[] = new int[n];
		for(int i = 0 ;i < n;i++)
			denominations[i] = s.nextInt();
		int value = s.nextInt();
		System.out.println(countWaysToMakeChange_Mem(denominations,value));

	}
	
}