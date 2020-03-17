import java.util.Scanner;
public class NumberPattern5{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		pattern(N);
	}
	static void pattern(int N ){
		for(int i =0;i<N;i++){
			for(int j = 1;j<=N-i;j++){
				System.out.print(j);
			}
			System.out.println();
		}
	}
}