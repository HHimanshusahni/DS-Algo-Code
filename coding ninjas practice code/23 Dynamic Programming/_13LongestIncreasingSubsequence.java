import java.io.*;
import java.util.*;
public class _13LongestIncreasingSubsequence{
	//Recursive Approach Exponential  time
    static int largest ;
	public static int lis_Rec(int arr[]) {
		largest = 1;
        lis_1(arr,arr.length - 1);
		return largest;
    }
	public static int lis_1(int arr[],int i ){
		//Base Case
		if(i == 0)
			return 1;
		//Recursive Case
		int max = 1,current = 1;
		int j = i - 1;
		while(j >= 0){
			current = lis_1(arr,j);
			if(arr[j] < arr[i]){
				current += 1 ;
			    max = Integer.max(current , max);
            }
            j--;
		}
        if(max > largest)
            largest = max;
		return max;
	}

	//Memoization
	static int dp[] = new int[1001];
	public static int lis_Mem(int arr[]) {
		Arrays.fill(dp,0,arr.length,-1);
	    lis_2(arr,arr.length - 1);
        int max = 1;
        for(int i = 0 ;i < arr.length;i++)
            max = Math.max(dp[i],max);
        return max;
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
			if(arr[j] < arr[i]){   
				current += 1 ;
			    max = Integer.max(current , max);
            }
                j--;
		}
		return dp[i] = max;
	}
	//Bottom Up dp approach O(n^2)
	public static int lis_3(int arr[]){
		int dp[] = new int[arr.length];
		int largest = 1;
		dp[0] = 1;
		for(int i = 1 ;i < dp.length ;i++){
			dp[i] = 1;
			for(int j = i - 1 ;j >= 0 ; j--){
				if(arr[j] < arr[i])
					dp[i] = Math.max(dp[i],dp[j]+1);
			}
			largest = Math.max(largest,dp[i]);
		}
		return largest;
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String strArr[] = br.readLine().split(" ");
		int arr[] = new int[n];
		for(int i = 0 ;i < n ;i++)
			arr[i] = Integer.parseInt(strArr[i]);
		System.out.println(lis_3(arr));
		
	}
}