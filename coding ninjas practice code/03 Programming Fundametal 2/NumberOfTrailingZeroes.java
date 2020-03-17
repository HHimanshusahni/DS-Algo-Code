import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class NumberOfTrailingZeroes{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(findZeroes(N));

	}
	static int findZeroes(int N){
		int ans = 0;
		int j = 5;
		while(N>=j){
			int i = N/j;
			j=j*5;
			ans +=i;

		}
		
	}
}