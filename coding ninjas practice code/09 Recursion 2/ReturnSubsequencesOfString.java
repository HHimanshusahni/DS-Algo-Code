import java.io.*;
public class ReturnSubsequencesOfString{

	// approach 	s|tring
	public static String[] subsequence(String input){
		//base case
		if(input.length() == 0){
			String output[] = {""};
			return output;
		}
		//Recursive case
		String smallAns[] = subsequence(input.substring(1));
		String ans [] = new String[2*smallAns.length];
		char ch = input.charAt(0);
		int i = 0,j = 0;
		while(i<ans.length){
			ans[i++] = smallAns[j];
			ans[i++] = ch + smallAns[j++];
		} 
		return ans;

	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ans[] = subsequence(br.readLine()); 
		for(String str : ans)
			System.out.println(str);

	}
}
