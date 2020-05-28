import java.util.Scanner;
import java.util.Arrays;
public class _16MatrixChainMultiplication{
	//Recursive Approach T: Exponential
	public static int mcm(int[] p){
		return mcm(p,1,p.length - 1);
	}
	public static int mcm(int[]p , int i , int j){
		//Base Case
		if(i >= j)
			return 0;
		int ans = Integer.MAX_VALUE,tempAns;
		for(int k = i ;k <= j - 1 ;k++ ){
			tempAns = mcm(p,i,k)+mcm(p,k + 1,j) + p[i-1] * p[k] * p[j];
			ans = Math.min(ans ,tempAns);
		}
		return ans;
	}
	//Memoization
	static int dp[][] = new int[101][101];
	public static int mcm_Mem(int[] p){

		for(int i = 0 ;i < p.length ;i++){
			Arrays.fill(dp[i],0,p.length,-1);
		}
		return mcm_2(p,1,p.length - 1);
	}
	public static int mcm_2(int[]p , int i , int j){
		//Base Case
		if(i >= j)
			return 0;
		if(dp[i][j] != -1)
			return dp[i][j];
		int ans = Integer.MAX_VALUE,tempAns;
		for(int k = i ;k <= j - 1 ;k++ ){
			tempAns = mcm_2(p,i,k)+mcm_2(p,k + 1,j) + p[i-1] * p[k] * p[j];
			ans = Math.min(ans ,tempAns);
		}
		return dp[i][j] = ans;
	}
	//Bottom Up
	public static int mcm_BottomUP(int []p){
		int n = p.length;
		int dp[][] = new int[n][n];
		for(int i = 0 ;i < n;i++)
			dp[i][i] = 0;
		for(int l = 2;l < n;l++){
			for(int i = 1;i <= n - l   ;i++){
				int j = i + l -1;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = i ;k < j;k++){
					int tempAns = dp[i][k] +dp[k + 1][j] + p[i-1] * p[k] * p[j];
					dp[i][j] = Math.min(dp[i][j],tempAns);
				}
			}
		}
		return dp[1][n-1];
	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n + 1];
		for(int i = 0 ;i <= n;i++){
			arr[i] = s.nextInt();
		}
		System.out.println(mcm_BottomUP(arr));
	}
}