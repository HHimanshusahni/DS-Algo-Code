import java.util.Scanner;
public class FindRowSum{
	public static void main(String args[]){
			Scanner s = new Scanner(System.in);
			int m = s.nextInt();
			int n = s.nextInt();
			int arr[][] = new int[m][n];
			for(int i = 0,k = 0;i<m;i++)
				for(int j =0;j<n;j++)
					arr[i][j] = s.nextInt();
			printRowSum(arr);

	}
	public static void printRowSum(int arr[][]){
		for(int i =0;i<arr.length;i++){
		   int rowSum = 0;
		   for(int j =0;j<arr[0].length;j++)
		   		rowSum += arr[i][j];  
		   
		   System.out.print(rowSum+" ");
		}
	}
}