import java.io.*;
public class CheckPalindrome{
	public static void main(String args[])throws IOException{
		// Scanner s = new Scanner(System.in);
		// String str = s.nextLine();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(checkPalindrome(str));
	}

	// No need to compare after half
	// public static boolean checkPalindrome(String str){
	// 	for(int i=0;i<str.length();i++)
	// 		if(str.charAt(i)!=str.charAt(str.length()-i-1))
	// 			return false;
	// 	return true;
	// }
	// Better way to code approach
	public static boolean checkPalindrome(String str){
		int i = 0;
		int j = str.length()-1;
		while(i<j){
			if(str.charAt(i)!=str.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}