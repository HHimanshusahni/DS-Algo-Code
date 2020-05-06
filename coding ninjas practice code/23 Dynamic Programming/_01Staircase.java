import java.io.*;
public class _01Staircase{
	//Memoized Approach
	static long dp[] = new long[71];
	public static long staircase(int n){
		for(int i = 0 ;i < n ;i++)
			dp[i] = 0;
		return staircase_BottomUpOptimized(n); 
	}
	public static long staircase_Mem(int n){
		//Base Case
		if(n == 0 )
			return 0;
		if(n == 1 )
			return 1 ;
		if(n  == 2)
			return 2 ;
		if(n == 3)
			return 4;
		if(dp[n-1] != 0)
			return dp[n-1];
		return dp[n - 1] = staircase_Mem(n - 1 ) + staircase_Mem(n - 2) + staircase_Mem( n - 3);
	}
	 //Bottom Up dp Time Complexity O(n) , Space : O(n)
	public static long staircase_BottomUp(int n ){
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		for(int i = 3 ; i < n ;i++){
			dp[i] = dp[i-1] + dp[i-2]+dp[i-3];
		}
		return dp[n-1];
	}
	 //Bottom Up dp Time Complexity O(n) , Space : O(1)
	public static long staircase_BottomUpOptimized(int n ){
		int dp[] = new int[3];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		for(int i = 3 ; i < n ;i++){
			dp[i] = dp[i-1] + dp[i-2]+dp[i-3];
			dp[0] = dp[1];
			dp[1] = dp[2];
		}
		return dp[n-1];
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(staircase(n));
	}
}