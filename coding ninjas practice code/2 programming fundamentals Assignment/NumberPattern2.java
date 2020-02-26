import java.util.Scanner;
public class NumberPattern2{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		pattern(N);
	}
	static void pattern(int N ){
		for(int i = 1;i<=N;i++){
			if(i==1){
				System.out.println(1);
			}else{
				//First Number
					System.out.print(i-1);
				// zeros
					for(int j=1;j<=i-2;j++){
						System.out.print(0);
					}
				// Last Number
					System.out.println(i-1);
			}
		}
	}
}