package dynamicProgramming;
import java.io.*;
import java.util.Arrays;
//https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
//https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication/0
public class _23MatrixChainMultiplication {
	//Recursive Solution
	public static int mcm(int arr[],int i , int j ){
		//Base Case
		if(i >= j ) //When there is 1 element no  need to mutliply
			return 0 ;
		int minAns = Integer.MAX_VALUE;
		for(int  k = i ; k <= j-1 ;k++){
			int tempAns = mcm( arr,i,k)+
						  mcm(arr,k+1,j)+
						  arr[i-1] * arr[k]*arr[j];
			if(tempAns < minAns)
				minAns = tempAns;
		}
		return minAns;
	}
	//Memoization
	static int dp[][] = new int[101][101];
	public static int mcm_mem(int arr[],int i , int j){
		int n = arr.length;
		for(int a = 0 ; a < n;a++)
			Arrays.fill(dp[a],0,n,-1);
		return  mcm_2(arr,i,j);
	}
	public static int mcm_2(int arr[],int i ,int j ){
		//Base Case
		if(i >= j)
			return 0;
		if(dp[i][j] != -1)
			return dp[i][j];
		int tempAns;
		int minAns = Integer.MAX_VALUE;
		for(int k = i ; k <= j-1; k++){
			tempAns = mcm_2(arr , i ,k) +
					  mcm_2(arr,k+1,j) + 
					  arr[i-1] * arr[k] * arr[j];
			if(tempAns < minAns)
				minAns = tempAns;
		}
		return  dp[i][j] = minAns;
	}
	
	//Bottom Up Implementation
	public static int mcm_3(int arr[]){
		int n = arr.length;
		//All 1 size matrices needs no opearations to mutliply 
		for(int i = 0 ;i < n;i++)
			dp[i][i] = 0;
		//The values of i , j , lenght can be derived by making dry run on the dp table
		for(int length = 2 ; length < n;length++){
			for(int i = 1 ;i <= n - length ;i++){
				int j = i + (length - 1);
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = i ;k <= j-1 ;k++){
					dp[i][j] = Math.min(dp[i][j],
										dp[i][k] +dp[k+1][j] + arr[i-1] * arr[k] *arr[j]);
				}
			}
		}
		return dp[1][n-1];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t  = 0 ;t < test ;t++){
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			String strArr[] = br.readLine().split(" ");
			for(int i = 0 ;i < n;i++)
				arr[i] = Integer.parseInt(strArr[i]);
			System.out.println(mcm_3(arr));
		}
	}

}
