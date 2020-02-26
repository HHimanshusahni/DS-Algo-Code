import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class RemoveConsecutiveDuplicates {
	
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(removeConsecutiveDuplicates(str));
	}
	public static String removeConsecutiveDuplicates(String input) {
		String ans ="";
		int i =0;
		for( i = 0;i<input.length()-1;i++){
			if(input.charAt(i)!=input.charAt(i+1))
				ans = ans+input.charAt(i);
		}
			ans = ans + input.charAt(i);
		return ans;
	}
}