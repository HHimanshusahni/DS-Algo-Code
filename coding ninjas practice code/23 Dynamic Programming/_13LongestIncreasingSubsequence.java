import java.io.*;
import java.util.*;
public class _13LongestIncreasingSubsequence{
	//Recursive Approach Exponential  time 
	public static int lis(int arr[]) {
		return lis(arr,arr.length - 1);
	}
	public static int lis(int arr[],int i ){
		//Base Case
		if(i == 0)
			return 1;
		//Recursive Case
		int max = 1,current = 1;
		int j = i - 1;
		while(j >= 0){
			current = lis(arr,j);
			if(arr[j] < arr[i])
				current += 1 ;
			max = Integer.max(current , max);
				j--;
		}
		return max;
	}

	//Memoization
	static int dp[] = new int[1001];
	public static int lis_2(int arr[]) {
		Arrays.fill(dp,0,arr.length,-1);
		return lis_2(arr,arr.length - 1);
	}
	public static int lis_2(int arr[],int i ){
		//Base Case
		if(i == 0)
			return 1;
		if(dp[i] != -1)
			return dp[i];
		//Recursive Case
		int max = 1,current = 1;
		int j = i - 1;
		while(j >= 0){
			current = lis_2(arr,j);
			if(arr[j] < arr[i])
				current += 1 ;
			max = Integer.max(current , max);
				j--;
		}
		return dp[i] = max;
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String strArr[] = br.readLine().split(" ");
		int arr[] = new int[n];
		for(int i = 0 ;i < n ;i++)
			arr[i] = Integer.parseInt(strArr[i]);
		System.out.println(lis_2(arr));
		
	}
}