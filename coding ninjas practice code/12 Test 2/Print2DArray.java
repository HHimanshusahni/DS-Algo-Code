import java.io.*;
public class Print2DArray{
	public static void print(int input[][]){
		int N = input.length;
		int M = input[0].length;
		for(int i = 0;i<N;i++){
			for(int j = 0;j<M;j++){
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int input[][] = new int[N][M];
		for(int i = 0;i<N;i++){
			for(int j = 0;j<M;j++){
				input[i][j] = Integer.parseInt(br.readLine());
			}
		}
		print(input);
	}
}