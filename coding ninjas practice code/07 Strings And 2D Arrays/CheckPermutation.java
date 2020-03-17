import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class CheckPermutation{
	public static final int MAX_SIZE = 256;
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		System.out.print(isPermutation(str1,str2));
	}
	public static boolean isPermutation(String str1,String str2){
		if(str1.length() != str2.length())
			return false;
		int arr[] = new int[MAX_SIZE];

		for(int i = 0;i<str1.length();i++){
			char c = str1.charAt(i);
			arr[c]++;
		}
		for(int i = 0;i<str2.length();i++){
			char c = str2.charAt(i);
			arr[c]--;
		}
		for(int i = 0;i<MAX_SIZE;i++)
			if(arr[i]!=0)
				return false;
		return true;
	}
}