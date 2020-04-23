package dynamicProgramming;
import java.io.*;
import java.util.*;
//https://practice.geeksforgeeks.org/problems/minimum-sum-partition/0
//The problem is similar to the subset sum problem
public class _05MinimumSubsetSumDifference {
	public static int minimumSubsetDifference(int arr[]){
		int totalSum  =  0 ;
		/*We need to minimize the absolute ( s1 - s2 ) where s1 and s2 
		 Minimize |s1 - s2| == Minimize | s2 - s1|
		 Also s1 + s2 = totalSum
		 ==> Minimize |totalSum - 2 x s1| 
		  s1 are the possible values of the  sum which it lesser than totalSum/2
		  
		*/
		for(int i = 0 ;i< arr.length;i++)
			totalSum += arr[i];
		//Now we are taking values of s1 such that s1 = totalSum/2
		ArrayList<Integer> s1PossibleValues = subsetSum(arr,totalSum);
		
		//Minimize
		int min = Integer.MAX_VALUE;
		for(int i : s1PossibleValues){
			min = Math.min(min,totalSum - (2 * i));
			
		}
		return min;
	}
	
	private static ArrayList<Integer> subsetSum(int arr[], int sum) {
		ArrayList <Integer> s1PossibleValue = new ArrayList<>();
		boolean dp[][] = new boolean[arr.length +1][sum +1];
		for(int i = 0 ;i < dp.length; i++)// Because empty {} with sum =  0 is always possible
			dp[i][0] = true ; 
		for(int j = 1 ;j < dp[0].length;j++)//With empty set always sum == 0 
			dp[0][j] = false; 
		
		for(int i = 1 ; i < dp.length ;i++){
			for(int j = 1 ; j < dp[0].length ;j++){
				if(arr[i-1] <= j)
					dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		for(int j = 0 ;j <  (dp[0].length+1)/2;j++){//If we don't include +1 then we will miss the middle value in the even totalSum
			if(dp[arr.length][j]){
				s1PossibleValue.add(j);
			}
		}
		return s1PossibleValue;
	}
	public static void main(String[]args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for(int t = 0 ;t < testCases;t++){
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			String[] strArr = br.readLine().split(" ");
			for(int i = 0  ;i < n;i++)
				arr[i] = Integer.parseInt(strArr[i]);
			System.out.println(minimumSubsetDifference(arr));
		}
				
	}
}
