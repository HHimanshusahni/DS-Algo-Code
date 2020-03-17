import java.util.Scanner;
class TriangleOfNumbers{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i = 1;i<=N;i++){
			//print spaces
			for(int j=1;j<=N-i;j++){
				System.out.print(' ');
			}
			int value = i;
			//print increasing sequence
			for(int j = 1;j<=i;j++ ){
				System.out.print(value++);
			}
			// print decreasing sequenece
			value--;
			for(int j = 1;j<=i-1;j++ ){
				System.out.print(--value);
			}
			System.out.println();

		}
	}
}