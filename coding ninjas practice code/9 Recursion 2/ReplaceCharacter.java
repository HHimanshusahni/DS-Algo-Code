import java.io.*;
public class ReplaceCharacter{
	// approch 		s|tring
	public static String replaceCharacter(String input, char c1, char c2) {
		// base case
		if(input.length() == 0)
			return "";
		// Recursive case
		String smallAns = replaceCharacter(input.substring(1), c1,c2);
		return input.charAt(0) == c1 ? c2+smallAns : input.charAt(0)+smallAns; 

	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char c1 = br.readLine().charAt(0);
		char c2 = br.readLine().charAt(0);
		System.out.println(replaceCharacter(input,c1,c2));
	}
}