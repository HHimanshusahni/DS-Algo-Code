import java.io.*;
import java.util.Arrays;
public class _12LootHouses{
	//Recursive  Approach Time Complexity  O(2^n) 
	public static int getMaxMoney(int arr[], int n){
		//Base Case
		if(n == 1)
			return arr[0];
		else if(n < 1)
			return 0;
		//If we include nth element in the answer
		int option1 = arr[n - 1] + getMaxMoney(arr,n-2);
		//We don't include nth element in the answer

		int option2 = getMaxMoney(arr,n-1);
		return Math.max(option1,option2); 
	}

	//Memoization Time Complexity : O(n) Space Complexity : O(n) + stack space
	static int dp[];
	public static int getMaxMoney_2(int arr[],int n){
		dp = new int[n+1];
		Arrays.fill(dp,-1);
		return getMaxMoney_Mem(arr,n);
	}
	public static int getMaxMoney_Mem(int arr[], int n){
		//Base Case
		if(n == 1)
			return arr[0];
		else if(n < 1)
			return 0;
		if(dp[n] != -1)
			return dp[n];
		//If we include nth element in the answer
		int option1 = arr[n - 1] + getMaxMoney_Mem(arr,n-2);
		//We don't include nth element in the answer

		int option2 = getMaxMoney_Mem(arr,n-1);
		return dp[n] = Math.max(option1,option2); 
	}
	//Bottom Up Time Complexity : O(n) Space Complexity : O(n)
	public static int getMaxMoney_bottomUp(int arr[],int n ){
		int dp[] = new int[n];
		dp[0] = arr[0];
        if(n ==1)
            return dp[0];
		dp[1] = Math.max(arr[1],arr[0]);
		for(int j = 2 ;j < n ; j++){
			dp[j] = Math.max(arr[j]+dp[j-2],dp[j-1]);
		}
		return dp[n-1];
	}
	//Bottom Up Time Complexity : O(n) Space Complexity : O(1)
	//At any moment we requrire only the last two values so need to create 1d dp array
	public static int getMaxMoney_bottomUp_SpaceOptimized(int arr[],int n ){
		int t1 = arr[0];
        if(n == 1)
            return t1;
        int temp ;
		int t2 = Math.max(arr[1],arr[0]);
		for(int j = 2 ;j < n ; j++){
			temp = t2;
			t2 = Math.max(arr[j]+t1,t2);
			t1 = temp;
		}
		return t2;
	}


	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String str[] = br.readLine().split(" ");
		for(int i = 0 ;i < n;i++)
			arr[i] = Integer.parseInt(str[i]);
		System.out.println(getMaxMoney_bottomUp_SpaceOptimized(arr,n));
	}

}