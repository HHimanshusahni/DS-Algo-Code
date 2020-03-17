import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class ReverseEachWord{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String updatedStr = reverseEachWord(input);
		System.out.println(updatedStr);
	}
	public static String reverseEachWord(String input){
		String str = "",tempStr = "";
		for(int i =0;i<input.length();i++){
			char ch = input.charAt(i);
			if(ch ==' '){
				str = str +tempStr+ch;

				tempStr = "";
			}else{
				tempStr = ch  + tempStr;
			}
		}
		str = str+tempStr;
		return str;
	}
	
}