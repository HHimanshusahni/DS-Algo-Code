package dynamicProgramming;
import java.io.*;
public class _04CountOfSubsetSum {
//The problem is similar to the subset sum problem
//	https://practice.geeksforgeeks.org/problems/perfect-sum-problem/0
	public static int countSubsetSum(int arr[],int sum){
		int dp [][] = new int[arr.length +1][sum + 1];
		//For the sum = 0 there always exist only one subset { }
		for(int i = 0 ;i< dp.length;i++)
			dp[i][0] = 1;
		//When no elements are present the subset with sum > 0 is not possible
		for(int j = 1 ;j< dp[0].length;j++)
			dp[0][j] = 0;
		
		for(int i = 1 ;i < dp.length;i++){
			for(int j = 1; j< dp[0].length;j++){
				if(arr[i-1] <= j)//Now we have two choices either we include or not
					dp[i][j] =  dp[i-1][j - arr[i-1]] + dp[i-1][j];
				else // We have only choice of not including
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[arr.length][sum];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for(int t = 0 ;t < testCases; t++){
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			String[] strArr = br.readLine().split(" ");
			for(int i = 0 ;i<n;i++)
				arr[i] = Integer.parseInt(strArr[i]);
			int sum = Integer.parseInt(br.readLine());
			System.out.println(countSubsetSum(arr,sum));

		}
	}

}
