import java.util.Scanner;
public class WavePrint{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int arr[][] = new int[n][m];
		for(int i = 0;i<n;i++)
			for(int j = 0;j<m;j++)
				arr[i][j] = s.nextInt();
		wavePrint(arr);
	}
	public static void wavePrint(int input[][]){
		for(int j = 0;j<input[0].length;j++)
		  if(j%2==0)
              for(int i =0;i<input.length;i++)
              	System.out.print(input[i][j]+" ");
		  else
		  	for(int i=input.length-1;i>=0;i--)
		  		System.out.print(input[i][j]+" ");		
	}
}