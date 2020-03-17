import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class ReverseStringWordWise{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String ans = reverseStringWordWise_4(str);
		System.out.println(ans);
	}	
	public static String reverseStringWordWise(String input){
		String reverseInput = "";
		String ans ="";

		for(int i = 0;i<input.length();i++)
			reverseInput = input.charAt(i)+reverseInput;
		String temp = "";
		for(int i = 0;i<reverseInput.length();i++){
			char ch = reverseInput.charAt(i);
			if(ch==' '){
				ans = ans + temp+" ";
				temp = "";
			}else{
				temp = ch+temp;
			}
		}
		ans  = ans +temp;
		return ans;
	}
	public static String reverseStringWordWise_2(String input){
		String word ="",ans = "";
		for(int i = input.length()-1;i>=0;i--){
			char ch = input.charAt(i);
			if(ch == ' '){
				ans = ans + word+" ";
				word = "";
			}else{
				word = ch + word;
			}
		}
		ans = ans+word;
		return ans;
	}
	public static String reverseStringWordWise_3(String input){
		int i = input.length()-1;
		String ans = "";
		int end = input.length();
		while(i>=0){
			if(input.charAt(i)==' '){
				ans = ans + input.substring(i+1,end)+" ";
				end = i;
			}
			i--;;
		}
		ans = ans +input.substring(0,end);
		return ans;
	}
	public static String reverseStringWordWise_4(String input){
		String arr[] = input.split(" ");
		String ans ="";
		for(int i = arr.length-1;i>=0;i--)
			ans = ans + arr[i]+" ";
		return ans;
	}
	//Note we can also use stack for the problem
}