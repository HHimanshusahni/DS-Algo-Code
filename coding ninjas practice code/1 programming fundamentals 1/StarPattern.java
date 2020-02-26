import java.util.Scanner;
public class StarPattern{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i =1 ;i<=n;i++){
			// print spaces
			for(int j=1;j<=n-i;j++){
				System.out.print(" ");
			}
			// print stars
			for(int j=1;j<=(2*i-1);j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}