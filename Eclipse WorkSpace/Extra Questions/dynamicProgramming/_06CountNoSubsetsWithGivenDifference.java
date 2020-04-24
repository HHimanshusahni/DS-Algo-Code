package dynamicProgramming;
import java.io.*;
/* We need to divide the array into two subsets such that the difference
 * of the sum is equal to the difference given.
 * We need to return the count of 
 * the total subset pair which follows the given condition.
 * Eg Arr [ 1, 1,2 ,3 ]
 * Subset { 1, 3 } { 1, 2 } , their sum are 4 & 3 so diff = 1
 * Subset { 1, 3 } { 1, 2 } , their sum are 4 & 3 so diff = 1 ( because two 1 are given)
 * Subset { 1 ,  1, 2 } { 3 } their sum are 4 & 3 so diff = 1
Since there are two subsets possible output is 3.

 * */
public class _06CountNoSubsetsWithGivenDifference {
	public static int countSubsets( int arr[],int difference){
		// s1 + s2 = sum
		// s1 - s2 = difference 
		// ==> s1 = (sum + difference) /2
		int sum = 0;
		for(int i = 0 ;i < arr.length ;i++)
			sum += arr[i];
		return subsetSumCount(arr, (sum + difference)/2 );
	}
	private static int subsetSumCount(int arr[],int sum){
		int dp[][] = new int[arr.length + 1][sum + 1];
		for(int i = 0 ;i < dp.length;i++)
			dp[i][0] = 1;// sum = 0 is possible for the empty set {} always
		for(int j = 1 ;j<dp[0].length ;j++)
			dp[0][j] = 0 ; // when array size is equal to 0 then the sum == 0
		for(int i = 1;i< dp.length;i++){
			for(int j = 1; j< dp[0].length;j++){
				if(arr[i-1] <= j)//We have 2 choices either  we include or not
					dp[i][j] = dp[i - 1][j - arr[i-1]] + dp[i-1][j];
				else // We have no choice we can't include
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[arr.length][sum];
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String strArr[] = br.readLine().split(" ");
		for(int i = 0 ;i < n;i++){
			arr[i] = Integer.parseInt(strArr[i]);
		}
		int difference = Integer.parseInt(br.readLine());
		System.out.println(countSubsets(arr, difference));
	}
}
