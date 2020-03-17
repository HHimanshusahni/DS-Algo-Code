import java.io.*;
public class SumOfNNaturalNumbers{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(sum(n));
	}
	 // 0(n) solution 
	public static int sum (int n ){
		if(n==1)
			return 1;
		return n + sum(n-1);
	}	
    // 0(1) solution using the formulate n
}