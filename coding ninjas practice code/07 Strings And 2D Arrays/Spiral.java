import java.util.Scanner;
public class Spiral{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int arr[][] = new int[m][n];
		for(int i =0;i<m;i++)
			for(int j =0;j<n;j++)
				arr[i][j] = s.nextInt();
		printSpiral(arr);
	}
	public static void printSpiral(int matrix[][]){
		int n = matrix.length;
		int m = matrix[0].length;
		int rs = 0 ,cs = 0,re = n-1,ce = m-1;
		int i,j;
		int counter = 1;
		while(counter<=m*n){
			for(j = cs;j<=ce;j++){
				System.out.print(matrix[rs][j]);
				counter++;
			}
			rs++;
			for(i = rs;i<=re;i++){
				System.out.print(matrix[i][ce]);
				counter++;
			}
			ce--;
			for(j=ce;j>=cs;j--){
				System.out.print(matrix[re][j]);
				counter++;
			}
			re--;
			for(i=re;i>=rs;i--){
				System.out.print(matrix[i][cs]);
				counter++;
			}
			cs++;
		}
	}
}