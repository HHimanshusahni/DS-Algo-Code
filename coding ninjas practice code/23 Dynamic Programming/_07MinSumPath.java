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
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int input[][]  = new int[m][n];
		for(int i = 0 ;i < m ;i++){
			for(int j = 0 ;j < n ;j++)
				input[i][j] = s.nextInt();
		}
		System.out.println(minCostPath(input));
	}
}