import java.util.Scanner;
public class NumberPattern2{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int value;
		for(int i = 1 ;i<=N;i++){
			// print spaces
			for(int j = 1;j<=(N-i);j++){
				System.out.print(" ");
			}
			value = i ;
			for(int j =1 ;j<=i;j++){
				System.out.print(value++);
			}
			System.out.println();
		}
	}
}