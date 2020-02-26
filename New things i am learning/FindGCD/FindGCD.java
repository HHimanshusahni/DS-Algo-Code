import java.io.*;
//https://www.youtube.com/watch?v=8E1i5l6h22c
public class FindGCD{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
	
		System.out.println(	findGCD(a,b));
	}
	// using euclid's algorithm
	public static int findGCD(int a,int b){
		// if(b==0)
		// 	return a;
		// else
		// 	return findGCD(b,a%b);

		return b==0? a : findGCD(b,a%b);

	}
}