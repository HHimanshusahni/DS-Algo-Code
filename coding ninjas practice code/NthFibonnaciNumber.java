import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class NthFibonnaciNumber{
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		fib(N);
	}
	static void fib(int N ){
		// fib(n) = fib(n-1) + fib(n-2)
		// fib(1) = 1 fib(2) = 2

		int t1 = 1,t2 = 2,t3;
		if(N==1)
			System.out.print(t1);
		else if(N==2)
			System.out.println(t2);
		else{
			
			for(int i = 3;i<=N-2;i++){
				t3 = t1+t2;
				t1 = t2;
				t2 = t3;
				System.out.print(t3+" ");
			}
			System.out.println(t3);
		}

	}
}