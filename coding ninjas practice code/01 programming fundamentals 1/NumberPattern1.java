import java.util.Scanner;
public class NumberPattern1{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for (int i = 1;i<=N;i++){
			 int x = i;
			for(int j = 1;j<=i;j++){
				System.out.print(x++);
			}
			System.out.println();
		}

	}
}