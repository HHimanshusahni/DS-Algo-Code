import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class NthFibonnaciNumber{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		fib(N);
	}
	static void fib(int N ){
		
		if(N==1||N==2)
			System.out.print(1);
		else{
			int t1 = 1,t2 = 1,t3 =0;
			for(int i = 1;i<=N-2;i++){
				t3 = t1+t2;
				t1 = t2;
				t2 = t3;
			}
			System.out.println(t3);
		}

	}
}