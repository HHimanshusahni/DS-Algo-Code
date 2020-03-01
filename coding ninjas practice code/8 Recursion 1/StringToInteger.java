import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class StringToInteger{
	// approach 1 			123|4  T(n) = T(n-1)+1
	public static int convertStringToInt(String input){
	
		if(input.length()==1)
			return Integer.parseInt(input.charAt(0)+"");

		int smallAns = convertStringToInt(input.substring(0,input.length()-1));
		int ans = smallAns * 10 + Integer.parseInt(input.charAt(input.length()-1)+"");
		return ans;

	}
	// approach 2   1|234    T(n) = T(n-1)+1
	public static int convertStringToInt_2(String input){
		if(input.length() == 1)
			return input.charAt(0)-'0';
		int smallAns = convertStringToInt_2(input.substring(1));

		int ans = smallAns + (input.charAt(0)-'0') * ((int)Math.pow(10,input.length()-1));
		return ans ;

	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(convertStringToInt_2(input));

	}

}