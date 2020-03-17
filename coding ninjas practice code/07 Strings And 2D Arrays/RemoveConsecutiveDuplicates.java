import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class RemoveConsecutiveDuplicates {
	
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(removeConsecutiveDuplicates_2(str));
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

	//https://www.geeksforgeeks.org/remove-consecutive-duplicates-string/
	public static String removeConsecutiveDuplicates_2(String input) {
		char arr[] = input.toCharArray();
		int i,j=0;
		for( i =1,j=0;i<arr.length;i++){
			if(arr[i]!=arr[j]){
				j++;
				arr[j] = arr[i];
			
			}
		}
		return String.valueOf(arr,0,j+1);
	}
}