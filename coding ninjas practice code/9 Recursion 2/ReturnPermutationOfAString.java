import java.io.*;
public class ReturnPermutationOfAString{
	public static String[] permutationOfString(String input){
		// Base case
		if(input.length() ==0){
			String output[] = new String[0];
			return output;
		}
		if(input.length() == 1){
			String output[]  = new String[1];
			output[0]  = input;
			return output;
		}

		//Recursive Case
		String[] smallAns = permutationOfString(input.substring(1));

		//Small Calculation
		String ans [] = new String[smallAns.length * input.length()];
		for(int i = 0,counter = 0;i<smallAns.length;i++){
			String str = smallAns[i];
			char ch = input.charAt(0);
			for(int j = 0;j<=str.length();j++){
				ans[counter++] = str.substring(0,j)+ch+str.substring(j);  // important line showing use of substring method
			}

		}

		return ans;
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ans [] = permutationOfString(br.readLine());

		for(String str : ans)
			System.out.println(str);
	}
}