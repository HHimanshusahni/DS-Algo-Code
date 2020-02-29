import java.io.*;
public class MultiplicationRecursive{

	public static int multiplyTwoIntegers(int m, int n){
		return n == 0 ? 0 : m + multiplyTwoIntegers(m,n-1);  
	}

	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		System.out.println(multiplyTwoIntegers(m,n));

	}
}