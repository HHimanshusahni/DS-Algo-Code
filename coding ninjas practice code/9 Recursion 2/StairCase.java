import java.io.*;
public class StairCase{
	//Recursive approach Recurrence : T(n) = T(n-1) + T(n-2) + T(n-3) Time complexity = T(3^n)
	public static int findWays(int n){
		// Base Case
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(n==3)
			return 4;
		// Recursive Case
		return findWays(n-1) + findWays(n-2) + findWays(n-3);

	}

	

	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(findWays(n));

	}
}