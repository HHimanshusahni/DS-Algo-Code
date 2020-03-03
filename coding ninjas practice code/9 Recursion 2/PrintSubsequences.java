import java.io.*;
public class PrintSubsequences{
	public static void printSubsequences(String input){
		printSubsequences(input,"");
	}
	public static void printSubsequences(String input,String outPutSoFar){
		// base Case
		if(input.length() == 0){
			System.out.println(outPutSoFar);
			return;
		}
		//Recursive case
		
		// we don't include the first letter of the string in the output
		printSubsequences(input.substring(1),outPutSoFar);

		// we include the first letter of the input in the output
		printSubsequences(input.substring(1),outPutSoFar+input.charAt(0));

		

	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		printSubsequences(br.readLine());
	}
}