import java.io.*;
public class _08MaximumSquareSubMatrixOfAll0s{
	//Brute Fore solution say n ~= m = n
	//If we are looking for n ^ 2 cells as starting point each cell will have n lengths and again
	//for checking each cell again we need to do n^2 work to ==> n^2 x n x n^2 = O(n^5)
	
	//Bottom up Dp approach O(n^3),Space Complexity:(n^2) { let n = m } 
	public static int findMaxSquareWithAllZeros_bottomUp(int[][] input){
		int n = input.length;
		int m = input[0].length;
		int dp[][] = new int[n][m];
		int max = 0 ;
		//For the first row the maximum length possible of largest square is  1 that is possible if cell itself is 0;
		for(int j = 0;j < m ;j++){
			dp[0][j] = (input[0][j] == 0 ) ? 1 : 0;
			max  = Math.max(max,dp[0][j]);
		}
		//Similarly for the first column 
		for(int i = 0 ;i < n ;i++){
			dp[i][0] = (input[i][0] == 0) ? 1 : 0;
			max  = Math.max(max,dp[i][0]);
		}
		for(int i = 1 ;i < n;i++){
			for(int j = 1 ;j < m ;j++){
				if(input[i][j] == 1)
					dp[i][j] = 0;
				else{
					int leftLength  = 0 ; 
					int aboveLength = 0 ;
					int y = j - 1;
					while(y >= 0 && input[i][y] == 0){
						leftLength++;
						y--;
					}
					int x = i - 1;
					while(x >= 0  && input[x][j] == 0){
						aboveLength++;
						x--;
					}
					dp[i][j] = 1 + Math.min(dp[i - 1][j-1],Math.min(leftLength,aboveLength));
				}
				max  = Math.max(max,dp[i][j]);
			}
		}
		return max;

	}
	//Bottom up Dp approach O(n^2) Space Complexity : O(n^2) { let n = m }
	//We need not calculate the above length and left length as it is already calculated by dp table
	//and is automatically equal to above cell value and left cell value
	public static int findMaxSquareWithAllZeros_bottomUpOptimized(int[][] input){
		int n = input.length;
		int m = input[0].length;
		int dp[][] = new int[n][m];
		int max = 0 ;
		//For the first row the maximum length possible of largest square is  1 that is possible if cell itself is 0;
		for(int j = 0;j < m ;j++){
			dp[0][j] = (input[0][j] == 0 ) ? 1 : 0;
			max  = Math.max(max,dp[0][j]);
		}
		//Similarly for the first column 
		for(int i = 0 ;i < n ;i++){
			dp[i][0] = (input[i][0] == 0) ? 1 : 0;
			max  = Math.max(max,dp[i][0]);
		}
		for(int i = 1 ;i < n;i++){
			for(int j = 1 ;j < m ;j++){
				if(input[i][j] == 1)
					dp[i][j] = 0;
				else
					dp[i][j] = 1 + Math.min(dp[i - 1][j-1],Math.min(dp[i - 1][j],dp[i][j - 1]));
				max  = Math.max(max,dp[i][j]);
			}
		}
		return max;

	}
	//Bottom up Dp approach by using 1d dp array O(n^2) Space Complexity : O(m) { let n = m }
	public static int findMaxSquareWithAllZeros_bottomUpFurtherOptimized(int[][] input){
		int n = input.length;
		int m = input[0].length;
		int dp[] = new int[m];
		int max = 0 ;
		//For the first row the maximum length possible of largest square is  1 that is possible if cell itself is 0;
		for(int j = 0;j < m ;j++){
			dp[j] = (input[0][j] == 0 ) ? 1 : 0;
			max  = Math.max(max,dp[j]);
		}
		int diagonal ; //referring i - 1 , j -1 th cell
		int temp;
		for(int i = 1 ;i < n;i++){
			diagonal = dp[0];
			dp[0] = (input[i][0] == 0) ? 1 : 0;
			max  = Math.max(max,dp[0]); // considering first column only
			for(int j = 1 ;j < m ;j++){
				temp = dp[j];
				if(input[i][j] == 1)
					dp[j] = 0;
				else
					dp[j] = 1 + Math.min(diagonal,Math.min(dp[j],dp[j - 1]));
				max  = Math.max(max,dp[j]);
				diagonal = temp;
			}
		}
		return max;

	}

	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int input[][] = new int[n][m];
		for(int i = 0 ;i < n;i++){
			str = br.readLine().split(" ");
			for(int j = 0 ;j < m;j++){
				input[i][j] = Integer.parseInt(str[j]);
			}
		}
		System.out.println(findMaxSquareWithAllZeros_bottomUpFurtherOptimized(input));
			
	}
}