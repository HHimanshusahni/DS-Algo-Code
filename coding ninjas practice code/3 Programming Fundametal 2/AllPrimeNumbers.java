import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class AllPrimeNumbers{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// printPrime1(N);
		printPrime2(N);
	}
	static void printPrime1(int N ){
		// time complexity 0(N^2)
		for(int i =2;i<=N;i++){
			boolean flag = false;
			for(int j = 2;j<i;j++){
				if(i%j==0){
					flag = true;
					break;
				}
			}
			if(!flag)
				System.out.println(i);
		}
	}
	static void printPrime2(int N ){
		// time complexity 0(N^(3/2))
		for(int i =2;i<=N;i++){
			boolean flag = false;
			for(int j = 2;j<=Math.sqrt(i);j++){
				if(i%j==0){
					flag = true;
					break;
				}
			}
			if(!flag)
				System.out.println(i);
		}
	}
	static void printPrime2(int N ){
		// time complexity 0(N^(3/2))
		for(int i =2;i<=N;i++){
			boolean flag = false;
			for(int j = 2;j<=Math.sqrt(i);j++){
				if(i%j==0){
					flag = true;
					break;
				}
			}
			if(!flag)
				System.out.println(i);
		}
	}

}