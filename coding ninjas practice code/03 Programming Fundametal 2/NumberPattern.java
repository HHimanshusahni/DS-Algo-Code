import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class NumberPattern{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++){
			int k = N-i+1;
			for(int j =1;j<=N;j++){
			   System.out.print(k);
				if(k!=N)
				   k++;
			}
			System.out.println();
		}

	}
}