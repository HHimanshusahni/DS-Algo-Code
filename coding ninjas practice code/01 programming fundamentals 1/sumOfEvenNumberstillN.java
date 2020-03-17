//Given a number N, print sum of all even numbers from 1 to N.
import java.util.Scanner;
class sumOfEvenNumbersTillN{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int sum = 0;
		// approach  O(n)
/*		for (int i=0;i<=N;i=i+2){
			sum += i ; 
		}
*/		
		// approach O(1)
		// sum of A.P Sn = (n/2)(2a+(n-1)d)
		int n  =(int)(N/2);
		sum = n*(n+1);

		System.out.println(sum);
		
	}
}