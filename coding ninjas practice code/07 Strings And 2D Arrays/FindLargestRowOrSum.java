import java.util.Scanner;
public class FindLargestRowOrSum{
	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int arr[][] = new int[m][n];
		for(int i =0;i<m;i++){
			for(int j =0;j<n;j++){
			    arr[i][j] = s.nextInt();
			}
		}
		findLargest(arr);
	}
	public static void findLargest(int input[][]){
		int maxRow = -1 ,maxRowSum = -1,maxCol = -1,maxColSum = -1;
		// finding maximum row
		for(int i =0;i<input.length;i++){
		   int rowSum = 0;
		   for(int j =0;j<input[0].length;j++)
		   		rowSum += input[i][j];
		   
		   if(rowSum>maxRowSum){
		   		maxRowSum = rowSum;
		   		maxRow = i;
		   }
		}

		//finding max column
		for(int j=0 ; j<input[0].length;j++){
			int colSum =0;
			for(int i=0;i<input.length;i++){
				colSum += input[i][j];
			}
			if(colSum>maxColSum){
				maxColSum = colSum;
				maxCol = j;
			}
		}
		if(maxRowSum>maxColSum)
			System.out.println("row "+maxRow+" "+maxRowSum);
		else
		   System.out.println("column "+maxCol+" "+maxColSum);
	}
}