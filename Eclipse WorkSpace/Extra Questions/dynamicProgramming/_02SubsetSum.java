package dynamicProgramming;
import java.io.*;
import java.util.*;
public class _02SubsetSum {
//https://www.codechef.com/problems/TF01
// The problem is similar to the 01knapsack problem
	public static boolean subsetSum(int arr[],int sum){
		int n = arr.length;
		boolean dp [][] = new boolean[n + 1][sum +1];
		for(int i = 0 ;i < n + 1 ;i++)
			dp[i][0] = true;
		for(int j = 1 ;j < sum + 1 ;j++)
			dp[0][j] = false;
		for(int i = 1;i<dp.length ;i++){
			for(int j = 1 ;j < dp[0].length;j++){
				if(arr[i - 1] <= j){
					//we have a choice we can include or exclude the element
					dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i - 1][j];
				}
				else{
					dp [i] [j] = dp[i - 1][j];//We have to exclude the elements
				}
			}
		}
		return dp[n][sum];
	}
	public static void main(String[] args) throws IOException{
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for(int t = 0 ;t < testCase;t++){
			int n = s.nextInt();
			int arr[] = new int[n];
			int sum = s.nextInt();
			for(int i = 0;i<n;i++)
				arr[i] = s.nextInt();
			int ans =0 ;
			if(subsetSum(arr,sum))
				ans = 1;
				System.out.println(ans);
		}
		s.close();
	}
}
