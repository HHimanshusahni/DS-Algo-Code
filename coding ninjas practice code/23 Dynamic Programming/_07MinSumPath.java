import java.util.Scanner;
public class _07MinSumPath{
	public static int minCostPath(int input[][]) {
		return  minCostPath(input,0,0);
	}

	//Recursive appraoch Time Complexity : O(3 ^n)  ~ exponential 
	public static int minCostPath(int input[][],int i , int j ){
		//Base Case
		if(i == input.length - 1 && j == input[0].length - 1)
			return input[i][j];
		if(i == input.length - 1)
			return input[i][j] + minCostPath(input , i , j + 1 );
		if(j == input[0].length -1 )
			return input[i][j] + minCostPath(input,i + 1, j);

		//Recursive Case
		int option1 = minCostPath(input , i , j + 1 );
		int option2 = minCostPath(input,i + 1, j);
		int option3 = minCostPath(input,i + 1, j + 1 );
		return input[i][j] + Math.min(option1 , Math.min(option2,option3));

	}
	//Memoization approach T : O(input size)  S : (input.size) + stack size
	private static int dp[][] = new int[101][101];
	public static int minCostPath_2(int input[][]){
		for(int i = 0 ;i < input.length;i++){
			for(int j = 0 ;j < input[0].length;j++){
				dp[i][j] = -1;
			}
		}
		return minCostPath_Mem(input,0,0);
	}
	private static int minCostPath_Mem(int input[][],int  i , int j  ){
		//Base Case
		if(i == input.length - 1 && j == input[0].length - 1)
			return input[i][j];

		if(dp[i][j] != -1)
			return dp[i][j];
		if(i == input.length - 1)
			return input[i][j] + minCostPath_Mem(input , i , j + 1 );
		if(j == input[0].length -1 )
			return input[i][j] + minCostPath_Mem(input,i + 1, j);

		//Recursive Case
		int option1 = minCostPath_Mem(input , i , j + 1 );
		int option2 = minCostPath_Mem(input,i + 1, j);
		int option3 = minCostPath_Mem(input,i + 1, j + 1 );
		return dp[i][j] =  input[i][j] + Math.min(option1 , Math.min(option2,option3));
	}
	//Bottom Up Approch  T : O(input size)  S : (input.size) 
	public static int minCostPath_3(int input[][]){
		 
		int dp[][] = new int[input.length][input[0].length];
		for(int i = input.length - 1; i >= 0; i--){
			for(int j = input[0].length - 1 ;j >= 0 ; j--){
				dp[i][j] = input[i][j];
				if(i == input.length - 1 && j != input[0].length - 1)//last row only option is right value
					dp[i][j] += dp[i][j+1];
				else if(i != input.length - 1 &&  j == input[0].length - 1) //last column only option is below value
					dp[i][j] += dp[i+1][j];
				else if(i != input.length - 1 && j != input[0].length - 1 )
					dp[i][j] += Math.min(dp[i+1][j+1],Math.min(dp[i+1][j],dp[i][j+1]));
			}
		}  
		return dp[0][0];
	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int input[][]  = new int[m][n];
		for(int i = 0 ;i < m ;i++){
			for(int j = 0 ;j < n ;j++)
				input[i][j] = s.nextInt();
		}
		System.out.println(minCostPath_3(input));
	}
}