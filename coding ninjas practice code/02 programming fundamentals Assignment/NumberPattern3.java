import java.util.Scanner;
public class NumberPattern3{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		patternPrint(N);
	}


	static void patternPrint(int N ){
		for(int i = 1;i<=N;i++){
			if(i==1)
				System.out.println(1);
			else{
				System.out.print(1);
				for(int j = 1;j<=i-2;j++){
					System.out.print(2);
				}

				System.out.println(1);
			}
		}
	}
}