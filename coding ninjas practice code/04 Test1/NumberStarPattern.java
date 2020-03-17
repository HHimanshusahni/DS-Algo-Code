import java.io.*;
public class NumberStarPattern{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i =1 ;i<=5;i++){
			//increasing order
			for(int j = 1;j<=N-i+1;j++){
				System.out.print(j);
			}
			//stars
			for(int j =1;j<=2*(i-1);j++){
				System.out.print("*");
			}
			//decreasing order
			for(int j = N-i+1;j>=1;j--){
				System.out.print(j);
			}
			System.out.println();
		}
	}
}