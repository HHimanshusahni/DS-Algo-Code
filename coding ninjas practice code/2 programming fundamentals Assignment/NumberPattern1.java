import java.util.Scanner;
public class NumberPattern1{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		for(int i = 1 ;i<=N;i++){
			for (int j =1;j<=i;j++){
				System.out.print(1);
			}
			System.out.println();
		}
	}
}