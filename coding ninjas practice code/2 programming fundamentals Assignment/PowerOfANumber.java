import java.util.Scanner;
public class PowerOfANumber{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int n = s.nextInt();
		long ans=1;
		for(int i =1;i<=n;i++){
			ans = ans*x;
		}
		System.out.println(ans);
	}
}