package dynamicProgramming;
import java.io.*;
public class _07TargetSum {
	//	https://leetcode.com/problems/target-sum/

	//https://leetcode.com/submissions/detail/329448748/
	public static int findTargetSumWays(int[] nums, int S) {
		return countSubsets(nums, S);
	}
	public static int countSubsets( int arr[],int difference){
		// s1 + s2 = sum
		// s1 - s2 = difference 
		// ==> s1 = (sum + difference) /2

		int sum = 0 ;
		for(int i = 0 ;i < arr.length ;i++){
			sum += arr[i];

		}	
		if(  ( ( sum + difference) %2 != 0) ||sum < difference ) // Most important point
			return 0 ;
		return subsetSumCount(arr, (sum + difference)/2 );
	}

	//Working 2d array solution
	//	private static int subsetSumCount(int arr[],int sum ){
	//		int dp[][] = new int[arr.length + 1][sum + 1];

	//		for(int j = 1 ;j<dp[0].length ;j++)
	//			dp[0][j] = 0 ; // when array size is equal to 0 then the sum == 0
	//      dp[0][0] = 1;
	//      int zeroesTillNow = 0;
	//		for(int i = 1;i< dp.length;i++){
	//          if(arr[i - 1] == 0)
	//              zeroesTillNow++;
	//          dp[i][0] = (int) ( Math.pow(2,zeroesTillNow)) ; 

	//			for(int j = 1; j< dp[0].length;j++){
	//				if(arr[i-1] <= j)//We have 2 choices either  we include or not
	//					dp[i][j] = dp[i - 1][j - arr[i-1]] + dp[i-1][j];
	//				else // We have no choice we can't include
	//					dp[i][j] = dp[i-1][j];
	//			}
	//		}
	//		return dp[arr.length][sum];
	//  }
	private static int subsetSumCount(int arr[],int sum ){
		int dp[] = new int[sum + 1];
		dp[0] = 1;
		int zeroesTillNow = 0;
		for(int i = 1;i< arr.length + 1;i++){
			if(arr[i - 1] == 0)
				zeroesTillNow++; 
			for(int j = sum; j>0;j--){
				if(arr[i-1] <= j)
					dp[j] = dp[j - arr[i-1]] + dp[j];
			}
			dp[0] = (int) ( Math.pow(2,zeroesTillNow)) ; 
		}
		return dp[sum];
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String strArr[] = br.readLine().split(" ");
		for(int i = 0 ;i< n;i++){
			arr[i] = Integer.parseInt(strArr[i]);
		}
		int sum = Integer.parseInt(br.readLine());
		System.out.println(findTargetSumWays(arr,sum));
	} 
}
