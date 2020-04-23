package dynamicProgramming;
import java.io.*;
//https://leetcode.com/problems/partition-equal-subset-sum/
//The problem is similar to the subsetsum problem
public class _03EqualSumPartion {
	public static boolean canPartition(int[] nums) {
		int sum = 0;
		for(int i =  0 ;i<nums.length;i++)
			sum += nums[i];
		//If the sum of the all the element is odd then we can't partition them
		if(sum %2 != 0)
			return false;
		//If the sum of all the element is even then we need to find subset with sum/2
		// is present in the array or  not
		return subsetSum(nums,sum/2);
		
    }
	private static boolean subsetSum(int arr[], int sum){
		boolean dp[][] = new boolean[arr.length +1][sum+1];
		//For sum = 0 there is always a subset that is {} 
		for(int i = 0 ;i < dp.length ; i++)
			dp[i][0] = true;
		//For array size = 0 ,we can't make sum >0
		for(int j = 1 ;j < dp[0].length;j++){ // Note: don't start from j = 0
			dp[0][j] = false;
		}
		for(int i =  1 ;i < dp.length; i++){
			for(int j = 1;j< dp[0].length; j++){
				if(arr[i - 1] <= j){ //We have choice for including or excluding
					dp[i][j] = dp[i-1][j - arr[i-1]]||dp[i-1][j];
				}else
					dp[i][j] = dp[i - 1][j];//We have no choice
			}
		}
		return dp[arr.length][sum];
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String strArr[] = br.readLine().split(" ");
		int nums[] = new int[n];
		for(int i = 0 ;i<n;i++)
			nums[i] = Integer.parseInt(strArr[i]);
		System.out.println(canPartition(nums));
		
	}
}
