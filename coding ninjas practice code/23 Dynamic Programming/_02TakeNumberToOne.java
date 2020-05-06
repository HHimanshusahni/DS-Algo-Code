import java.io.*;
public class _02TakeNumberToOne{
	
	/*//Recursive Case Time Complexity ~O( 3^n) or definately exponential	
	public static int countStepsTo1(int n){
		//Base Case 
		if(n == 1) 
			return 0;
		int option1 = 0, option2 = Integer.MAX_VALUE,option3  = Integer.MAX_VALUE;
	    option1 = countStepsTo1(n-1);
		if(n % 2 == 0)
			option2 = countStepsTo1(n/2);
		if(n % 3 == 0 )
			option3 = countStepsTo1(n/3);
		return 1 + Math.min(option1, Math.min(option2,option3));
	}*/

	//Memoization StackOverFlow Exceptinon T : O(n) , S : O(n) + stack space 
	/*static int dp[] = new int[100001];
	public static int countStepsTo1(int n ){
		for(int i = 0 ;i < n; i++)
			dp[i] = -1;
		return countStepsTo1_Mem(n);
	}
	public static int countStepsTo1_Mem(int n){
		//Base Case 
		if(n == 1) 
			return 0;
		if(dp[n-1] != -1)
			return dp[n-1];
		int option1 = 0, option2 = Integer.MAX_VALUE,option3  = Integer.MAX_VALUE;
	    option1 = countStepsTo1_Mem(n-1);
		if(n % 2 == 0)
			option2 = countStepsTo1_Mem(n/2);
		if(n % 3 == 0 )
			option3 = countStepsTo1_Mem(n/3);
		return dp[n-1] = 1 + Math.min(option1, Math.min(option2,option3));
	}*/

	//Bottom Up Dynamic programming approch
	static int dp[] = new int[100001];
	public static int countStepsTo1(int n ){
		dp[1] = 0;
		int option1 , option2 , option3;
		for(int i  = 2 ; i < n  + 1  ;i++){
			option2 = Integer.MAX_VALUE;
			option3 = Integer.MAX_VALUE;
			option1 = dp[i-1];
			if(i % 2 == 0 )
				option2 = dp[i / 2];
			if(i % 3 == 0)
				option3 = dp[i / 3];
			dp[i] = 1 + Math.min(option1, Math.min(option2,option3));
		}

		return dp[n];
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int step  = countStepsTo1(Integer.parseInt(br.readLine()));
		System.out.println(step);
	}
}