import java.util.Scanner;
public class SumOfEvenAndOdd{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int sumEven = 0 , sumOdd = 0;
		while(N>0){
			int digit = N%10;
			if(digit%2==0)
				sumEven += digit;
			else
				sumOdd += digit;
			N /= 10;
		}
		System.out.println(sumEven+" "+sumOdd);

	}	
}