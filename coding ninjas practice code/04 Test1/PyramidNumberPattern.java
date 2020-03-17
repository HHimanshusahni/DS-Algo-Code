import java.io.*;
public class PyramidNumberPattern{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i =1;i<=N;i++){
			//spaces
			for(int j = 1;j<=N-i;j++){
				System.out.print(" ");
			}
			//decreasing sequence
			for(int j = 1;j<=i-1;j++){
				System.out.print(i-j+1);
			}
			//increasing sequence
			for(int j = 1;j<=i;j++){
				System.out.print(j);
			}
			System.out.println();

		}
	}
}