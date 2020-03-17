import java.io.*;
public class PrintKeypad{

	public static void printKeypad(int input){
		printKeypad(input,"");
	}

	public static void printKeypad(int input,String outputSoFar){
		//Base Case
		if(input == 0)
			System.out.println(outputSoFar);

		// Small Calculation
			String str = getOption(input%10);

		// Recursive Case
		for(int i = 0;i<str.length();i++)
			printKeypad( input/10, str.charAt(i)+outputSoFar );
	}

	public static String getOption(int num){
		String arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		return arr[num];

	}

	public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		printKeypad(Integer.parseInt(br.readLine()));

	}
}