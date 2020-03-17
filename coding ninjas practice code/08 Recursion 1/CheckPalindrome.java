import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class CheckPalindrome{
	public static boolean isStringPalindrome(String input){
		if(input.length() == 0 || input.length() == 1)
			return true;

		return input.charAt(0)==input.charAt(input.length()-1)  && isStringPalindrome(input.substring(1,input.length()-1));
	}
	public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		System.out.println(isStringPalindrome(s));
	}
}