import java.io.*;
public class SumOfDigits{
	public static int sumOfDigits(int input){
		
		return input == 0 ? 0 : input%10 + sumOfDigits(input/10);
	}
	public static void main(String[] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		System.out.println(sumOfDigits(n));
	}
}