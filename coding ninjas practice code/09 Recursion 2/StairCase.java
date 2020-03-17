import java.io.*;
public class StairCase{
	//Recursive approach Recurrence : T(n) = T(n-1) + T(n-2) + T(n-3) Time complexity = T(3^n)
	public static int findWays(int n){
		// Base Case
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(n==3)
			return 4;
		// Recursive Case
		return findWays(n-1) + findWays(n-2) + findWays(n-3);

	}
		// Using Memoization
	public static int findWays_2(int n ){
		int arr[] = new int[n+1]; 
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
	   return findWays_2(n,arr);
	}
	public static int findWays_2(int n ,int arr[]){
		if(arr[n]!=0)
			return arr[n];
		arr[n] =  findWays_2(n-1,arr) + findWays_2(n-2,arr) + findWays_2(n-3,arr);
		return arr[n];
	}
	
	//Dynamic programming O(n) time complexity
	public static int findWays_3(int n){
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(n==3)
			return 4;
		int arr[] = new int[n+1]; 
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i = 4;i<n+1;i++){
			arr[i] = arr[i-1] + arr[i-2]+arr[i-3];
		}
		return arr[n];
	}

	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(findWays_3(n));

	}
}