import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class CheckFibonacciMember{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int t1 = 1 , t2 = 1, t3=1;
		boolean flag = false;
		while(t3<N){
			t3 = t1+t2;
			if(t3==N){
				flag = true;
				break;
			}
			t1 = t2;
			t2 = t3;


		}
		System.out.println(flag);
	}
}
