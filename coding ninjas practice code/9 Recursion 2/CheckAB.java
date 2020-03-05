import java.io.*;
public class CheckAB{
	public static boolean checkAB(String input){
		// Base case
		if(input.length() == 0)
			return true;
		// Recursive case and small caluculation
		if(input.charAt(0)=='a')
			if(input.length()>=3 && input.charAt(1) =='b' && input.charAt(2) == 'b')
				return checkAB(input.substring(3));
			else
				return checkAB(input.substring(1));
		else
			return false;
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(checkAB(br.readLine()));
	}
}